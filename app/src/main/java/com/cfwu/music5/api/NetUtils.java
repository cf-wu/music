package com.cfwu.music5.api;

import com.cfwu.music5.bean.PaySongBean;
import com.cfwu.music5.bean.RecommandSongListBean;
import com.cfwu.music5.bean.SearchSongBean;
import com.cfwu.music5.bean.SongBillListBean;
import com.cfwu.music5.bean.SongLrcBean;
import com.cfwu.music5.utils.LogUtils;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cfwu on 17-12-11.
 */
public class NetUtils {
    private OkHttpClient mClient;
    private static NetUtils instance=null;
    private NetUtils(){}
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
    /**
    参数： tinguid = 877578//歌手ting id

          limits = 6//返回条目数量
     */
    public void getSongerOfSong(String tinguid,String limits ,String use_cluster,String order,NetCallBack callBack){
        Map<String, String> params = NetHelper.getMusicApiBasicParams("baidu.ting.artist.getSongList");
        params.put("tinguid",tinguid);
        params.put("limits",limits);
        params.put("use_cluster",use_cluster);
        params.put("order",order);

        creatMusicApi().getSongerOfSong(params).enqueue(callBack);

    }
    /**


    例：method=baidu.ting.artist.getInfo&tinguid=877578

    参数： tinguid = 877578 //歌手ting id

     */
    public void getSongerData(String tinguid,NetCallBack callBack){
        Map<String, String> params = NetHelper.getMusicApiBasicParams("baidu.ting.artist.getInfo");
        params.put("tinguid",tinguid);
        creatMusicApi().getSonger(params).enqueue(callBack);

    }


    /**
    下载
   参数： songid = 268425156//歌曲id

    bit = 24, 64, 128, 192, 256, 320 ,flac//码率

    time = 1430215999,, //时间戳
     */
    public void download(String songid ,String bit ,String time,NetCallBack callBack){
        Map<String, String> params = NetHelper.getMusicApiBasicParams("baidu.ting.song.downWeb");
        params.put("songid",songid);
        params.put("bit",bit);
        params.put("_t",time);
        creatMusicApi().getDownload(params).enqueue(callBack);

    }
    /**
    推荐列表
    参数： song_id = 877578

     num = 5//返回条目数量
     */

    public void getRecommandList(String song_id, String num, NetCallBack<RecommandSongListBean> callBack){
        Map<String, String> params = NetHelper.getMusicApiBasicParams("baidu.ting.song.getRecommandSongList");
        params.put("song_id",song_id);
        params.put("num",num);
        creatMusicApi().getRecommandSongList(params).enqueue(callBack);
    }
    /**
      获取词
      参数：songid = 877578 //歌曲id
     */
    public void  getSongLrcData(String songid, NetCallBack<SongLrcBean> callBack){
        Map<String, String> params = NetHelper.getMusicApiBasicParams("baidu.ting.song.lry");
        params.put("songid",songid);
        creatMusicApi().getSongLrc(params).enqueue(callBack);

    }
    /**
      搜索接口
      参数：songName = '' //搜索关键字
     */
    public void searchSong(String songName, NetCallBack<SearchSongBean> callback){
        Map<String, String> parmas = NetHelper.getMusicApiBasicParams("baidu.ting.search.catalogSug");
        parmas.put("query",songName);
        creatMusicApi().searchSong(parmas).enqueue(callback);
    }
    /**
    获取播放音乐
     参数：songid = 877578 //歌曲id
     */
    public void getPlaySongData(String songid, NetCallBack<PaySongBean> callback) {
        Map<String, String> params = NetHelper.getMusicApiBasicParams("baidu.ting.song.play");
        params.put("songid",songid);
        creatMusicApi().getPaySongData(params).enqueue(callback);
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
            //解决okhttp访问百度api出现的403问题。okhttp不是原生的http请求，
            // 它在header里面并没有真正的User-Agent，
            // 而是“okhttp/版本号”这样的字符串，为okhttp设置User-Agent可以解决问题。
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest = chain.request().newBuilder()
                            .removeHeader("User-Agent")
                            .addHeader("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:0.9.4)")
                            .build() ;
                    return chain.proceed(newRequest);
                }
            });
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
