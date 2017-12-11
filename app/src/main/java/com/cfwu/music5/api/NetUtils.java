package com.cfwu.music5.api;

import com.cfwu.music5.bean.PaySongBean;
import com.cfwu.music5.bean.SongBillListBean;
import com.cfwu.music5.utils.LogUtils;

import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cfwu on 17-12-11.
 */
public class NetUtils {
    private OkHttpClient mClient;
    private static NetUtils instance=null;
    public static NetUtils getInstance(){
        if (instance==null){
            synchronized (NetUtils.class){
                if (instance==null){
                    instance=new NetUtils();
                }
            }
        }
        return instance;
    }
    private NetUtils(){}

    public void getPaySongData(String SongId, NetCallBack<PaySongBean> callback) {
        Map<String, String> params = NetHelper.getMusicApiBasicParams("baidu.ting.song.play");
        params.put("songid",SongId);
        creatMusicApi().getPaySongData(params).enqueue(callback);
    }


    public void getSongListData(){

    }

    /**
     * @param type 1-新歌榜,2-热歌榜,11-摇滚榜,12-爵士,16-流行,21-欧美金曲榜,22-经典老歌榜,23-情歌对唱榜,24-影视金曲榜,25-网络歌曲榜
     * @param size  返回条目数量
     * @param offset 获取偏移
     */
    public void getSongBillListData(int type, int size, int offset,NetCallBack<SongBillListBean> callback) {
        Map<String, String> params = NetHelper.getMusicApiBasicParams("baidu.ting.billboard.billList");
        params.put("type", String.valueOf(type));
        params.put("size", String.valueOf(size));
        params.put("offset", String.valueOf(offset));
        creatMusicApi()
                .getSongBillListData(params).enqueue(callback);

    }




    private Retrofit mRetrofit;
    private MusicApi mMusicApi;

    private MusicApi creatMusicApi() {
        if (mClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            if (LogUtils.DEBUG){
                builder.addNetworkInterceptor(new AGLogInterceptor());
            }
            mClient = builder.build();
        }
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(MusicApi.MUSIC_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(mClient)
                    .build();

        }
        if (mMusicApi == null){
            mMusicApi=mRetrofit.create(MusicApi.class);
        }
        return mMusicApi;
    }

}
