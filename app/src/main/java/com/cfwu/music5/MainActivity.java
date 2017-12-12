package com.cfwu.music5;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.cfwu.music5.adapter.FragmentAdapter;
import com.cfwu.music5.base.BaseActivity;
import com.cfwu.music5.service.PlayerService;
import com.cfwu.music5.widget.PlayView;
import com.cfwu.music5.widget.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private TabPageIndicator mIndicator;
    private ViewPager mViewPager;
    private Intent intentservice;
    private PlayView mPlayView;
    private List<View> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        setTabPagerIndicator();
        //绑定播放的service
        intentservice=new Intent(this, PlayerService.class);
        startService(intentservice);
    }

    private void initData() {
        mData=new ArrayList();
    }

    private void initView() {
        mIndicator= (TabPageIndicator) findViewById(R.id.main_actionbar);
        mPlayView= (PlayView) findViewById(R.id.player);
        mViewPager= (ViewPager) findViewById(R.id.main_viewpager);
        //mViewPager.setAdapter(new MainPagerAdapter(this,mData));
        mViewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        mIndicator.setViewPager(mViewPager);
    }
    /*
    设置头部导航栏样式
     */
    private void setTabPagerIndicator() {
        mIndicator.setIndicatorMode(TabPageIndicator.IndicatorMode.MODE_WEIGHT_NOEXPAND_SAME);// 设置模式，一定要先设置模式
        mIndicator.setDividerColor(Color.BLUE);// 设置分割线的颜色
        mIndicator.setDividerPadding(10);//设置
        mIndicator.setIndicatorColor(Color.parseColor("#43A44b"));// 设置底部导航线的颜色
        mIndicator.setTextColorSelected(Color.WHITE);// 设置tab标题选中的颜色
        mIndicator.setTextColor(Color.parseColor("#797979"));// 设置tab标题未被选中的颜色
        mIndicator.setTextSize(35);// 设置字体大小
        mIndicator.setBackgroundColor(Color.BLUE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除service绑定
        if (intentservice != null){
            stopService(intentservice);
        }
    }
}
