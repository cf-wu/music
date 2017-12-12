package com.cfwu.music5.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;

import com.cfwu.music5.R;
import com.cfwu.music5.utils.LogUtils;

/**
 * Created by cfwu on 17-12-7.
 */
public class BaseActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        LogUtils.Log_D(this,"startAcitvity");
        //页面动画
        overridePendingTransition(R.anim.activity_enter_left,R.anim.activity_out_right);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.activity_enter_left,R.anim.activity_out_left);
    }
    protected void openActivity(Class<?> clazz){
        LogUtils.Log_D(this,"openActivity");
        Intent intent=new Intent(this,clazz);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.Log_D(this,"onDestroy");
    }

    @Override
    public void finish() {
        super.finish();
        LogUtils.Log_D(this,"finish");
        overridePendingTransition(R.anim.activity_enter_right,R.anim.activity_out_left);
    }
}
