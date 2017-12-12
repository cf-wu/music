package com.cfwu.music5;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.cfwu.music5.api.NetCallBack;
import com.cfwu.music5.api.NetUtils;
import com.cfwu.music5.bean.PaySongBean;
import com.cfwu.music5.bean.SongBillListBean;
import com.cfwu.music5.utils.LogUtils;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest() {
        super(Application.class);
    }
    public void testGetPay(){
        NetUtils.getInstance().getPaySongData("877578", new NetCallBack<PaySongBean>() {
            @Override
            public void onSuccess(PaySongBean paySongBean) {
                LogUtils.Log_D(this,paySongBean.songinfo.toString());
            }

            @Override
            public void onFailure(String errorMsg) {
                LogUtils.Log_D(this,errorMsg.toString());
            }
        });
    }
    public void testGetBillList(){
        NetUtils.getInstance().getSongBillListData(1, 1, 1, new NetCallBack<SongBillListBean>() {
            @Override
            public void onSuccess(SongBillListBean songBillListBean) {
                LogUtils.Log_D(this,songBillListBean.toString());
            }

            @Override
            public void onFailure(String errorMsg) {
                LogUtils.Log_D(this,errorMsg.toString());
            }

        });
    }
}