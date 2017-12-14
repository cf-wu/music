package com.cfwu.music5.presenter.impl;

import com.cfwu.music5.bean.SongBillListBean;
import com.cfwu.music5.model.impl.PlayViewModelmpl;
import com.cfwu.music5.presenter.IPlayViewPresenter;
import com.cfwu.music5.view.impl.PlayView;

import rx.Observer;

/**
 * Created by cfwu on 17-12-14.
 */
public class PlayViewPresenterImpl implements IPlayViewPresenter {
    private PlayView mView;
    private PlayViewModelmpl model;
    public PlayViewPresenterImpl(PlayView view){
        mView=view;
        model=new PlayViewModelmpl();
    }

    private void dealData(){
        model.getData(1, 10, 0, new Observer<SongBillListBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(SongBillListBean songBillListBean) {
                mView.showData(songBillListBean);
            }
        });
    }

    @Override
    public void onCreat() {
        dealData();
    }


}
