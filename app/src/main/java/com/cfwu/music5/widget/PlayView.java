package com.cfwu.music5.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cfwu.music5.R;
import com.cfwu.music5.utils.LogUtils;

/**
 * Created by cfwu on 17-12-7.
 */
public class PlayView extends LinearLayout {
    private ProgressBar mProgressBar;
    private LinearLayout mContainer;
    private ImageButton mPlayView;
    private ImageButton mStopView;
    private ImageButton mNextView;
    private Context mContext;
    private boolean isPlaying=false;
    public PlayView(Context context) {
        this(context,null);
        this.mContext=context;
    }


    public PlayView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
        this.mContext=context;
    }

    public PlayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LogUtils.Log_D(this,this.getChildCount()+"-->onFinishInflate");
        mProgressBar = (ProgressBar) this.getChildAt(0);
        mContainer= (LinearLayout) this.getChildAt(1);
        mPlayView= (ImageButton) mContainer.findViewById(R.id.paly);
        mStopView= (ImageButton) mContainer.findViewById(R.id.stop);
        mNextView= (ImageButton) mContainer.findViewById(R.id.next);
        initListener();
    }
    private void initListener() {
        mPlayView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
                Toast.makeText(mContext,"star_tpaly",Toast.LENGTH_SHORT).show();
            }
        });
        mStopView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
                Toast.makeText(mContext,"stOP_tpaly",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void toggle(){
        if (!isPlaying){
            isPlaying=true;
            mStopView.setVisibility(View.GONE);
            mPlayView.setVisibility(View.VISIBLE);
        }else{
            isPlaying=false;
            mStopView.setVisibility(View.VISIBLE);
            mPlayView.setVisibility(View.GONE);
        }
    }

}
