package com.cfwu.music5.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cfwu.music5.R;
import com.cfwu.music5.base.BaseFragment;

/**
 * Created by cfwu on 17-12-12.
 */
public class Fragment3 extends BaseFragment{
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment3, container, false);
        return view;
    }
}
