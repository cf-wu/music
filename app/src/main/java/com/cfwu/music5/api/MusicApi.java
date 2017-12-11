package com.cfwu.music5.api;

import com.cfwu.music5.bean.PaySongBean;
import com.cfwu.music5.bean.SongBillListBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


/**
 * Created by cfwu on 17-12-11.
 */
public interface MusicApi {
    String MUSIC_BASE_URL = "http://tingapi.ting.baidu.com/";
    String SUB_URL = "v1/restserver/ting";

    @GET(SUB_URL)
    Call<PaySongBean> getPaySongData(@QueryMap Map<String,String> parmas);


    @GET(SUB_URL)
    Call<SongBillListBean> getSongBillListData(@QueryMap Map<String,String> parmas);
}
