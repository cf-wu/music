package com.cfwu.music5.adapter;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cfwu.music5.MusicPlayActivity;
import com.cfwu.music5.R;
import com.cfwu.music5.base.BaseFragment;
import com.cfwu.music5.bean.SongListBean;
import com.cfwu.music5.fragments.Fragment1;
import com.cfwu.music5.utils.LogUtils;

import java.util.List;

/**
 * Created by cfwu on 17-12-12.
 */
public class RecycAdapter extends RecyclerView.Adapter<RecycAdapter.ViewH> {

    private List<SongListBean> mDataNew;
    private View mItemView;
    private BaseFragment mContext;
    private int ItemClickNum=1;
    private int perClickItem=-1;
    private int recordNum=-1;
    public RecycAdapter(List<SongListBean> mData, Fragment1 context) {
        this.mDataNew = mData;
        this.mContext=context;
    }

    @Override
    public ViewH onCreateViewHolder(ViewGroup viewGroup,  int i) {
        mItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_recyc_iten, viewGroup, false);
        ViewH viewH = new ViewH(mItemView);
        return viewH;
    }

    @Override
    public void onBindViewHolder(ViewH viewH, final int i) {
        final SongListBean bean= mDataNew.get(i);
        String url=bean.pic_small.split("@")[0];
        LogUtils.Log_D(this,"当前recycview显示的图片链接"+url);
        Glide
                .with(mContext)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513230144933&di=17b7a3442fd599220067781eb14809a5&imgtype=0&src=http%3A%2F%2Fimg.lenovomm.com%2Fs3%2Fimg%2Fapp%2Fapp-img-lestore%2F2370-2015-07-16035439-1437033279327.jpg%3FisCompress%3Dtrue%26width%3D320%26height%3D480%26quantity%3D1%26rotate%3Dtrue")
                .error(R.mipmap.ic_launcher)
                .thumbnail(0.1F)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(viewH.iv);
        viewH.tv1.setText(bean.title);
        viewH.tv2.setText("(专辑："+bean.album_title+")");//专辑
        viewH.tv3.setText(bean.artist_name);//songer
        mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实现第一次点击播放，第二次点击同一个item跳转
                if (i != perClickItem && ItemClickNum == 2){
                    ItemClickNum=1;
                }
                perClickItem=i;
                switch (ItemClickNum){
                    case 1:
                        //点击第一次播放并更新viewpager
                        ((Fragment1)mContext).mPlayView.updateData(mDataNew,i);
                        ItemClickNum++;
                        break;
                    case 2:
                        //点击第二次跳转到播放音乐界面
                        Intent intent;
                        intent = new Intent(mContext.getActivity(), MusicPlayActivity.class);
                        intent.putExtra("musicBean",bean);
                        mContext.startActivity(intent);
                        break;
                }
            }
        });
        viewH.ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.Log_D(this,"option 被点击了");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataNew.size();
    }

    class ViewH extends RecyclerView.ViewHolder {
        public ImageView iv;
        public TextView tv1;
        public TextView tv2;
        public TextView tv3;
        public ImageButton ibtn;
        public ViewH(View itemView) {
            super(itemView);
            this.iv = (ImageView) itemView.findViewById(R.id.recyc_image);
            this.tv1 = (TextView) itemView.findViewById(R.id.recyc_tv_1);
            this.tv2 = (TextView) itemView.findViewById(R.id.recyc_tv_2);
            this.tv3 = (TextView) itemView.findViewById(R.id.recyc_tv_3);
            this.ibtn= (ImageButton) itemView.findViewById(R.id.recyc_option);
        }
    }
}
