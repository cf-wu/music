package com.cfwu.music5.view.impl;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.cfwu.music5.R;
import com.cfwu.music5.adapter.PlayViewAdapter;
import com.cfwu.music5.bean.SongListBean;
import com.cfwu.music5.contasts.Contast;
import com.cfwu.music5.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cfwu on 17-12-7.
 */
public class PlayView extends LinearLayout {
    private ProgressBar mProgressBar;
    private LinearLayout mContainer;
    private ImageButton mPlayView;
    private ImageButton mStopView;
    private ImageButton mNextView;
    private ViewPager mViewPager;
    private Context mContext;
    private boolean isPlaying = false;
    private PlayViewAdapter mPagerAdapter;
    private List<SongListBean> mData = null;
    private int hashCodeNow = -1;


    public PlayView(Context context) {
        this(context, null);
        this.mContext = context;
    }


    public PlayView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.mContext = context;
    }

    public PlayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LogUtils.Log_D(this, this.getChildCount() + "-->onFinishInflate");
        initView();
        initListener();
    }

    private boolean dealData(List<SongListBean> mDataSong) {
        if (checkHashCodeSame(mDataSong.hashCode())) {
            return false;
        }
        if (mData == null) mData = new ArrayList<>();
        mData.clear();
        int i;
        int length = mDataSong.size();
        LogUtils.Log_D(this, "dealData" + length + "mData=" + mData.hashCode() + ",mDataSong=" + mDataSong.hashCode());
        for (i = 0; i < length + 2; i++) {
            if (i == 0) {
                mData.add(mDataSong.get(length - 1));
            } else if (i == length + 1) {
                mData.add(mDataSong.get(0));
            } else {
                mData.add(mDataSong.get(i - 1));
            }
        }
        return true;
    }

    private boolean checkHashCodeSame(int code) {
        if (code == hashCodeNow) {
            return true;
        }
        hashCodeNow = code;
        return false;
    }


    private void initView() {
        mProgressBar = (ProgressBar) this.getChildAt(0);
        mContainer = (LinearLayout) this.getChildAt(1);
        mPlayView = (ImageButton) mContainer.findViewById(R.id.paly);
        mStopView = (ImageButton) mContainer.findViewById(R.id.stop);
        mNextView = (ImageButton) mContainer.findViewById(R.id.next);
        mViewPager = (ViewPager) mContainer.findViewById(R.id.palyview_pager);
    }

    public void initViewPager(List<SongListBean> data, int position) {
        LogUtils.Log_D(this, data.hashCode() + "initViewPager");
        dealData(data);
        LogUtils.Log_D(this, mData.hashCode() + "initView");
        mPagerAdapter = new PlayViewAdapter(mContext, mData);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(position + 1);//初始化为1
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset == 0.0) {
                    if (position == 0) {
                        //当滑到第一张图时显示最后一张图并将postion跳至"D"位置
                        mViewPager.setCurrentItem(mData.size() - 2, false);

                    }
                    //当滑到最后一张图时显示第一张图并将position跳至"A"位置
                    else if (position == mData.size() - 1) {
                        mViewPager.setCurrentItem(1, false);
                    }
                }

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void updateData(List<SongListBean> data, int position) {
        if (dealData(data)){
            mPagerAdapter.notifyDataSetChanged();
        }
        mViewPager.setCurrentItem(position + 1,false);
    }


    private void initListener() {
        mPlayView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle(true);
                //开始播放
                mContext.sendBroadcast(new Intent(Contast.ACTION_PLAY));
            }
        });
        mStopView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle(false);
                //暂停播放
                mContext.sendBroadcast(new Intent(Contast.ACTION_PAUSE));
            }
        });
        mNextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //下一首
                if (isPlaying) {
                    //正在播放，播放下一首并刷新ui
                    mContext.sendBroadcast(new Intent(Contast.ACTION_NEXT));
                }
                //处于暂停状态，只刷新ui,不播放
                int current = mViewPager.getCurrentItem();
                LogUtils.Log_D(this, "current=" + current);
                int toPosition = current + 1;
                if (toPosition == mData.size()) {// SIZE=13
                    toPosition = 0;
                }
                mViewPager.setCurrentItem(toPosition, false);
                int a = mViewPager.getCurrentItem();
                LogUtils.Log_D(this, "current=" + a + "-----size" + mData.size());

            }
        });
    }

    //播放和暂停切换VIEW
    private void toggle(boolean play) {
        isPlaying = play;
        if (!isPlaying) {
            isPlaying = true;
            mStopView.setVisibility(View.GONE);
            mPlayView.setVisibility(View.VISIBLE);
        } else {
            isPlaying = false;
            mStopView.setVisibility(View.VISIBLE);
            mPlayView.setVisibility(View.GONE);
        }
    }

}
