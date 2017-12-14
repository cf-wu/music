package com.cfwu.music5.fragments;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.cfwu.music5.MainActivity;
import com.cfwu.music5.R;
import com.cfwu.music5.adapter.RecycAdapter;
import com.cfwu.music5.base.BaseFragment;
import com.cfwu.music5.bean.SongBillListBean;
import com.cfwu.music5.presenter.IFragment2Presenter;
import com.cfwu.music5.presenter.impl.Fragment2PresenterImpl;
import com.cfwu.music5.utils.LogUtils;
import com.cfwu.music5.view.IFragment2View;
import com.cfwu.music5.view.impl.PlayView;

/**
 * Created by cfwu on 17-12-12.
 */
public class Fragment1 extends BaseFragment implements IFragment2View{
    private View mRootView;
    private RecyclerView mRecyclerView;
    private EditText mEditText;
    private ImageButton mImageButton;
    private RecyclerView.Adapter mAdapter;
    private IFragment2Presenter mPresenter;
    private Button mReloadButton;

    public ProgressBar mProgressBar;
    public RelativeLayout mRootLayout;
    public LinearLayout mErrorLayout;
    public PlayView mPlayView;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.layout_fragment2, container, false);
        initView();
        return mRootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter=new Fragment2PresenterImpl(this);
        mPresenter.OnCreat();
        MainActivity activity = (MainActivity) getActivity();
        LogUtils.Log_D(this,"onStart activity="+activity);
        mPlayView= (PlayView) activity.getPlayView();
        LogUtils.Log_D(this,"onStart playView="+mPlayView);
    }

    private void initView() {
        mProgressBar= (ProgressBar) mRootView.findViewById(R.id.recyc_progressbar);
        mRootLayout= (RelativeLayout) mRootView.findViewById(R.id.recyc_rootRelat);
        mEditText= (EditText) mRootView.findViewById(R.id.et_search);
        mImageButton= (ImageButton) mRootView.findViewById(R.id.ibtn_search);
        mRecyclerView= (RecyclerView) mRootView.findViewById(R.id.recyclerview);
        mErrorLayout= (LinearLayout) mRootView.findViewById(R.id.recyc_erro_message);
        mReloadButton= (Button) mRootView.findViewById(R.id.recyc_reload);
        initListener();
    }



    private void initListener() {
        mReloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.reLoadData();
            }
        });
    }

    @Override
    public void showData(SongBillListBean data) {
        LogUtils.Log_D(this,"show data");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }
        });//添加分割线，TODO:删除最后一个item的分割线
        mAdapter=new RecycAdapter(data.song_list,this);
        mRecyclerView.setAdapter(mAdapter);
        mPlayView.initViewPager(data.song_list,0);
    }
}
