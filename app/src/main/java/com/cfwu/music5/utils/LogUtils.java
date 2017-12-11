package com.cfwu.music5.utils;

import android.util.Log;

/**
 * Created by cfwu on 17-12-7.
 */
public class LogUtils {
    public static final boolean DEBUG=true;
    private static String TAG;
    public static void Log_D(Object clazz,String message){
        TAG= clazz.getClass().getName();
        if (DEBUG) Log.d(TAG+"CHUFEI", message);
    }
    public static void Log_D(Object clazz,Boolean message){
        TAG= clazz.getClass().getName();
        if (DEBUG) Log.d(TAG+"CHUFEI", ""+message);
    }
}
