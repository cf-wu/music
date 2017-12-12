package com.cfwu.music5.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cfwu.music5.R;
import com.cfwu.music5.bean.SongListBean;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cfwu on 17-12-12.
 */
public class RecycAdapter extends RecyclerView.Adapter<RecycAdapter.ViewH> {
    private HashMap<String, List<SongListBean>> mData;

    private List<SongListBean> mDataNew;
    private List<SongListBean> mDataHot;
    private List<SongListBean> mDataRoll;
    private View mItemView;

    public RecycAdapter(HashMap<String, List<SongListBean>> mData) {
        this.mData = mData;
        mDataNew=mData.get("new");
        mDataHot=mData.get("hot");
        mDataRoll=mData.get("roll");
    }

    @Override
    public ViewH onCreateViewHolder(ViewGroup viewGroup, int i) {
        mItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_recyc_iten, viewGroup, false);

        return new ViewH(mItemView);
    }

    @Override
    public void onBindViewHolder(ViewH viewH, int i) {
        switch (i){
            case 0:
                viewH.tv1.setText(mDataNew.get(1).title);
                viewH.tv1.setText(mDataNew.get(2).title);
                viewH.tv1.setText(mDataNew.get(3).title);
            case 1:
                viewH.tv1.setText(mDataHot.get(1).title);
                viewH.tv1.setText(mDataHot.get(2).title);
                viewH.tv1.setText(mDataHot.get(3).title);
            case 2:
                viewH.tv1.setText(mDataRoll.get(1).title);
                viewH.tv1.setText(mDataRoll.get(2).title);
                viewH.tv1.setText(mDataRoll.get(3).title);
            default:
                viewH.tv1.setText("ccc");
                viewH.tv1.setText("ccc");
                viewH.tv1.setText("ccc");
        }


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewH extends RecyclerView.ViewHolder {
        public ImageView iv;
        public TextView tv1;
        public TextView tv2;
        public TextView tv3;

        public ViewH(View itemView) {
            super(itemView);
            this.iv = (ImageView) itemView.findViewById(R.id.recyc_image);
            this.tv1 = (TextView) itemView.findViewById(R.id.recyc_tv_1);
            this.tv2 = (TextView) itemView.findViewById(R.id.recyc_tv_2);
            this.tv3 = (TextView) itemView.findViewById(R.id.recyc_tv_3);

        }
    }
}
