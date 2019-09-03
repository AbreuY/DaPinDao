package com.example.dapindao.Model;

import java.util.List;

public class VedioesDetailModel {


    /**
     * msg : 成功
     * next : {"search":null,"params":null,"id":"5d6388916c94ab3b1ca51769","uuid":"66a39c8b57574caebf53006efe791a34","type":"2","title":"111","introduction":"111","second":178,"time":"02:58","vedio":"201908/a40439265ac04f8b9709f44dd1693d59.mp4","vedioPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/a40439265ac04f8b9709f44dd1693d59.mp4","img":"201908/04cd8c3ce5f247fcaebc601004e08dbe.jpg","imgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/04cd8c3ce5f247fcaebc601004e08dbe.jpg","boImg":null,"boImgPath":null,"clickCount":0,"replyCount":1,"likeCount":1,"collectCount":2,"shellCount":0,"createDate":"2019-08-26 15:21:51","createBy":"admin","updateBy":"admin","updateTime":"2019-08-30 19:31:42","remark":null,"isShow":"1","sort":null,"isRec":"0","isCollect":null,"isLike":null}
     * vedioes : {"search":null,"params":null,"id":"5d63a7066c94ab42f407bc57","uuid":"dd3229caba1b46acb46ef9f6a044e831","type":"2","title":"444","introduction":"444","second":178,"time":"02:58","vedio":"201908/6e3393fdec4041b4a29771240d07a6c6.mp4","vedioPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/6e3393fdec4041b4a29771240d07a6c6.mp4","img":"201908/a2dae6cf676142df862844dd787cc7fb.jpg","imgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/a2dae6cf676142df862844dd787cc7fb.jpg","boImg":"201908/0a4596744fd0467b99a4a7e467e4a24a.jpg","boImgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/0a4596744fd0467b99a4a7e467e4a24a.jpg","clickCount":0,"replyCount":2,"likeCount":2,"collectCount":2,"shellCount":0,"createDate":"2019-08-26 17:31:48","createBy":"admin","updateBy":"admin","updateTime":"2019-08-30 20:08:37","remark":null,"isShow":"1","sort":null,"isRec":"1","isCollect":null,"isLike":null}
     * commentResult : {"list":[{"search":null,"params":null,"id":"5d6a2ed96c94ab2ce436dfd2","type":"1","secondType":"4","oneCommentId":"","articleUuid":"dd3229caba1b46acb46ef9f6a044e831","articleTitle":"444","articleImgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/a2dae6cf676142df862844dd787cc7fb.jpg","articleUserId":null,"userId":64,"userName":"新用户23228134","avatarPath":"","content":"评论","toUserId":null,"toUserName":null,"likeCount":0,"replyCount":1,"subList":[{"search":null,"params":null,"id":"5d6a2ff36c94ab2ce436dfd6","type":"2","secondType":"4","oneCommentId":"5d6a2ed96c94ab2ce436dfd2","articleUuid":"dd3229caba1b46acb46ef9f6a044e831","articleTitle":"444","articleImgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/a2dae6cf676142df862844dd787cc7fb.jpg","articleUserId":null,"userId":64,"userName":"新用户23228134","avatarPath":null,"content":"评论","toUserId":null,"toUserName":null,"likeCount":0,"replyCount":0,"subList":null,"likeUserIdsList":null,"createDate":"2019-08-31 16:29:39","isLike":"0","searchType":null,"searchUserId":null}],"likeUserIdsList":null,"createDate":"2019-08-31 16:24:57","isLike":"0","searchType":null,"searchUserId":null}],"total":1,"pageSize":10,"totalPage":1,"pageNum":1}
     * code : 0
     */

    private String msg;
    private NextBean next;
    private VedioesBean vedioes;
    private CommentResultBean commentResult;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public NextBean getNext() {
        return next;
    }

    public void setNext(NextBean next) {
        this.next = next;
    }

    public VedioesBean getVedioes() {
        return vedioes;
    }

    public void setVedioes(VedioesBean vedioes) {
        this.vedioes = vedioes;
    }

    public CommentResultBean getCommentResult() {
        return commentResult;
    }

