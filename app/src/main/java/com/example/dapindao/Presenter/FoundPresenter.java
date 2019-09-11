package com.example.dapindao.Presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.CourseAdapters;
import com.example.dapindao.Adapter.TheArticleAdapters;
import com.example.dapindao.Adapter.VideoAdapters;
import com.example.dapindao.Interface.FoundInterface;
import com.example.dapindao.R;
import com.example.dapindao.View.ArticleDetailsActivity;
import com.example.dapindao.View.BannerViewPager;
import com.example.dapindao.View.VideoDetailsActivity;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.RecyclerViewEmptySupport;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoundPresenter implements FoundInterface.Presenter {

    private Context context;
    private TheArticleAdapters articleAdapters;//文章
    private VideoAdapters adapters;
    private BannerViewPager bannerViewPager;
    private List<String> listurl = new ArrayList<>();
    private LinearLayout linearLayout;
    private LinearLayoutManager mLinearLayoutManager;

    public FoundPresenter(Context context ,BannerViewPager bannerViewPager1,LinearLayout linearLayout){
        this.context = context;
        this.bannerViewPager = bannerViewPager1;
        this.linearLayout = linearLayout;
    }

    @Override
    public void mainPage(int pageSize) {
        Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).mainPage(pageSize);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.body()!=null){
                    try {
                        String jsonStr = new String(response.body().bytes());//把原始数据转为字符串
                        JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                        if(jsonObject.get("code").getAsInt() == 0){
                            JsonArray jsonElements = jsonObject.getAsJsonArray("articleBo");
                            for(int i = 0;i<jsonElements.size();i++){
                                JsonObject articleBo = jsonElements.get(i).getAsJsonObject();
                                listurl.add(articleBo.get("imgPath").getAsString());
                            }
                            bannerViewPager.initBanner(listurl, true)//图片地址，关闭3D画廊效果
                                    .addPageMargin(5, 45)//参数1page之间的间距,参数2中间item距离边界的间距
                                    .addPointBottom(7)
                                    .addStartTimer(5)//自动轮播5秒间隔
                                    .addRoundCorners(8)//圆角
                                    .finishConfig()//这句必须加
                                    .addBannerListener(new BannerViewPager.OnClickBannerListener() {
                                        @Override
                                        public void onBannerClick(int position) {
                                            //点击item
                                        }
                                    });
                            JsonArray jsondataarry = jsonObject.get("data").getAsJsonArray();
                            for(int i = 0 ;i<jsondataarry.size();i++){
                                JsonObject object = jsondataarry.get(i).getAsJsonObject();
                                View view = View.inflate(context, R.layout.found_content_data,null);
                                TextView name = (TextView)view.findViewById(R.id.textView18);
                                TextView more = (TextView) view.findViewById(R.id.more);
                                RecyclerViewEmptySupport recyclerViewcourse = (RecyclerViewEmptySupport)view.findViewById(R.id.recyclerViewcourse);
                                mLinearLayoutManager = new LinearLayoutManager(context);
                                recyclerViewcourse.setLayoutManager(mLinearLayoutManager);
                                recyclerViewcourse.setNestedScrollingEnabled(false);


                                if(object.get("name").getAsString().equals("文章")){
                                    name.setText("热门文章");
                                    JsonArray jsonlist = object.get("list").getAsJsonArray();
                                    articleAdapters = new TheArticleAdapters(context,jsonlist);
                                    recyclerViewcourse.setAdapter(articleAdapters);
                                    articleAdapters.notifyDataSetChanged();
                                    articleAdapters.setOnitemClickListener(new TheArticleAdapters.OnitemClickListener() {
                                        @Override
                                        public void onItemClick(View view, int position) {
                                            JsonObject objects =jsonlist.get(position).getAsJsonObject();
                                            Intent intent = new Intent(context, ArticleDetailsActivity.class);
                                            intent.putExtra("articleId",objects.get("id").getAsString());
                                            context.startActivity(intent);
                                        }
                                    });
                                }

                                if(object.get("name").getAsString().equals("视频")){
                                    name.setText("最新视频");
                                    JsonArray jsonlist = object.get("list").getAsJsonArray();
                                    adapters = new VideoAdapters(context,jsonlist);
                                    recyclerViewcourse.setAdapter(adapters);
                                    adapters.notifyDataSetChanged();
                                    adapters.setOnitemClickListener(new VideoAdapters.OnitemClickListener() {
                                        @Override
                                        public void onItemClick(View view, int position) {
                                            JsonObject object1 = jsonlist.get(position).getAsJsonObject();
                                            Log.e("id", "onItemClick: "+object1.get("id").getAsString() );
                                           Intent intent = new Intent(context, VideoDetailsActivity.class);
                                            intent.putExtra("id",object1.get("id").getAsString());
                                            context.startActivity(intent);
                                        }
                                    });
                                }
                               linearLayout.addView(view);
                            }
                        }else {
                            Toast.makeText(context,jsonObject.get("msg").getAsString(),Toast.LENGTH_LONG).show();
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
}
