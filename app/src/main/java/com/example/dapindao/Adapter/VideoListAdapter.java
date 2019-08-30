package com.example.dapindao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dapindao.R;
import com.example.dapindao.utils.MyJZVideoPlayerStandard;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import cn.jzvd.JzvdStd;

public class VideoListAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    public static final int VIEW_TYPE_ITEM = 1;
    public static final int VIEW_TYPE_EMPTY = 0;
    private Context context;
    //private List<CouponModel.DataBean> couponVoListBeans;
    public VideoListAdapter(Context context){
        this.context = context;
        //this.couponVoListBeans = couponVoListBeans;
    }

    private OnitemClickListener onitemClickListener=null;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        //在onCreateViewHolder方法中，我们要根据不同的ViewType来返回不同的ViewHolder
        if (viewType == VIEW_TYPE_EMPTY) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.empty_view_tab, viewGroup, false);
            return new RecyclerView.ViewHolder(view) {
            };
        }

        View baseView;
        baseView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.largewatch_data, viewGroup, false);
        BodyViewHolder bodyViewHolder = new BodyViewHolder(baseView);
        baseView.setOnClickListener(this);
        return bodyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof BodyViewHolder){
            ((BodyViewHolder) viewHolder).video_player.setUp("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4"
                    , "饺子快长大", JzvdStd.SCREEN_WINDOW_NORMAL);
            Glide.with(context).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").into( ((BodyViewHolder) viewHolder).video_player.thumbImageView);
        }
        viewHolder.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
     /*   if (couponVoListBeans.size() == 0) {
            return 1;
        }
        return couponVoListBeans.size();*/
        return 20;
    }

    /**
     *
     * 复用getItemViewType方法，根据位置返回相应的ViewType
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        //如果是0，就是头，否则则是其他的item

     /*   if (couponVoListBeans.size() == 0) {
            return VIEW_TYPE_EMPTY;
        }
        //如果有数据，则使用ITEM的布局
        return VIEW_TYPE_ITEM;*/

        return VIEW_TYPE_ITEM;
    }

    @Override
    public void onClick(View view) {
        if(onitemClickListener!=null){
            onitemClickListener.onItemClick(view,(int)view.getTag());
        }


    }

    public void setOnitemClickListener(OnitemClickListener onitemClickListener) {
        this.onitemClickListener = onitemClickListener;
    }

    public static interface OnitemClickListener{
        void onItemClick(View view, int position);
    }

    /**
     * 给GridView中的条目用的ViewHolder，里面只有一个TextView
     */
    public class BodyViewHolder extends RecyclerView.ViewHolder {

        private MyJZVideoPlayerStandard video_player;
        public BodyViewHolder(View itemView) {
            super(itemView);
            video_player = (MyJZVideoPlayerStandard)itemView.findViewById(R.id.video_player);
        }

    }
}
