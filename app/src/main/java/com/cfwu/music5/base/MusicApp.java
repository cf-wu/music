package com.cfwu.music5.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by cfwu on 17-12-14.
 */
public class MusicApp extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
    }
    public  static Context getContext(){
        return mContext;
    }
}


