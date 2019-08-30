package com.example.dapindao.Model;

public class VedioesDetailModel {

    /**
     * msg : 成功
     * next : {"search":null,"params":null,"id":"5d47e2035784273e2e50f081","uuid":"80c996e11172447598a329046231f6de","type":"1","title":"在电影中演神仙都是什么感受？","introduction":"三生三世白奕上神饰演者\u2014\u2014-演员冷海铭做客大频道！","vedio":"201908/c04e2b3fc9774338890d9951fac3c3e4.mp4","vedioPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/c04e2b3fc9774338890d9951fac3c3e4.mp4","img":"201908/047d2f6212694f988083257d2f6f612c.png","imgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/047d2f6212694f988083257d2f6f612c.png","clickCount":5,"replyCount":0,"likeCount":0,"collectCount":0,"shellCount":0,"createDate":"2019-08-05 15:58:29","createBy":"admin","updateBy":null,"updateTime":null,"remark":null,"isShow":"1","sort":null,"isRec":"1","isCollect":null,"isLike":null}
     * vedioes : {"search":null,"params":null,"id":"5d49241c578427472518dc79","uuid":"d681918bf8bf42f596a480e075475287","type":"1","title":"演员茹天老师做客大频道","introduction":"中国家庭\u2014\u2014刘敏扮演者；爱情公寓1\u2014\u2014蒙娜丽莎的扮演者，演员茹天老师。","vedio":"201908/aaae269b54ab4210aa6a0fe471edc487.mp4","vedioPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/aaae269b54ab4210aa6a0fe471edc487.mp4","img":"201908/ad94d8e29c3148dcab3d31c2dbef0da8.png","imgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/ad94d8e29c3148dcab3d31c2dbef0da8.png","clickCount":9,"replyCount":0,"likeCount":0,"collectCount":0,"shellCount":0,"createDate":"2019-08-06 14:51:48","createBy":"admin","updateBy":null,"updateTime":null,"remark":null,"isShow":"1","sort":null,"isRec":"1","isCollect":null,"isLike":null}
     * code : 0
     */

    private String msg;
    private NextBean next;
    private VedioesBean vedioes;
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
         * id : 5d47e2035784273e2e50f081
         * uuid : 80c996e11172447598a329046231f6de
         * type : 1
         * title : 在电影中演神仙都是什么感受？
         * introduction : 三生三世白奕上神饰演者——-演员冷海铭做客大频道！
         * vedio : 201908/c04e2b3fc9774338890d9951fac3c3e4.mp4
         * vedioPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/c04e2b3fc9774338890d9951fac3c3e4.mp4
         * img : 201908/047d2f6212694f988083257d2f6f612c.png
         * imgPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/047d2f6212694f988083257d2f6f612c.png
         * clickCount : 5
         * replyCount : 0
         * likeCount : 0
         * collectCount : 0
         * shellCount : 0
         * createDate : 2019-08-05 15:58:29
         * createBy : admin
         * updateBy : null
         * updateTime : null
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
        private String vedio;
        private String vedioPath;
        private String img;
        private String imgPath;
        private int clickCount;
        private int replyCount;
        private int likeCount;
        private int collectCount;
        private int shellCount;
        private String createDate;
        private String createBy;
        private Object updateBy;
        private Object updateTime;
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

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
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
         * id : 5d49241c578427472518dc79
         * uuid : d681918bf8bf42f596a480e075475287
         * type : 1
         * title : 演员茹天老师做客大频道
         * introduction : 中国家庭——刘敏扮演者；爱情公寓1——蒙娜丽莎的扮演者，演员茹天老师。
         * vedio : 201908/aaae269b54ab4210aa6a0fe471edc487.mp4
         * vedioPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/aaae269b54ab4210aa6a0fe471edc487.mp4
         * img : 201908/ad94d8e29c3148dcab3d31c2dbef0da8.png
         * imgPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/ad94d8e29c3148dcab3d31c2dbef0da8.png
         * clickCount : 9
         * replyCount : 0
         * likeCount : 0
         * collectCount : 0
         * shellCount : 0
         * createDate : 2019-08-06 14:51:48
         * createBy : admin
         * updateBy : null
         * updateTime : null
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
        private String vedio;
        private String vedioPath;
        private String img;
        private String imgPath;
        private int clickCount;
        private int replyCount;
        private int likeCount;
        private int collectCount;
        private int shellCount;
        private String createDate;
        private String createBy;
        private Object updateBy;
        private Object updateTime;
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

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
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
}
