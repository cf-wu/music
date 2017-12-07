package com.cfwu.music5;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.cfwu.music5.base.BaseActivity;
import com.cfwu.music5.utils.LogUtils;

public class SplashActivity extends BaseActivity {
    SharedPreferences sp;
    boolean isFirstEnter=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        sp=getSharedPreferences("store_app_music",MODE_PRIVATE);
        isFirstEnter=sp.getBoolean("is_first_enter",true);
        LogUtils.Log_D(this,isFirstEnter);
        if (!isFirstEnter){
            openActivity(MainActivity.class);
            finish();
        }else{
            //等待5秒跳转
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    sp.edit().putBoolean("is_first_enter",false).apply();
                    openActivity(MainActivity.class);
                    finish();
                }
            },5000);
        }

    }
}
