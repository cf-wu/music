package com.cfwu.music5.presenter.impl;

import android.view.View;

import com.cfwu.music5.bean.SongBillListBean;
import com.cfwu.music5.bean.SongListBean;
import com.cfwu.music5.fragments.Fragment2;
import com.cfwu.music5.model.IFragment2Model;
import com.cfwu.music5.model.impl.Fragment2Modelmpl;
import com.cfwu.music5.presenter.IFragment2Presenter;
import com.cfwu.music5.utils.LogUtils;
import com.cfwu.music5.view.IFragment2View;

import rx.Observer;

/**
 * Created by cfwu on 17-12-13.
 */
public class Fragment2PresenterImpl implements IFragment2Presenter {

    private Fragment2 mView;
    private IFragment2Model mModel;

    public Fragment2PresenterImpl(IFragment2View view){
        mView= (Fragment2) view;
        mModel=new Fragment2Modelmpl();
    }



    private void getRecyclerData(){
        mModel.getData(1, 50, 0, new Observer<SongBillListBean>() {
            @Override
            public void onCompleted() {
                LogUtils.Log_D(this,"onCompleted");
                mView.mProgressBar.setVisibility(View.GONE);
                mView.mErrorLayout.setVisibility(View.GONE);
                mView.mRootLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(Throwable throwable) {
                mView.mProgressBar.setVisibility(View.GONE);
                mView.mErrorLayout.setVisibility(View.VISIBLE);
                mView.mRootLayout.setVisibility(View.GONE);
                LogUtils.Log_D(this,"onError"+throwable.getMessage());

            }

            @Override
            public void onNext(SongBillListBean songBillListBean) {
                if (songBillListBean==null){
                    LogUtils.Log_D(this,"onNext songBillListBean==null");
                    return;
                }
                LogUtils.Log_D(this,"onNext songBillListBean"+songBillListBean.error_code);
                for (SongListBean list:songBillListBean.song_list){
                    LogUtils.Log_D(this,list.toString());
                }

                mView.mProgressBar.setVisibility(View.GONE);
                mView.mErrorLayout.setVisibility(View.GONE);
                mView.mRootLayout.setVisibility(View.VISIBLE);
                mView.showData(songBillListBean);
            }
        });
    }

    @Override
    public void OnCreat() {
        getRecyclerData();
    }

    @Override
    public void reLoadData() {
        mView.mProgressBar.setVisibility(View.VISIBLE);
        mView.mErrorLayout.setVisibility(View.GONE);
        mView.mRootLayout.setVisibility(View.GONE);
        getRecyclerData();
    }
}