    public void setCommentResult(CommentResultBean commentResult) {
        this.commentResult = commentResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class NextBean {
        /**
         * search : null
         * params : null
         * id : 5d6388916c94ab3b1ca51769
         * uuid : 66a39c8b57574caebf53006efe791a34
         * type : 2
         * title : 111
         * introduction : 111
         * second : 178
         * time : 02:58
         * vedio : 201908/a40439265ac04f8b9709f44dd1693d59.mp4
         * vedioPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/a40439265ac04f8b9709f44dd1693d59.mp4
         * img : 201908/04cd8c3ce5f247fcaebc601004e08dbe.jpg
         * imgPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/04cd8c3ce5f247fcaebc601004e08dbe.jpg
         * boImg : null
         * boImgPath : null
         * clickCount : 0
         * replyCount : 1
         * likeCount : 1
         * collectCount : 2
         * shellCount : 0
         * createDate : 2019-08-26 15:21:51
         * createBy : admin
         * updateBy : admin
         * updateTime : 2019-08-30 19:31:42
         * remark : null
         * isShow : 1
         * sort : null
         * isRec : 0
         * isCollect : null
         * isLike : null
         */

        private Object search;
        private Object params;
        private String id;
        private String uuid;
        private String type;
        private String title;
        private String introduction;
        private int second;
        private String time;
        private String vedio;
        private String vedioPath;
        private String img;
        private String imgPath;
        private Object boImg;
        private Object boImgPath;
        private int clickCount;
        private int replyCount;
        private int likeCount;
        private int collectCount;
        private int shellCount;
        private String createDate;
        private String createBy;
        private String updateBy;
        private String updateTime;
        private Object remark;
        private String isShow;
        private Object sort;
        private String isRec;
        private Object isCollect;
        private Object isLike;

        public Object getSearch() {
            return search;
        }

        public void setSearch(Object search) {
            this.search = search;
        }

        public Object getParams() {
            return params;
        }

        public void setParams(Object params) {
            this.params = params;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getVedio() {
            return vedio;
        }

        public void setVedio(String vedio) {
            this.vedio = vedio;
        }

        public String getVedioPath() {
            return vedioPath;
        }

        public void setVedioPath(String vedioPath) {
            this.vedioPath = vedioPath;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getImgPath() {
            return imgPath;
        }

        public void setImgPath(String imgPath) {
            this.imgPath = imgPath;
        }

        public Object getBoImg() {
            return boImg;
        }

        public void setBoImg(Object boImg) {
            this.boImg = boImg;
        }

        public Object getBoImgPath() {
            return boImgPath;
        }

        public void setBoImgPath(Object boImgPath) {
            this.boImgPath = boImgPath;
        }

        public int getClickCount() {
            return clickCount;
        }

        public void setClickCount(int clickCount) {
            this.clickCount = clickCount;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public int getCollectCount() {
            return collectCount;
        }

        public void setCollectCount(int collectCount) {
            this.collectCount = collectCount;
        }

        public int getShellCount() {
            return shellCount;
        }

        public void setShellCount(int shellCount) {
            this.shellCount = shellCount;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public String getIsShow() {
            return isShow;
        }

        public void setIsShow(String isShow) {
            this.isShow = isShow;
        }

        public Object getSort() {
            return sort;
        }

        public void setSort(Object sort) {
            this.sort = sort;
        }

        public String getIsRec() {
            return isRec;
        }

        public void setIsRec(String isRec) {
            this.isRec = isRec;
        }

        public Object getIsCollect() {
            return isCollect;
        }

        public void setIsCollect(Object isCollect) {
            this.isCollect = isCollect;
        }

        public Object getIsLike() {
            return isLike;
        }

        public void setIsLike(Object isLike) {
            this.isLike = isLike;
        }
    }

    public static class VedioesBean {
        /**
         * search : null
         * params : null
         * id : 5d63a7066c94ab42f407bc57
         * uuid : dd3229caba1b46acb46ef9f6a044e831
         * type : 2
         * title : 444
         * introduction : 444
         * second : 178
         * time : 02:58
         * vedio : 201908/6e3393fdec4041b4a29771240d07a6c6.mp4
         * vedioPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/6e3393fdec4041b4a29771240d07a6c6.mp4
         * img : 201908/a2dae6cf676142df862844dd787cc7fb.jpg
         * imgPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/a2dae6cf676142df862844dd787cc7fb.jpg
         * boImg : 201908/0a4596744fd0467b99a4a7e467e4a24a.jpg
         * boImgPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/0a4596744fd0467b99a4a7e467e4a24a.jpg
         * clickCount : 0
         * replyCount : 2
         * likeCount : 2
         * collectCount : 2
         * shellCount : 0
         * createDate : 2019-08-26 17:31:48
         * createBy : admin
         * updateBy : admin
         * updateTime : 2019-08-30 20:08:37
         * remark : null
         * isShow : 1
         * sort : null
         * isRec : 1
         * isCollect : null
         * isLike : null
         */

        private Object search;
        private Object params;
        private String id;
        private String uuid;
        private String type;
        private String title;
        private String introduction;
        private int second;
        private String time;
        private String vedio;
        private String vedioPath;
        private String img;
        private String imgPath;
        private String boImg;
        private String boImgPath;
        private int clickCount;
        private int replyCount;
        private int likeCount;
        private int collectCount;
        private int shellCount;
        private String createDate;
        private String createBy;
        private String updateBy;
        private String updateTime;
        private Object remark;
        private String isShow;
        private Object sort;
        private String isRec;
        private Object isCollect;
        private Object isLike;

        public Object getSearch() {
            return search;
        }

        public void setSearch(Object search) {
            this.search = search;
        }

        public Object getParams() {
            return params;
        }

        public void setParams(Object params) {
            this.params = params;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getVedio() {
            return vedio;
        }

        public void setVedio(String vedio) {
            this.vedio = vedio;
        }

        public String getVedioPath() {
            return vedioPath;
        }

        public void setVedioPath(String vedioPath) {
            this.vedioPath = vedioPath;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getImgPath() {
            return imgPath;
        }

        public void setImgPath(String imgPath) {
            this.imgPath = imgPath;
        }

        public String getBoImg() {
            return boImg;
        }

        public void setBoImg(String boImg) {
            this.boImg = boImg;
        }

        public String getBoImgPath() {
            return boImgPath;
        }

        public void setBoImgPath(String boImgPath) {
            this.boImgPath = boImgPath;
        }

        public int getClickCount() {
            return clickCount;
        }

        public void setClickCount(int clickCount) {
            this.clickCount = clickCount;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public int getCollectCount() {
            return collectCount;
        }

        public void setCollectCount(int collectCount) {
            this.collectCount = collectCount;
        }

        public int getShellCount() {
            return shellCount;
        }

        public void setShellCount(int shellCount) {
            this.shellCount = shellCount;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public String getIsShow() {
            return isShow;
        }

        public void setIsShow(String isShow) {
            this.isShow = isShow;
        }

        public Object getSort() {
            return sort;
        }

        public void setSort(Object sort) {
            this.sort = sort;
        }

        public String getIsRec() {
            return isRec;
        }

        public void setIsRec(String isRec) {
            this.isRec = isRec;
        }

        public Object getIsCollect() {
            return isCollect;
        }

        public void setIsCollect(Object isCollect) {
            this.isCollect = isCollect;
        }

        public Object getIsLike() {
            return isLike;
        }

        public void setIsLike(Object isLike) {
            this.isLike = isLike;
        }
    }

    public static class CommentResultBean {
        /**
         * list : [{"search":null,"params":null,"id":"5d6a2ed96c94ab2ce436dfd2","type":"1","secondType":"4","oneCommentId":"","articleUuid":"dd3229caba1b46acb46ef9f6a044e831","articleTitle":"444","articleImgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/a2dae6cf676142df862844dd787cc7fb.jpg","articleUserId":null,"userId":64,"userName":"新用户23228134","avatarPath":"","content":"评论","toUserId":null,"toUserName":null,"likeCount":0,"replyCount":1,"subList":[{"search":null,"params":null,"id":"5d6a2ff36c94ab2ce436dfd6","type":"2","secondType":"4","oneCommentId":"5d6a2ed96c94ab2ce436dfd2","articleUuid":"dd3229caba1b46acb46ef9f6a044e831","articleTitle":"444","articleImgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/a2dae6cf676142df862844dd787cc7fb.jpg","articleUserId":null,"userId":64,"userName":"新用户23228134","avatarPath":null,"content":"评论","toUserId":null,"toUserName":null,"likeCount":0,"replyCount":0,"subList":null,"likeUserIdsList":null,"createDate":"2019-08-31 16:29:39","isLike":"0","searchType":null,"searchUserId":null}],"likeUserIdsList":null,"createDate":"2019-08-31 16:24:57","isLike":"0","searchType":null,"searchUserId":null}]
         * total : 1
         * pageSize : 10
         * totalPage : 1
         * pageNum : 1
         */

        private int total;
        private int pageSize;
        private int totalPage;
        private int pageNum;
        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * search : null
             * params : null
             * id : 5d6a2ed96c94ab2ce436dfd2
             * type : 1
             * secondType : 4
             * oneCommentId :
             * articleUuid : dd3229caba1b46acb46ef9f6a044e831
             * articleTitle : 444
             * articleImgPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/a2dae6cf676142df862844dd787cc7fb.jpg
             * articleUserId : null
             * userId : 64
             * userName : 新用户23228134
             * avatarPath :
             * content : 评论
             * toUserId : null
             * toUserName : null
             * likeCount : 0
             * replyCount : 1
             * subList : [{"search":null,"params":null,"id":"5d6a2ff36c94ab2ce436dfd6","type":"2","secondType":"4","oneCommentId":"5d6a2ed96c94ab2ce436dfd2","articleUuid":"dd3229caba1b46acb46ef9f6a044e831","articleTitle":"444","articleImgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/a2dae6cf676142df862844dd787cc7fb.jpg","articleUserId":null,"userId":64,"userName":"新用户23228134","avatarPath":null,"content":"评论","toUserId":null,"toUserName":null,"likeCount":0,"replyCount":0,"subList":null,"likeUserIdsList":null,"createDate":"2019-08-31 16:29:39","isLike":"0","searchType":null,"searchUserId":null}]
             * likeUserIdsList : null
             * createDate : 2019-08-31 16:24:57
             * isLike : 0
             * searchType : null
             * searchUserId : null
             */

            private Object search;
            private Object params;
            private String id;
            private String type;
            private String secondType;
            private String oneCommentId;
            private String articleUuid;
            private String articleTitle;
            private String articleImgPath;
            private int articleUserId;
            private int userId;
            private String userName;
            private String avatarPath;
            private String content;
            private Object toUserId;
            private Object toUserName;
            private int likeCount;
            private int replyCount;
            private Object likeUserIdsList;
            private String createDate;
            private String isLike;
            private Object searchType;
            private Object searchUserId;
            private List<SubListBean> subList;
            public ListBean(String articleImgPath, String userName,  String content, String createDate,int userId) {
                this.avatarPath = articleImgPath;
                this.userName = userName;
                this.content = content;
                this.createDate = createDate;
                this.userId = userId;
            }

            public Object getSearch() {
                return search;
            }

            public void setSearch(Object search) {
                this.search = search;
            }

            public Object getParams() {
                return params;
            }

            public void setParams(Object params) {
                this.params = params;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSecondType() {
                return secondType;
            }

            public void setSecondType(String secondType) {
                this.secondType = secondType;
            }

            public String getOneCommentId() {
                return oneCommentId;
            }

            public void setOneCommentId(String oneCommentId) {
                this.oneCommentId = oneCommentId;
            }

            public String getArticleUuid() {
                return articleUuid;
            }

            public void setArticleUuid(String articleUuid) {
                this.articleUuid = articleUuid;
            }

            public String getArticleTitle() {
                return articleTitle;
            }

            public void setArticleTitle(String articleTitle) {
                this.articleTitle = articleTitle;
            }

            public String getArticleImgPath() {
                return articleImgPath;
            }

            public void setArticleImgPath(String articleImgPath) {
                this.articleImgPath = articleImgPath;
            }

            public int getArticleUserId() {
                return articleUserId;
            }

            public void setArticleUserId(int articleUserId) {
                this.articleUserId = articleUserId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getAvatarPath() {
                return avatarPath;
            }

            public void setAvatarPath(String avatarPath) {
                this.avatarPath = avatarPath;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public Object getToUserId() {
                return toUserId;
            }

            public void setToUserId(Object toUserId) {
                this.toUserId = toUserId;
            }

            public Object getToUserName() {
                return toUserName;
            }

            public void setToUserName(Object toUserName) {
                this.toUserName = toUserName;
            }

            public int getLikeCount() {
                return likeCount;
            }

            public void setLikeCount(int likeCount) {
                this.likeCount = likeCount;
            }

            public int getReplyCount() {
                return replyCount;
            }

            public void setReplyCount(int replyCount) {
                this.replyCount = replyCount;
            }

            public Object getLikeUserIdsList() {
                return likeUserIdsList;
            }

            public void setLikeUserIdsList(Object likeUserIdsList) {
                this.likeUserIdsList = likeUserIdsList;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getIsLike() {
                return isLike;
            }

            public void setIsLike(String isLike) {
                this.isLike = isLike;
            }

            public Object getSearchType() {
                return searchType;
            }

            public void setSearchType(Object searchType) {
                this.searchType = searchType;
            }

            public Object getSearchUserId() {
                return searchUserId;
            }

            public void setSearchUserId(Object searchUserId) {
                this.searchUserId = searchUserId;
            }

            public List<SubListBean> getSubList() {
                return subList;
            }

            public void setSubList(List<SubListBean> subList) {
                this.subList = subList;
            }

            public static class SubListBean {
                /**
                 * search : null
                 * params : null
                 * id : 5d6a2ff36c94ab2ce436dfd6
                 * type : 2
                 * secondType : 4
                 * oneCommentId : 5d6a2ed96c94ab2ce436dfd2
                 * articleUuid : dd3229caba1b46acb46ef9f6a044e831
                 * articleTitle : 444
                 * articleImgPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/a2dae6cf676142df862844dd787cc7fb.jpg
                 * articleUserId : null
                 * userId : 64
                 * userName : 新用户23228134
                 * avatarPath : null
                 * content : 评论
                 * toUserId : null
                 * toUserName : null
                 * likeCount : 0
                 * replyCount : 0
                 * subList : null
                 * likeUserIdsList : null
                 * createDate : 2019-08-31 16:29:39
                 * isLike : 0
                 * searchType : null
                 * searchUserId : null
                 */

                private Object search;
                private Object params;
                private String id;
                private String type;
                private String secondType;
                private String oneCommentId;
                private String articleUuid;
                private String articleTitle;
                private String articleImgPath;
                private Object articleUserId;
                private int userId;
                private String userName;
                private Object avatarPath;
                private String content;
                private Object toUserId;
                private Object toUserName;
                private int likeCount;
                private int replyCount;
                private Object subList;
                private Object likeUserIdsList;
                private String createDate;
                private String isLike;
                private Object searchType;
                private Object searchUserId;

                public SubListBean(String userName, String content) {
                    this.userName = userName;
                    this.content = content;
                }

                public Object getSearch() {
                    return search;
                }

                public void setSearch(Object search) {
                    this.search = search;
                }

                public Object getParams() {
                    return params;
                }

                public void setParams(Object params) {
                    this.params = params;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getSecondType() {
                    return secondType;
                }

                public void setSecondType(String secondType) {
                    this.secondType = secondType;
                }

                public String getOneCommentId() {
                    return oneCommentId;
                }

                public void setOneCommentId(String oneCommentId) {
                    this.oneCommentId = oneCommentId;
                }

                public String getArticleUuid() {
                    return articleUuid;
                }

                public void setArticleUuid(String articleUuid) {
                    this.articleUuid = articleUuid;
                }

                public String getArticleTitle() {
                    return articleTitle;
                }

                public void setArticleTitle(String articleTitle) {
                    this.articleTitle = articleTitle;
                }

                public String getArticleImgPath() {
                    return articleImgPath;
                }

                public void setArticleImgPath(String articleImgPath) {
                    this.articleImgPath = articleImgPath;
                }

                public Object getArticleUserId() {
                    return articleUserId;
                }

                public void setArticleUserId(Object articleUserId) {
                    this.articleUserId = articleUserId;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public Object getAvatarPath() {
                    return avatarPath;
                }

                public void setAvatarPath(Object avatarPath) {
                    this.avatarPath = avatarPath;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public Object getToUserId() {
                    return toUserId;
                }

                public void setToUserId(Object toUserId) {
                    this.toUserId = toUserId;
                }

                public Object getToUserName() {
                    return toUserName;
                }

                public void setToUserName(Object toUserName) {
                    this.toUserName = toUserName;
                }

                public int getLikeCount() {
                    return likeCount;
                }

                public void setLikeCount(int likeCount) {
                    this.likeCount = likeCount;
                }

                public int getReplyCount() {
                    return replyCount;
                }

                public void setReplyCount(int replyCount) {
                    this.replyCount = replyCount;
                }

                public Object getSubList() {
                    return subList;
                }

                public void setSubList(Object subList) {
                    this.subList = subList;
                }

                public Object getLikeUserIdsList() {
                    return likeUserIdsList;
                }

                public void setLikeUserIdsList(Object likeUserIdsList) {
                    this.likeUserIdsList = likeUserIdsList;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }

                public String getIsLike() {
                    return isLike;
                }

                public void setIsLike(String isLike) {
                    this.isLike = isLike;
                }

                public Object getSearchType() {
                    return searchType;
                }

                public void setSearchType(Object searchType) {
                    this.searchType = searchType;
                }

                public Object getSearchUserId() {
                    return searchUserId;
                }

                public void setSearchUserId(Object searchUserId) {
                    this.searchUserId = searchUserId;
                }
            }
        }
    }
}
