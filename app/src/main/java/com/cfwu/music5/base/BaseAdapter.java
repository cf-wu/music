package com.cfwu.music5.base;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by cfwu on 17-12-8.
 */
public abstract class BaseAdapter<T>  extends PagerAdapter {
    protected List<T> mDataList;
    protected Context mContext;
    public BaseAdapter(Context context,List<T> data){
        this.mDataList=data;
        this.mContext=context;
    }
    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
