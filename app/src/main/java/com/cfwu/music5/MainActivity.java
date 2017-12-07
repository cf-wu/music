package com.cfwu.music5;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.cfwu.music5.adapter.MainPagerAdapter;
import com.cfwu.music5.base.BaseActivity;
import com.cfwu.music5.widget.TabPageIndicator;

public class MainActivity extends BaseActivity {
    TabPageIndicator mIndicator;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIndicator= (TabPageIndicator) findViewById(R.id.main_actionbar);
        mViewPager= (ViewPager) findViewById(R.id.main_viewpager);
        mViewPager.setAdapter(new MainPagerAdapter(this));
        mIndicator.setViewPager(mViewPager);
        setTabPagerIndicator();
    }

    private void setTabPagerIndicator() {
        mIndicator.setIndicatorMode(TabPageIndicator.IndicatorMode.MODE_WEIGHT_NOEXPAND_SAME);// 设置模式，一定要先设置模式
        mIndicator.setDividerColor(Color.BLUE);// 设置分割线的颜色
        mIndicator.setDividerPadding(10);//设置
        mIndicator.setIndicatorColor(Color.parseColor("#43A44b"));// 设置底部导航线的颜色
        mIndicator.setTextColorSelected(Color.WHITE);// 设置tab标题选中的颜色
        mIndicator.setTextColor(Color.parseColor("#797979"));// 设置tab标题未被选中的颜色
        mIndicator.setTextSize(22);// 设置字体大小
        mIndicator.setBackgroundColor(Color.BLUE);
    }
}
