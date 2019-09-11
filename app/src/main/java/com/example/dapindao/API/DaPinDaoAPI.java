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
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
            @Query("search") String search,
            @Query("userId") int userId
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
            @Query("id") String id,
            @Query("articleUuid") String articleUuid,
            @Query("pageSize") int pageSize,
            @Query("loginUserId") int loginUserId
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
            @Query("articleImgPath") String articleImgPath,
            @Query("content") String content,
            @Query("toUserId") String toUserId,
            @Query("toUserName")int toUserName,
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
    //订阅
    @POST("/api/common/project/subProjectTypeTwo")
    Call<ResponseBody> subProjectOne(
            @Header("Authorization") String Authorization,
            @Query("projectId") int projectId,
            @Query("type") String type
    );
    //二级专题
    @POST("/api/common/project/getAllType2")
    Call<ResponseBody> getAllType2(
            @Query("type1Id") int type1Id
    );

    //我的订阅
    @POST("/api/common/project/geSubProjectOnePage")
    Call<ResponseBody> geSubProjectOnePage(
            @Header("Authorization") String Authorization,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize,
            @Query("userId") int userId

    );
    //快讯详情
    @POST("/api/common/neweflash/getNewsflashDetail")
    Call<ResponseBody> getNewsflashDetail(
            @Query("id") String id
    );

    //文章视频点赞
    @POST("/api/common/article/userLike")
    Call<ResponseBody> userLike(
            @Header("Authorization") String Authorization,
            @Query("id") String id,
            @Query("uuid") String uuid,
            @Query("type") String type,
            @Query("secondType") String secondType,
            @Query("artUserId") int artUserId
    );

    //获取文章、咨询等当前用户是否收藏、点赞等
    @POST("/api/common/article/getArticleIsCollectDetail")
    Call<ResponseBody> getArticleIsCollectDetail(
            @Header("Authorization") String Authorization,
            @Query("uuid") String uuid,
            @Query("firstType") String firstType,
            @Query("secondType") String secondType
    );

    //用户收藏与取消(视频、文章、快讯、课程)
    @POST("/api/common/article/userCollect")
    Call<ResponseBody> userCollect(
            @Header("Authorization") String Authorization,
            @Query("id") String id,
            @Query("uuid") String uuid,
            @Query("type") String type,
            @Query("firstType") String firstType,
            @Query("secondType") String secondType,
            @Query("artUserId") int artUserId
    );

    //收藏记录
    @POST("/api/common/article/queryUserCollectPage")
    Call<ResponseBody> queryUserCollectPage(
            @Header("Authorization") String Authorization,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize,
            @Query("type") String type
    );

    //退出登录
    @POST("/api/common/login/loginOut")
    Call<ResponseBody> loginOut(
            @Header("Authorization") String Authorization
    );

    //修改用户基本信息
    @POST("/api/common/user/updateBasicInfo")
    Call<ResponseBody> updateBasicInfo(
            @Header("Authorization") String Authorization,
            @Query("userName") String userName,
            @Query("intro") String intro,
            @Query("email") String email
    );

    //发布文章
    @POST("/api/common/art/saveOrPublishArticle")
    Call<ResponseBody>saveOrPublishArticle(
            @Header("Authorization") String Authorization,
            @Body RequestBody Body

    );

    //文件上传
    @Multipart
    @POST("/api/common/wangEditor/uploadImgToOSSAPP")
    Call<ResponseBody>uploadImgToOSSAPP(
            @Header("Authorization") String Authorization,
            @Part MultipartBody.Part userHeadFile
    );

    //发现
    @POST("/api/app/explore/mainPage")
    Call<ResponseBody> mainPage(
            @Query("pageSize") int pageSize
    );

    //关注
    @POST("/api/common/userFans/attentionUser")
    Call<ResponseBody> attentionUser(
            @Header("Authorization") String Authorization,
            @Query("attentionUserId") String attentionUserId
    );
    //取消关注
    @POST("/api/common/userFans/deleteAttentionUser")
    Call<ResponseBody> deleteAttentionUser(
            @Header("Authorization") String Authorization,
            @Query("attentionUserId") String attentionUserId
    );
    //查询当前用户是否关注过指定的用户
    @POST("/api/common/userFans/judgeIsAttention")
    Call<ResponseBody> judgeIsAttention(
            @Header("Authorization") String Authorization,
            @Query("attentionUserId") int attentionUserId
    );

    //获取关注或者粉丝数据
    @POST("/api/common/userFans/queryUserFansList")
    Call<ResponseBody> queryUserFansList(
            @Header("Authorization") String Authorization,
            @Query("type") String type,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize
    );

    //分页查询文章
    @POST("/api/common/art/queryArticlePageOwn")
    Call<ResponseBody> queryArticlePageOwn(
            @Header("Authorization") String Authorization,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize
    );

    //消息通知
    @POST("/api/common/notice/queryUserAppNoticePage")
    Call<ResponseBody> queryUserAppNoticePage(
            @Header("Authorization") String Authorization,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize
    );

    //查询我的评论
    @POST("/api/app/comment/queryOwnCommentPage")
    Call<ResponseBody> queryOwnCommentPage(
            @Header("Authorization") String Authorization,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize,
            @Query("type") String type
    );

    //查询认证状态
    @POST("/api/common/user/getAuthStatusData")
    Call<ResponseBody> getAuthStatusData(
            @Header("Authorization") String Authorization
    );

    //身份认证
    @POST("/api/common/user/submitAuth")
    Call<ResponseBody>submitAuth(
            @Header("Authorization") String Authorization,
            @Body RequestBody Body
    );
}
