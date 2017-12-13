package com.cfwu.music5.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cfwu.music5.R;
import com.cfwu.music5.base.BaseFragment;
import com.cfwu.music5.bean.SongListBean;
import com.cfwu.music5.fragments.Fragment2;
import com.cfwu.music5.utils.LogUtils;

import java.util.List;

/**
 * Created by cfwu on 17-12-12.
 */
public class RecycAdapter extends RecyclerView.Adapter<RecycAdapter.ViewH> {

    private List<SongListBean> mDataNew;
    private View mItemView;
    private BaseFragment mContext;
    public RecycAdapter(List<SongListBean> mData, Fragment2 context) {
        this.mDataNew = mData;
        this.mContext=context;
    }

    @Override
    public ViewH onCreateViewHolder(ViewGroup viewGroup, int i) {
        mItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_recyc_iten, viewGroup, false);
        return new ViewH(mItemView);
    }

    @Override
    public void onBindViewHolder(ViewH viewH, int i) {
        SongListBean bean= mDataNew.get(i);
        String url=bean.pic_small.split("@")[0];
        LogUtils.Log_D(this,url);
        Glide.with(mContext).load(url).into(viewH.iv);
        viewH.tv1.setText(bean.title);
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

        public ViewH(View itemView) {
            super(itemView);
            this.iv = (ImageView) itemView.findViewById(R.id.recyc_image);
            this.tv1 = (TextView) itemView.findViewById(R.id.recyc_tv_1);
            this.tv2 = (TextView) itemView.findViewById(R.id.recyc_tv_2);
            this.tv3 = (TextView) itemView.findViewById(R.id.recyc_tv_3);

        }
    }
}
