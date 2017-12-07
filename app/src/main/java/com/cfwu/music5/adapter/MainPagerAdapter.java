package com.cfwu.music5.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cfwu on 17-12-7.
 */
public class MainPagerAdapter extends PagerAdapter {
    private ArrayList<View> mListData;
    private Context mContext;
    public MainPagerAdapter(Context context){
        this.mContext=context;
        mListData=new ArrayList<>();
        for(int i=0;i<5;i++){
            TextView textView=new TextView(context);
            textView.setText("pager"+i);
            mListData.add(textView);
        }
    }
    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=mListData.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView(mListData.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        TextView textView= (TextView) mListData.get(position);
        return textView.getText();
    }
}
