package com.cfwu.music5.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cfwu.music5.R;
import com.cfwu.music5.base.BaseAdapter;
import com.cfwu.music5.bean.Song;
import com.cfwu.music5.utils.LogUtils;
import com.cfwu.music5.widget.ImageViewPlus;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cfwu on 17-12-8.
 */
public class PlayViewAdapter extends BaseAdapter {
    private LinkedList<View> mCacheView=new LinkedList();

    public PlayViewAdapter(Context context, List mDataList) {
        super(context, mDataList);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LogUtils.Log_D(this,"instantiateItem position="+position);
        ViewH viewH=null;
        View view=null;
        if(mCacheView.size()==0 ){
            viewH=new ViewH();
            view= View.inflate(mContext, R.layout.palyer_viewpager_item, null);
            LogUtils.Log_D(this,"instantiateItem size=0 viewH="+viewH+"-------------------------view="+view);
            viewH.iv_song = (ImageViewPlus) view.findViewById(R.id.iv_song);
            viewH.tv_name= (TextView) view.findViewById(R.id.tv_song_name);
            viewH.tv_singer= (TextView) view.findViewById(R.id.tv_song_singer);
            view.setTag(viewH);
        }else{
            LogUtils.Log_D(this,"instantiateItem size==="+mCacheView.size());
            view=mCacheView.removeFirst();
            viewH= (ViewH) view.getTag();
            LogUtils.Log_D(this,"instantiateItem size==="+mCacheView.size()+"---viewH="+viewH+"view="+view);


        }
        Song song= (Song) mDataList.get(position);
        viewH.iv_song.setImageResource(song.getSrcRid());
        viewH.tv_name.setText(song.getNameSong());
        viewH.tv_singer.setText(song.getSinger());
        LogUtils.Log_D(this,"instantiateItem viewH.tv_singer="+viewH.tv_singer);
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
        ImageView iv_song;
        TextView tv_name;
        TextView tv_singer;
    }

}
