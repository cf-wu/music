package com.cfwu.music5.model;

import com.cfwu.music5.bean.SongBillListBean;

import rx.Observer;

/**
 * Created by cfwu on 17-12-13.
 */
public interface IFragment2Model {
    void getData(int type,int num,int offset,Observer<SongBillListBean> callback);
}
