package com.example.dapindao.Presenter;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.Adapter.CourseAdapters;
import com.example.dapindao.Adapter.TheArticleAdapters;
import com.example.dapindao.Adapter.VideoAdapters;
import com.example.dapindao.Interface.RecommendedInterface;
import com.example.dapindao.Model.CouresMode;
import com.example.dapindao.Model.RecommendedModel;
import com.example.dapindao.R;
import com.example.dapindao.View.ArticleDetailsActivity;
import com.example.dapindao.View.BannerViewPager;
import com.example.dapindao.View.RecommendedFragment;
import com.example.dapindao.View.VideoDetailsActivity;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.RecyclerViewEmptySupport;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendedPresenter implements RecommendedInterface.Presenter {

    private RecommendedInterface.View view;
    private RecommendedFragment fragment;
    private RecommendedModel model;//实体类
    private List<CouresMode> couresModes = new ArrayList<>();
    private LinearLayoutManager mLinearLayoutManager;
    private List<String> listurl = new ArrayList<>();
    private List<RecommendedModel.DataBean.ListBean> listBeans = new ArrayList<>();
    private TheArticleAdapters articleAdapters;//文章
    private CourseAdapters courseAdapters;//课程
    private VideoAdapters videoAdapters;//视频
    private  Intent intent;
    public RecommendedPresenter(RecommendedInterface.View view,RecommendedFragment fragment){
        this.view = view;
        this.fragment = fragment;

    }

    @Override
    public void recFront(int type) {
        //加载推荐数据
        Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).recFront(2,0,0);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.body()!=null){
                    try {
                        String jsonStr = new String(response.body().bytes());//把原始数据转为字符串
                        Log.e("TAG", "onResponse: "+jsonStr );
                        JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                        if(jsonObject.get("code").getAsInt() == 0){
                            JsonArray jsonElements = jsonObject.getAsJsonArray("articleBo");
                            for(int i = 0;i<jsonElements.size();i++){
                                JsonObject articleBo = jsonElements.get(i).getAsJsonObject();
                                listurl.add(articleBo.get("imgPath").getAsString());
                            }
                            fragment.banner.initBanner(listurl, true)//图片地址，关闭3D画廊效果
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
                            if(jsondataarry.size()>0){
                                for(int i = 0 ;i<jsondataarry.size();i++){
                                    JsonObject object = jsondataarry.get(i).getAsJsonObject();
                                    View view = View.inflate(fragment.getContext(),R.layout.content_data,null);
                                    TextView name = (TextView)view.findViewById(R.id.name);
                                    TextView more = (TextView) view.findViewById(R.id.more);
                                    RelativeLayout top = (RelativeLayout)view.findViewById(R.id.top);
                                    RecyclerViewEmptySupport recyclerViewcourse = (RecyclerViewEmptySupport)view.findViewById(R.id.recyclerViewcourse);
                                    mLinearLayoutManager = new LinearLayoutManager(fragment.getActivity());
                                    recyclerViewcourse.setLayoutManager(mLinearLayoutManager);
                                    recyclerViewcourse.setNestedScrollingEnabled(false);

                                    name.setText(object.get("name").getAsString());
                                    if(object.get("name").getAsString().equals("文章")){
                                        top.setVisibility(View.GONE);
                                        JsonArray jsonlist = object.get("list").getAsJsonArray();
                                        articleAdapters = new TheArticleAdapters(fragment.getActivity(),jsonlist);
                                        recyclerViewcourse.setAdapter(articleAdapters);
                                        articleAdapters.notifyDataSetChanged();
                                        articleAdapters.setOnitemClickListener(new TheArticleAdapters.OnitemClickListener() {
                                            @Override
                                            public void onItemClick(View view, int position) {
                                       /*         JsonObject objects =jsonElements.get(position).getAsJsonObject();
                                                Intent intent = new Intent(fragment.getContext(), ArticleDetailsActivity.class);
                                                intent.putExtra("articleId",objects.get("id").getAsString());
                                                fragment.startActivity(intent);*/
                                            }
                                        });
                                    }
                                    if(object.get("name").getAsString().equals("课程")){
                                        top.setVisibility(View.VISIBLE);
                                        JsonArray jsonlist = object.get("list").getAsJsonArray();
                                        courseAdapters = new CourseAdapters(fragment.getActivity(),jsonlist);
                                        recyclerViewcourse.setAdapter(courseAdapters);
                                        courseAdapters.notifyDataSetChanged();
                                        courseAdapters.setOnitemClickListener(new CourseAdapters.OnitemClickListener() {
                                            @Override
                                            public void onItemClick(View view, int position) {

                                            }
                                        });
                                    }
                                    if(object.get("name").getAsString().equals("视频")){
                                        top.setVisibility(View.VISIBLE);
                                        JsonArray jsonlist = object.get("list").getAsJsonArray();
                                        videoAdapters = new VideoAdapters(fragment.getActivity(),jsonlist);
                                        recyclerViewcourse.setAdapter(videoAdapters);
                                        videoAdapters.notifyDataSetChanged();
                                        videoAdapters.setOnitemClickListener(new VideoAdapters.OnitemClickListener() {
                                            @Override
                                            public void onItemClick(View view, int position) {
                                                JsonObject object1 = jsonlist.get(position).getAsJsonObject();
                                                Log.e("id", "onItemClick: "+object1.get("id").getAsString() );
                                                intent = new Intent(fragment.getContext(), VideoDetailsActivity.class);
                                                intent.putExtra("id",object1.get("id").getAsString());
                                                fragment.startActivity(intent);
                                            }
                                        });
                                    }
                                    fragment.group.addView(view);
                                }
                            }


                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
         /*           if(response.body().getCode() == 0){
                        model = new RecommendedModel();
                        model.setArticleBo(response.body().getArticleBo());
                        model.setData(response.body().getData());
                        for(int i = 0;i<model.getArticleBo().size();i++){
                            listurl.add(model.getArticleBo().get(i).getImgPath());
                        }

                            for(int i = 0;i<model.getData().size();i++){
                                View view = View.inflate(fragment.getContext(),R.layout.content_data,null);
                                TextView name = (TextView)view.findViewById(R.id.name);
                                TextView more = (TextView) view.findViewById(R.id.more);

                                RecyclerViewEmptySupport recyclerViewcourse = (RecyclerViewEmptySupport)view.findViewById(R.id.recyclerViewcourse);
                                recyclerViewcourse.setLayoutManager(mLinearLayoutManager);
                                mLinearLayoutManager = new LinearLayoutManager(fragment.getActivity());
                               if(model.getData().get(i).getName().equals("文章")){
                                   name.setText(model.getData().get(i).getName());
                                   for(int j = 0;j<model.getData().get(i).getList().size();j++){
                                        listBeans.add(model.getData().get(i).getList().get(j));
                                    }
                                   fragment.articleAdapters = new TheArticleAdapters(fragment.getActivity(),listBeans);
                                   recyclerViewcourse.setAdapter(fragment.articleAdapters);
                                   fragment.articleAdapters.notifyDataSetChanged();
                                }
                               fragment.group.addView(view);

                            }
                    }else {
                        Toast.makeText(fragment.getContext(),response.body().getMsg(),Toast.LENGTH_LONG).show();
                    }*/
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(fragment.getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
