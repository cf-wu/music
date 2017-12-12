package com.cfwu.music5.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.cfwu.music5.R;
import com.cfwu.music5.adapter.RecycAdapter;
import com.cfwu.music5.api.NetCallBack;
import com.cfwu.music5.api.NetUtils;
import com.cfwu.music5.base.BaseFragment;
import com.cfwu.music5.bean.SongBillListBean;
import com.cfwu.music5.bean.SongListBean;
import com.cfwu.music5.utils.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cfwu on 17-12-12.
 */
public class Fragment2 extends BaseFragment{
    private View mRootView;
    private RecyclerView mRecyclerView;
    private EditText mEditText;
    private ImageButton mImageButton;
    private RecyclerView.Adapter mAdapter;
    private List<SongListBean> mDataNew = new ArrayList();
    private List<SongListBean> mDataHot = new ArrayList();
    private List<SongListBean> mDataRoll = new ArrayList();
    private HashMap<String,List<SongListBean>> mData=new HashMap<>();
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.layout_fragment2, container, false);
        initView();
        return mRootView;
    }

    private void initView() {
        mEditText= (EditText) mRootView.findViewById(R.id.et_search);
        mImageButton= (ImageButton) mRootView.findViewById(R.id.ibtn_search);
        mRecyclerView= (RecyclerView) mRootView.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter=new RecycAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        mData.put("new",mDataNew);
        mData.put("hot",mDataHot);
        mData.put("roll",mDataRoll);
        NetUtils.getInstance().getSongBillListData(1, 20, 0, new NetCallBack<SongBillListBean>() {
            @Override
            public void onSuccess(SongBillListBean songBillListBean) {
                for (SongListBean song:songBillListBean.song_list){
                    mDataNew.add(song);
                }
            }

            @Override
            public void onFailure(String errorMsg) {
                LogUtils.Log_D(this,"get data fail:"+errorMsg.toString());
            }
        });
        NetUtils.getInstance().getSongBillListData(2, 20, 0, new NetCallBack<SongBillListBean>() {
            @Override
            public void onSuccess(SongBillListBean songBillListBean) {
                for (SongListBean song:songBillListBean.song_list){
                    mDataHot.add(song);
                }
            }

            @Override
            public void onFailure(String errorMsg) {
                LogUtils.Log_D(this,"get data fail:"+errorMsg.toString());
            }
        });
        NetUtils.getInstance().getSongBillListData(11, 20, 0, new NetCallBack<SongBillListBean>() {
            @Override
            public void onSuccess(SongBillListBean songBillListBean) {
                for (SongListBean song:songBillListBean.song_list){
                    mDataRoll.add(song);
                }
            }

            @Override
            public void onFailure(String errorMsg) {
                LogUtils.Log_D(this,"get data fail:"+errorMsg.toString());
            }
        });


    }
}
