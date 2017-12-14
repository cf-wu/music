package com.cfwu.music5.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.cfwu.music5.contasts.Contast;
import com.cfwu.music5.utils.LogUtils;

import java.io.IOException;

/**
 * Created by cfwu on 17-12-8.
 */
public class PlayerService extends Service {
    private MediaPlayer mMediaPlayer;
    private PlayBoadcast mReceiver;
    private IntentFilter mInflater;
    String url=null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.Log_D(this, "service oncreate");
        mMediaPlayer = new MediaPlayer();
        mReceiver = new PlayBoadcast();
        mInflater = new IntentFilter();
        mInflater.addAction(Contast.ACTION_PLAY);
        mInflater.addAction(Contast.ACTION_NEXT);
        mInflater.addAction(Contast.ACTION_PAUSE);
        registerReceiver(mReceiver, mInflater);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.Log_D(this, "service onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
        LogUtils.Log_D(this, "service onDestroy");
    }

    public class PlayBoadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            url=intent.getStringExtra("playSong");
            LogUtils.Log_D(this, "service onReceive palySongBean="+url);
            String action = intent.getAction();
            if (Contast.ACTION_PLAY.equals(action)){
                play();
            }else if (Contast.ACTION_PAUSE.equals(action)){
                pause();
            }else if (Contast.ACTION_NEXT.equals(action)){
                next();
            }
        }
    }

    private void next() {
        LogUtils.Log_D(this, "service next");
    }

    private void pause() {
        LogUtils.Log_D(this, "service pause");
    }

    private void play() {
        if (null == url)return;
        LogUtils.Log_D(this, "service play url="+url);

        try {
            mMediaPlayer.setDataSource(url);
            mMediaPlayer.prepare();
            mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    return false;
                }
            });
            mMediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
