package com.cfwu.music5.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cfwu.music5.R;
import com.cfwu.music5.base.BaseAdapter;
import com.cfwu.music5.bean.SongListBean;
import com.cfwu.music5.utils.LogUtils;
import com.cfwu.music5.widget.ImageViewPlus;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cfwu on 17-12-8.
 */
public class PlayViewAdapter extends BaseAdapter {
    private LinkedList<View> mCacheView=new LinkedList();

    public PlayViewAdapter(Context context, List<SongListBean> data) {
        super(context, data);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LogUtils.Log_D(this,"instantiateItem position="+position);
        ViewH viewH=null;
        View view=null;
        if(mCacheView.size()==0 ){
            viewH=new ViewH();
            view= View.inflate(mContext, R.layout.palyer_viewpager_item, null);
            viewH.iv_song = (ImageViewPlus) view.findViewById(R.id.iv_song);
            viewH.tv_name= (TextView) view.findViewById(R.id.tv_song_name);
            viewH.tv_singer= (TextView) view.findViewById(R.id.tv_song_singer);
            view.setTag(viewH);
        }else{
            view=mCacheView.removeFirst();
            viewH= (ViewH) view.getTag();
        }
        SongListBean song= (SongListBean) mDataList.get(position);
        Glide
                .with(mContext)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513230144933&di=17b7a3442fd599220067781eb14809a5&imgtype=0&src=http%3A%2F%2Fimg.lenovomm.com%2Fs3%2Fimg%2Fapp%2Fapp-img-lestore%2F2370-2015-07-16035439-1437033279327.jpg%3FisCompress%3Dtrue%26width%3D320%26height%3D480%26quantity%3D1%26rotate%3Dtrue")
                .error(R.mipmap.ic_launcher)
                .thumbnail(0.1F)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(viewH.iv_song);
        viewH.tv_name.setText(song.title);
        viewH.tv_singer.setText(song.artist_name);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view =(View) object;
        LogUtils.Log_D(this,"destroyItem-->"+view);
        container.removeView(view);
        mCacheView.add(view);
    }

    class ViewH {
        ImageViewPlus iv_song;
        TextView tv_name;
        TextView tv_singer;
    }

}
