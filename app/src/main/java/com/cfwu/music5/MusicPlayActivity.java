package com.cfwu.music5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cfwu.music5.api.NetUtils;
import com.cfwu.music5.bean.PaySongBean;
import com.cfwu.music5.bean.SongListBean;
import com.cfwu.music5.contasts.Contast;
import com.cfwu.music5.utils.LogUtils;

import rx.Observer;

public class MusicPlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);
        final Intent intent = getIntent();
        SongListBean musicBean =intent.getParcelableExtra("musicBean");
        NetUtils.getInstance().getPlaySongData(musicBean.song_id, new Observer<PaySongBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(PaySongBean paySongBean) {
                LogUtils.Log_D(this, "palySongBean="+paySongBean);
                Intent intent1 = new Intent(Contast.ACTION_PLAY);
                intent1.putExtra("playSong",paySongBean.bitrate.file_link);
                sendBroadcast(intent1);
            }
        });
    }
}
