package com.cfwu.music5.model.impl;

import com.cfwu.music5.api.NetUtils;
import com.cfwu.music5.bean.SongBillListBean;
import com.cfwu.music5.model.IPlayViewModel;

import rx.Observer;

/**
 * Created by cfwu on 17-12-14.
 */
public class PlayViewModelmpl implements IPlayViewModel {

    @Override
    public void getData(int type, int num, int offset, Observer<SongBillListBean> callback) {
        NetUtils.getInstance().getSongBillListData(type,num,offset,callback);
    }
}
