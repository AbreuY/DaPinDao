package com.example.dapindao.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.bumptech.glide.Glide;
import com.example.dapindao.API.DaPinDaoAPI;
import com.example.dapindao.App.DapinDaoApp;
import com.example.dapindao.Model.ArticleDetailsModel;
import com.example.dapindao.Model.ConmmentModel;
import com.example.dapindao.Model.VedioesDetailModel;
import com.example.dapindao.R;
import com.example.dapindao.View.ArticleDetailsActivity;
import com.example.dapindao.View.VideoDetailsActivity;
import com.example.dapindao.retrofit.HttpHelper;
import com.example.dapindao.utils.Utils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author: Moos
 * E-mail: moosphon@gmail.com
 * Date:  18/4/20.
 * Desc: 评论与回复列表的适配器
 */

public class VideoCommentExpandAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "CommentExpandAdapter";
    private List<VedioesDetailModel.CommentResultBean.ListBean> commentBeanList;
    private List<VedioesDetailModel.CommentResultBean.ListBean.SubListBean> replyBeanList;
    private Context context;
    private VideoDetailsActivity activity;
    private int likeconut = 0;


    public VideoCommentExpandAdapter(VideoDetailsActivity activity, Context context, List<VedioesDetailModel.CommentResultBean.ListBean> commentBeanList) {
        this.context = context;
        this.commentBeanList = commentBeanList;
        this.activity = activity;

    }

    @Override
    public int getGroupCount() {
        return commentBeanList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        if(commentBeanList.get(i).getSubList() == null){
            return 0;
        }else {
            return commentBeanList.get(i).getSubList().size()>0 ? commentBeanList.get(i).getSubList().size():0;
        }

    }

    @Override
    public Object getGroup(int i) {
        return commentBeanList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return commentBeanList.get(i).getSubList().get(i1);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return getCombinedChildId(groupPosition, childPosition);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
    boolean isLike;

    @Override
    public View getGroupView(final int groupPosition, boolean isExpand, View convertView, ViewGroup viewGroup) {
        final GroupHolder groupHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.comment_item_layout, viewGroup, false);
            groupHolder = new GroupHolder(convertView);
            convertView.setTag(groupHolder);
        }else {
            groupHolder = (GroupHolder) convertView.getTag();
        }
        Glide.with(context).load(commentBeanList.get(groupPosition).getAvatarPath())
                .error(R.mipmap.ic_launcher)
                .centerCrop()
                .into(groupHolder.logo);
        groupHolder.tv_name.setText(commentBeanList.get(groupPosition).getUserName());
        groupHolder.tv_time.setText(commentBeanList.get(groupPosition).getCreateDate());
        groupHolder.tv_content.setText(commentBeanList.get(groupPosition).getContent());
        if(commentBeanList.get(groupPosition).getLikeCount() == 0){
            groupHolder.likeCount.setText("");
        }else {
            groupHolder.likeCount.setText(""+commentBeanList.get(groupPosition).getLikeCount());
        }

        if(commentBeanList.get(groupPosition).getIsLike()!=null){
            if(commentBeanList.get(groupPosition).getIsLike().equals("0")){
                groupHolder.iv_like.setBackground(context.getDrawable(R.drawable.praise1));
            }else {
                groupHolder.iv_like.setBackground(context.getDrawable(R.drawable.praise2));
            }
        }

        groupHolder.iv_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(commentBeanList.get(groupPosition).getIsLike().equals("0")){
                    Like("1",commentBeanList.get(groupPosition).getId(),commentBeanList.get(groupPosition).getArticleUuid());
                    groupHolder.iv_like.setBackground(context.getDrawable(R.drawable.praise2));
                    Log.e(TAG, "onClick: "+"1" );
                }else {

                    Like("2",commentBeanList.get(groupPosition).getId(),commentBeanList.get(groupPosition).getArticleUuid());
                    groupHolder.iv_like.setBackground(context.getDrawable(R.drawable.praise1));
                    Log.e(TAG, "onClick: "+"2" );


                }
            }
        });
        if(commentBeanList.get(groupPosition).getUserId() == DapinDaoApp.getUserId()){

            groupHolder.btnDelete.setVisibility(View.VISIBLE);
        }else {
            groupHolder.btnDelete.setVisibility(View.INVISIBLE);
        }
        groupHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //删除评论
                showAlterDialog(groupPosition);
            }
        });

        return convertView;
    }

    /**
     * 普通dialog
     */
    private void showAlterDialog(int i){
        final AlertDialog.Builder alterDiaglog = new AlertDialog.Builder(activity);
        alterDiaglog.setTitle("提示");//文字
        alterDiaglog.setMessage("确定删除吗？");//提示消息
        alterDiaglog.setPositiveButton("删除", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).deleteComment(DapinDaoApp.getToken(),"1",commentBeanList.get(i).getArticleUuid(),commentBeanList.get(i).getSecondType(),commentBeanList.get(i).getId(),null,commentBeanList.get(i).getArticleUserId());
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.body()!=null){
                            try {
                                String jsonStr = new String(response.body().bytes());//把原始数据转为字符串
                                JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                                if(jsonObject.get("code").getAsInt() == 0){
                                    Toast.makeText(context,jsonObject.get("msg").getAsString(),Toast.LENGTH_LONG).show();
                                    dellTheCommentData(commentBeanList.get(i));
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
        });
        alterDiaglog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        //显示
        alterDiaglog.show();
    }

    //点赞
    private void Like(String type,String commentId,String ArticleUuid){
        Call<ResponseBody> call = HttpHelper.getInstance().create(DaPinDaoAPI.class).likeComment(DapinDaoApp.getToken(),type,"1",commentId,null);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.body()!=null){
                    try {
                        String jsonStr = new String(response.body().bytes());//把原始数据转为字符串
                        JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStr);
                        if(jsonObject.get("code").getAsInt() != 0){
                            Toast.makeText(context,jsonObject.get("msg").getAsString(),Toast.LENGTH_LONG).show();
                        }else {
                            activity.loaddetails();
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
    public View getChildView(final int groupPosition, int childPosition, boolean b, View convertView, ViewGroup viewGroup) {
        final ChildHolder childHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.comment_reply_item_layout,viewGroup, false);
            childHolder = new ChildHolder(convertView);
            convertView.setTag(childHolder);
        }
        else {
            childHolder = (ChildHolder) convertView.getTag();
        }

        String replyUser = commentBeanList.get(groupPosition).getSubList().get(childPosition).getUserName();
        if(!TextUtils.isEmpty(replyUser)){
            childHolder.tv_name.setText(replyUser + ":");
        }else {
            childHolder.tv_name.setText("无名"+":");
        }

        childHolder.tv_content.setText(commentBeanList.get(groupPosition).getSubList().get(childPosition).getContent());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    private class GroupHolder{
        private CircleImageView logo;
        private TextView tv_name, tv_content, tv_time,btnDelete,likeCount;
        private ImageView iv_like;
        public GroupHolder(View view) {
            logo = (CircleImageView) view.findViewById(R.id.comment_item_logo);
            tv_content = (TextView) view.findViewById(R.id.comment_item_content);
            tv_name = (TextView) view.findViewById(R.id.comment_item_userName);
            tv_time = (TextView) view.findViewById(R.id.comment_item_time);
            iv_like = (ImageView) view.findViewById(R.id.isLike);
            btnDelete = (TextView) view.findViewById(R.id.btnDelete);
            likeCount=(TextView) view.findViewById(R.id.likeCount);
        }
    }

    private class ChildHolder{
        private TextView tv_name, tv_content;
        public ChildHolder(View view) {
            tv_name = (TextView) view.findViewById(R.id.reply_item_user);
            tv_content = (TextView) view.findViewById(R.id.reply_item_content);
        }
    }


    /**
     * by moos on 2018/04/20
     * func:评论成功后插入一条数据
     * @param commentDetailBean 新的评论数据
     */
    public void addTheCommentData(VedioesDetailModel.CommentResultBean.ListBean commentDetailBean){
        if(commentDetailBean!=null){
            commentBeanList.add(0,commentDetailBean);
            notifyDataSetChanged();
        }else {
            throw new IllegalArgumentException("评论数据为空!");
        }

    }
    /**
     * by moos on 2018/04/20
     * func:删除成功后减去一条数据
     * @param commentDetailBean 评论数据
     */
    public void dellTheCommentData(VedioesDetailModel.CommentResultBean.ListBean commentDetailBean){
        if(commentDetailBean!=null){
            commentBeanList.remove(commentDetailBean);
            notifyDataSetChanged();
        }else {
            throw new IllegalArgumentException("评论数据为空!");
        }

    }

    /**
     * by moos on 2018/04/20
     * func:回复成功后插入一条数据
     * @param replyDetailBean 新的回复数据
     */
    public void addTheReplyData(VedioesDetailModel.CommentResultBean.ListBean.SubListBean replyDetailBean, int groupPosition){
        if(replyDetailBean!=null){
            Log.e(TAG, "addTheReplyData: >>>>该刷新回复列表了:"+replyDetailBean.toString() );
            if(commentBeanList.get(groupPosition).getSubList() != null ){
                commentBeanList.get(groupPosition).getSubList().add(replyDetailBean);
            }else {
                List<VedioesDetailModel.CommentResultBean.ListBean.SubListBean> replyList = new ArrayList<>();
                replyList.add(replyDetailBean);
                commentBeanList.get(groupPosition).setSubList(replyList);
            }
            notifyDataSetChanged();
        }else {
            throw new IllegalArgumentException("回复数据为空!");
        }

    }

    /**
     * by moos on 2018/04/20
     * func:添加和展示所有回复
     * @param replyBeanList 所有回复数据
     * @param groupPosition 当前的评论
     */
    private void addReplyList(List<VedioesDetailModel.CommentResultBean.ListBean.SubListBean> replyBeanList, int groupPosition){
        if(commentBeanList.get(groupPosition).getSubList() != null ){
            commentBeanList.get(groupPosition).getSubList().clear();
            commentBeanList.get(groupPosition).getSubList().addAll(replyBeanList);
        }else {

            commentBeanList.get(groupPosition).setSubList(replyBeanList);
        }

        notifyDataSetChanged();
    }

}
