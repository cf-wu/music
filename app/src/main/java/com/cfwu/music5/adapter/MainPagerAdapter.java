package com.cfwu.music5.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cfwu.music5.base.BaseAdapter;

import java.util.List;

/**
 * Created by cfwu on 17-12-7.
 */
public class MainPagerAdapter extends BaseAdapter {
    private String[] titles=new String[]{"推荐","排行","电台","MV","我的"};

    public MainPagerAdapter(Context context, List list) {
        super(context, list);
        for(int i=0;i<titles.length;i++){
            TextView textView=new TextView(context);
            textView.setText("pager"+i);
            mDataList.add(textView);
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=(TextView) mDataList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title=titles[position];
        return title;
    }
}
