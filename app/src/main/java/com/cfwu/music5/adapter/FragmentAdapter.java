package com.cfwu.music5.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cfwu.music5.fragments.Fragment1;
import com.cfwu.music5.fragments.Fragment2;
import com.cfwu.music5.fragments.Fragment3;
import com.cfwu.music5.fragments.Fragment4;
import com.cfwu.music5.fragments.Fragment5;

/**
 * Created by cfwu on 17-12-12.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    private String[] titles=new String[]{"推荐","排行","电台","MV","我的"};
    android.support.v4.app.Fragment[] fragments=new android.support.v4.app.Fragment[5];


    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        fragments[0]=new Fragment1();
        fragments[1]=new Fragment2();
        fragments[2]=new Fragment3();
        fragments[3]=new Fragment4();
        fragments[4]=new Fragment5();
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
