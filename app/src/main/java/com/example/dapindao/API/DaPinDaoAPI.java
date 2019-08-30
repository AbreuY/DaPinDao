package com.example.dapindao.API;

import com.example.dapindao.Model.ArticleDetailsModel;
import com.example.dapindao.Model.ConmmentModel;
import com.example.dapindao.Model.FilePathModel;
import com.example.dapindao.Model.HotListModel;
import com.example.dapindao.Model.ProjectModel;
import com.example.dapindao.Model.RecommendedModel;
import com.example.dapindao.Model.Registered;
import com.example.dapindao.Model.UserModel;
import com.example.dapindao.Model.VedioesDetailModel;
import com.example.dapindao.Model.VideobyModel;
import com.example.dapindao.Model.publicModel;
import com.example.dapindao.retrofit.ApiResults;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface DaPinDaoAPI {
    //大频道app接口


    //    注册
    @POST("/api/common/login/register")
    Call<Registered> register(
            @Query("mobile") String mobile,
            @Query("code") String code,
            @Query("deviceType") String deviceType,
            @Query("deviceName") String deviceName,
            @Query("platform") String platform,
            @Query("deviceId") String deviceId,
            @Query("password") String password
    );

    //    发送短信验证码
    @POST("/api/common/login/sendMobileCode")
    Call<publicModel> sendMobileCode(
            @Query("mobile") String mobile,
            @Query("type") String type
    );

    //手机验证码登录
    @POST("/api/common/login/loginByCode")
    Call<Registered> loginByCode(
            @Query("mobile") String mobile,
            @Query("code") String code,
            @Query("deviceType") String deviceType,
            @Query("deviceName") String deviceName,
            @Query("platform") String platform,
            @Query("deviceId") String deviceId
    );

    //获取用户基本信息
    @POST("/api/common/user/getUserBasicInfo")
    Call<UserModel>getUserBasicInfo(
            @Header("Authorization") String Authorization,
            @Query("id") Integer id
    );

    //更换手机号
    @POST("/api/common/user/bindMobile")
    Call<publicModel> bindMobile(
            @Header("Authorization") String Authorization,
            @Query("mobile") String mobile,
            @Query("newMobile") String newMobile,
            @Query("code") String code
    );

    //上传头像
    @Multipart
    @POST("/api/common/user/updatePhoto")
    Call<FilePathModel>updatePhoto(
            @Header("Authorization") String Authorization,
            @Part MultipartBody.Part userHeadFile
    );

    //一级专题
    @POST("/api/common/project/getType1Page")
    Call<ProjectModel> getType1Page(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize,
            @Query("search") String search
    );
    //热榜
    @POST("/api/app/front/recFront")
    Call<ResponseBody> recFront(
            @Query("type") int type,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize
    );

    //视频详情
    @POST("/api/common/vedioes/getVedioesDetail")
    Call<VedioesDetailModel> getVedioesDetail(
            @Query("id") String id
    );

    //视频轮播图、
    @POST("/api/common/vedioes/queryVedioesIsRecAll")
    Call<VideobyModel> queryVedioesIsRecAll(
            @Query("type") String type
    );

    //获取文章详情
    @POST("/api/common/art/getArticleDetailWeb")
    Call<ArticleDetailsModel> getArticleDetailWeb(
            @Query("articleId") String articleId,
            @Query("isRec") String isRec,
            @Query("pageSize") int pageSize,
            @Query("loginUserId") int loginUserId
    );

    //分页查询咨询文章
    @POST("/api/common/art/queryArticlePageWeb")
    Call<ResponseBody> queryArticlePageWeb(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize,
            @Query("isRec") String isRec,
            @Query("artTypeId") int artTypeId
    );

    //发布评论
    @POST("/api/common/comment/saveComment")
    Call<ResponseBody> saveComment(
            @Header("Authorization") String Authorization,
            @Query("type") String type,
            @Query("secondType") String secondType,
            @Query("articleUuid") String articleUuid,
            @Query("articleUserId") int articleUserId,
            @Query("articleTitle") String articleTitle,
            @Query("content") String content,
            @Query("oneCommentId") String oneCommentId

    );

    //点赞
    @POST("/api/common/comment/likeComment")
    Call<ResponseBody> likeComment(
            @Header("Authorization") String Authorization,
            @Query("type") String type,
            @Query("commentType") String commentType,
            @Query("commentId") String commentId,
            @Query("oneCommentId") String oneCommentId

    );

    //删除评论
    @POST("/api/common/comment/deleteComment")
    Call<ResponseBody> deleteComment(
            @Header("Authorization") String Authorization,
            @Query("type") String type,
            @Query("articleUuid") String articleUuid,
            @Query("secondType") String secondType,
            @Query("oneCommentId") String oneCommentId,
            @Query("twoCommentId") String twoCommentId,
            @Query("artUserId") int artUserId

    );

    //分页查询评论
    @POST("/api/common/comment/queryOneCommentPage")
    Call<ConmmentModel> queryOneCommentPage(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize,
            @Query("articleUuid") String articleUuid
    );


}
