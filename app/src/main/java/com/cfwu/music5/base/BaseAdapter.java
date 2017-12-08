package com.cfwu.music5.base;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by cfwu on 17-12-8.
 */
public abstract class BaseAdapter  extends PagerAdapter {
    protected List mDataList;
    protected Context mContext;
    public BaseAdapter(Context context,List mDataList){
        this.mDataList=mDataList;
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
