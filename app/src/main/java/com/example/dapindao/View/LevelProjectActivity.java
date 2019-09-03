package com.example.dapindao.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.LevelprojectAdapter;
import com.example.dapindao.Adapter.ShadowCastAdapter;
import com.example.dapindao.R;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.BaseActivity;
import com.example.dapindao.utils.FoldTextView;
import com.example.dapindao.utils.RecyclerViewEmptySupport;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LevelProjectActivity extends BaseActivity {

    @BindView(R.id.text2)
    FoldTextView text;
    @BindView(R.id.parent2)
    FrameLayout parent2;
    private int id;
    private Intent intent;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.imgPath)
    RoundedImageView imgPath;
    private LevelprojectAdapter adapter;
    @BindView(R.id.group)
    LinearLayout group;
    private LinearLayoutManager mLinearLayoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levelproject);
        ButterKnife.bind(this);
        intent = getIntent();
        id = Integer.parseInt(intent.getStringExtra("id"));
        initData();

    }

    private void initData(){
        Log.e("TAG", "onItemClick: "+id);
        Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).getAllType2(id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.body()!=null){
                    try {
                        String jsonStr = new String(response.body().bytes());//把原始数据转为字符串
                        JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                        if(jsonObject.get("code").getAsInt() == 0){
                            JsonObject object = jsonObject.get("type1").getAsJsonObject();
                            JsonArray jsonElements = jsonObject.getAsJsonArray("list");
                            text.setText(object.get("intro").getAsString());
                            parent2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                }
                            });
                            name.setText(object.get("name").getAsString());
                            Glide.with(getApplicationContext()).load(object.get("imgPath").getAsString()).into(imgPath);
                            if(!jsonElements.isJsonNull()){
                                for(int i = 0;i<jsonElements.size();i++){
                                    JsonObject object1 =jsonElements.get(i).getAsJsonObject();
                                    View view =View.inflate(getApplicationContext(),R.layout.levelproject_data,null);
                                    TextView name = (TextView) view.findViewById(R.id.name);
                                    TextView view_more = (TextView) view.findViewById(R.id.view_more);
                                    RecyclerViewEmptySupport recyclerView = (RecyclerViewEmptySupport)view.findViewById(R.id.recyclerView);
                                    name.setText(object1.get("name").getAsString());
                                    mLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
                                    recyclerView.setLayoutManager(mLinearLayoutManager);
                                    recyclerView.setNestedScrollingEnabled(false);
                                    adapter = new LevelprojectAdapter(getApplicationContext(),object1.get("articleList").getAsJsonArray());
                                    recyclerView.setAdapter(adapter);
                                    adapter.notifyDataSetChanged();
                                    adapter.setOnitemClickListener(new LevelprojectAdapter.OnitemClickListener() {
                                        @Override
                                        public void onItemClick(View view, int position) {
                                       /*         JsonObject objects =jsonElements.get(position).getAsJsonObject();
                                                Intent intent = new Intent(fragment.getContext(), ArticleDetailsActivity.class);
                                                intent.putExtra("articleId",objects.get("id").getAsString());
                                                fragment.startActivity(intent);*/
                                        }
                                    });
                                    view_more.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {

                                        }
                                    });

                                    group.addView(view);


                                }
                            }


                        }else {
                            Toast.makeText(getApplicationContext(),jsonObject.get("msg").getAsString(),Toast.LENGTH_LONG).show();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();

                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void init() {

    }
}
