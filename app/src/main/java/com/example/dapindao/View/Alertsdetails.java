package com.example.dapindao.View;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.MysubscriptionAdapter;
import com.example.dapindao.R;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.BaseActivity;
import com.example.dapindao.utils.Utils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Alertsdetails extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.iv_back)
    ImageView iv_back;
    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.title)
    TextView title;//标题
    @BindView(R.id.createDate)
    TextView createDate;//时间
    @BindView(R.id.content)
    TextView content;//内容
    private String id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertsdetails);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("id");
        iv_back.setOnClickListener(this);
        toolbar_title.setText("快讯");
        initData();
    }

    private void initData(){
        Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).getNewsflashDetail(id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.body()!=null){
                    try {
                        String jsonStr = new String(response.body().bytes());//把原始数据转为字符串
                        JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                        if(jsonObject.get("code").getAsInt() == 0){
                            title.setText(jsonObject.get("newsflash").getAsJsonObject().get("title").getAsString());
                            String date = (new SimpleDateFormat("MM-dd")).format(Utils.StrToDate(jsonObject.get("newsflash").getAsJsonObject().get("createDate").getAsString()));
                            createDate.setText(date);
                            content.setText(jsonObject.get("newsflash").getAsJsonObject().get("content").getAsString());
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

    @Override
    public void onClick(View view) {

        if(view == iv_back){
            finish();
        }
    }
}
