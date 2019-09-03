package com.example.dapindao.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.App.DapinDaoApp;
import com.example.dapindao.Model.ProjectModel;
import com.example.dapindao.Model.RecommendedModel;
import com.example.dapindao.R;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.RelativeDateFormat;
import com.example.dapindao.utils.Utils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    public static final int VIEW_TYPE_ITEM = 1;
    public static final int VIEW_TYPE_EMPTY = 0;
    private Context context;
    private String token;
    private List<ProjectModel.ResultBean.RowsBean> model;
    public ProjectAdapter(Context context,List<ProjectModel.ResultBean.RowsBean> model){
        this.context = context;
        this.model = model;
        token = Utils.getShared2(context,"token");
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
        baseView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.project_data, viewGroup, false);
        BodyViewHolder bodyViewHolder = new BodyViewHolder(baseView);
        baseView.setOnClickListener(this);
        return bodyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof BodyViewHolder){
            ((BodyViewHolder) viewHolder).name.setText(model.get(i).getName());
            Glide.with(context).load(model.get(i).getImgPath()).into(((BodyViewHolder) viewHolder).imgPath);
            Log.e("TAG", "onBindViewHolder: "+model.get(i).getIsSub() );
            if(model.get(i).getIsSub() == null){
                ((BodyViewHolder) viewHolder).subscribe_check.setChecked(false);
                ((BodyViewHolder) viewHolder).subscribe_check.setText("+订阅");
            }else if( model.get(i).getIsSub().equals("0")){
                ((BodyViewHolder) viewHolder).subscribe_check.setChecked(false);
                ((BodyViewHolder) viewHolder).subscribe_check.setText("+订阅");
            }else if(model.get(i).getIsSub().equals("1")){
                ((BodyViewHolder) viewHolder).subscribe_check.setChecked(true);
                ((BodyViewHolder) viewHolder).subscribe_check.setText("已订阅");
            }
            ((BodyViewHolder) viewHolder).subscribe_check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if( ((BodyViewHolder) viewHolder).subscribe_check.isChecked()){
                        subPro(model.get(i).getId(),"1",((BodyViewHolder) viewHolder).subscribe_check);
                    }else {
                        subPro(model.get(i).getId(),"2",((BodyViewHolder) viewHolder).subscribe_check);

                    }
                }
            });
        }
        viewHolder.itemView.setTag(i);
    }

    private void subPro(int projectId,String type,CheckBox checkBox){
        Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).subProjectOne(token,projectId,type);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.body()!=null){
                    try {
                        String jsonStr = new String(response.body().bytes());//把原始数据转为字符串
                        JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                        if(jsonObject.get("code").getAsInt() == 0){
                            Toast.makeText(context,jsonObject.get("msg").getAsString(),Toast.LENGTH_LONG).show();
                            if(type.equals("1")){
                                checkBox.setChecked(true);
                                checkBox.setText("已订阅");
                            }else {
                                checkBox.setChecked(false);
                                checkBox.setText("+订阅");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (model.size() == 0) {
            return 1;
        }
        return model.size();
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

        if (model.size() == 0) {
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

        private ImageView imgPath;
        private TextView name;
        private CheckBox subscribe_check;


        public BodyViewHolder(View itemView) {
            super(itemView);
            imgPath = (ImageView) itemView.findViewById(R.id.imgPath);
            name = (TextView) itemView.findViewById(R.id.name);
            subscribe_check = (CheckBox) itemView.findViewById(R.id.subscribe_check);

        }

    }
}
