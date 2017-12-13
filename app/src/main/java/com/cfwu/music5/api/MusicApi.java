package com.cfwu.music5.api;

import com.cfwu.music5.bean.PaySongBean;
import com.cfwu.music5.bean.RecommandSongListBean;
import com.cfwu.music5.bean.SearchSongBean;
import com.cfwu.music5.bean.SongBillListBean;
import com.cfwu.music5.bean.SongLrcBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;


/**
 * Created by cfwu on 17-12-11.
 */
public interface MusicApi {
    String MUSIC_BASE_URL = "http://tingapi.ting.baidu.com/";
    String SUB_URL = "v1/restserver/ting";

    @GET(SUB_URL)
    Observable<PaySongBean> getPaySongData(@QueryMap Map<String,String> params);

    @GET(SUB_URL)
    Observable<SongBillListBean> getSongBillListData(@QueryMap(encoded = false) Map<String,String> parmas);

    @GET(SUB_URL)
    Observable<SearchSongBean> searchSong(@QueryMap Map<String,String> params);

    @GET(SUB_URL)
    Observable<SongLrcBean> getSongLrc(@QueryMap Map<String,String> params);

    @GET(SUB_URL)
    Observable<RecommandSongListBean> getRecommandSongList(@QueryMap Map<String,String> params);

    @GET(SUB_URL)
    Observable getDownload(@QueryMap Map<String,String> params);

    @GET(SUB_URL)
    Observable getSonger(@QueryMap Map<String,String> params);

    @GET(SUB_URL)
    Observable getSongerOfSong(@QueryMap Map<String,String> params);
}
