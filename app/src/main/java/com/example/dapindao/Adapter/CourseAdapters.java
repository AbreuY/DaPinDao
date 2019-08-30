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
import com.example.dapindao.Model.RecommendedModel;
import com.example.dapindao.R;
import com.example.dapindao.utils.RelativeDateFormat;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapters extends RecyclerView.Adapter implements View.OnClickListener {

    public static final int VIEW_TYPE_ITEM = 1;
    public static final int VIEW_TYPE_EMPTY = 0;
    private Context context;
    private JsonArray jsonlist;
    public CourseAdapters(Context context,JsonArray jsonlist){
        this.context = context;
        this.jsonlist = jsonlist;
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
        baseView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.course_datas, viewGroup, false);
        BodyViewHolder bodyViewHolder = new BodyViewHolder(baseView);
        baseView.setOnClickListener(this);
        return bodyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof BodyViewHolder){
            JsonObject object =jsonlist.get(i).getAsJsonObject();
            ((BodyViewHolder) viewHolder).name.setText(object.get("name").getAsString());
            ((BodyViewHolder) viewHolder).pubDate.setText(RelativeDateFormat.format(object.get("pubDate").getAsString()));
            Glide.with(context).load(object.get("imgPath").getAsString()).into(((BodyViewHolder) viewHolder).imgPath);

        }
        viewHolder.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        if (jsonlist.size() == 0) {
            return 1;
        }
        return jsonlist.size();
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

        if (jsonlist.size() == 0) {
            return VIEW_TYPE_EMPTY;
        }
        //如果有数据，则使用ITEM的布局
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

        private RoundedImageView imgPath;
        private TextView name;
        private TextView pubDate;


        public BodyViewHolder(View itemView) {
            super(itemView);
            imgPath = (RoundedImageView) itemView.findViewById(R.id.imgPath);
            name = (TextView) itemView.findViewById(R.id.name);
            pubDate = (TextView) itemView.findViewById(R.id.pubDate);

        }

    }
}
