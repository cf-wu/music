package com.cfwu.music5.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cfwu.music5.R;
import com.cfwu.music5.base.BaseFragment;

/**
 * Created by cfwu on 17-12-12.
 *
 */
public class Fragment2 extends BaseFragment{
    private Button mButton;
    private TextView mTv;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment1, container, false);
        mButton= (Button) view.findViewById(R.id.bt_loadata);
        mTv= (TextView) view.findViewById(R.id.tv_data_display);
        initListener();
        return view;
    }

    private void initListener() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
