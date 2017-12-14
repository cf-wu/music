package com.cfwu.music5.utils;

import android.content.Context;

import com.cfwu.music5.base.MusicApp;

/**
 * Created by cfwu on 17-12-14.
 */
public class Util {
    private static  Context mContext= MusicApp.getContext();
    public static int dp2px(float dipValue)

    {

        float m = mContext.getResources().getDisplayMetrics().density;

        return (int) (dipValue * m + 0.5f);

    }


    public static int px2dp( float pxValue)

    {

        float m = mContext.getResources().getDisplayMetrics().density;

        return (int) (pxValue / m + 0.5f);

    }
}
