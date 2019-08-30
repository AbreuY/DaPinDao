package com.example.dapindao.Model;

import java.util.List;

public class VideobyModel {


    /**
     * msg : 成功
     * result : {"total":2,"rows":[{"search":null,"params":null,"id":"5d49241c578427472518dc79","uuid":"d681918bf8bf42f596a480e075475287","type":"1","title":"演员茹天老师做客大频道","introduction":"中国家庭\u2014\u2014刘敏扮演者；爱情公寓1\u2014\u2014蒙娜丽莎的扮演者，演员茹天老师。","vedio":null,"vedioPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/aaae269b54ab4210aa6a0fe471edc487.mp4","img":null,"imgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/ad94d8e29c3148dcab3d31c2dbef0da8.png","clickCount":null,"replyCount":null,"likeCount":null,"collectCount":null,"shellCount":null,"createDate":"2019-08-06 14:51:48","createBy":null,"updateBy":null,"updateTime":null,"remark":null,"isShow":null,"sort":null,"isRec":null,"isCollect":null,"isLike":null},{"search":null,"params":null,"id":"5d47e2035784273e2e50f081","uuid":"80c996e11172447598a329046231f6de","type":"1","title":"在电影中演神仙都是什么感受？","introduction":"三生三世白奕上神饰演者\u2014\u2014-演员冷海铭做客大频道！","vedio":null,"vedioPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/c04e2b3fc9774338890d9951fac3c3e4.mp4","img":null,"imgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/047d2f6212694f988083257d2f6f612c.png","clickCount":null,"replyCount":null,"likeCount":null,"collectCount":null,"shellCount":null,"createDate":"2019-08-05 15:58:29","createBy":null,"updateBy":null,"updateTime":null,"remark":null,"isShow":null,"sort":null,"isRec":null,"isCollect":null,"isLike":null}],"code":0,"totalPage":1,"pageSize":0}
     * code : 0
     */

    private String msg;
    private ResultBean result;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        /**
         * total : 2
         * rows : [{"search":null,"params":null,"id":"5d49241c578427472518dc79","uuid":"d681918bf8bf42f596a480e075475287","type":"1","title":"演员茹天老师做客大频道","introduction":"中国家庭\u2014\u2014刘敏扮演者；爱情公寓1\u2014\u2014蒙娜丽莎的扮演者，演员茹天老师。","vedio":null,"vedioPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/aaae269b54ab4210aa6a0fe471edc487.mp4","img":null,"imgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/ad94d8e29c3148dcab3d31c2dbef0da8.png","clickCount":null,"replyCount":null,"likeCount":null,"collectCount":null,"shellCount":null,"createDate":"2019-08-06 14:51:48","createBy":null,"updateBy":null,"updateTime":null,"remark":null,"isShow":null,"sort":null,"isRec":null,"isCollect":null,"isLike":null},{"search":null,"params":null,"id":"5d47e2035784273e2e50f081","uuid":"80c996e11172447598a329046231f6de","type":"1","title":"在电影中演神仙都是什么感受？","introduction":"三生三世白奕上神饰演者\u2014\u2014-演员冷海铭做客大频道！","vedio":null,"vedioPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/c04e2b3fc9774338890d9951fac3c3e4.mp4","img":null,"imgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/047d2f6212694f988083257d2f6f612c.png","clickCount":null,"replyCount":null,"likeCount":null,"collectCount":null,"shellCount":null,"createDate":"2019-08-05 15:58:29","createBy":null,"updateBy":null,"updateTime":null,"remark":null,"isShow":null,"sort":null,"isRec":null,"isCollect":null,"isLike":null}]
         * code : 0
         * totalPage : 1
         * pageSize : 0
         */

        private int total;
        private int code;
        private int totalPage;
        private int pageSize;
        private List<RowsBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            /**
             * search : null
             * params : null
             * id : 5d49241c578427472518dc79
             * uuid : d681918bf8bf42f596a480e075475287
             * type : 1
             * title : 演员茹天老师做客大频道
             * introduction : 中国家庭——刘敏扮演者；爱情公寓1——蒙娜丽莎的扮演者，演员茹天老师。
             * vedio : null
             * vedioPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/aaae269b54ab4210aa6a0fe471edc487.mp4
             * img : null
             * imgPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/ad94d8e29c3148dcab3d31c2dbef0da8.png
             * clickCount : null
             * replyCount : null
             * likeCount : null
             * collectCount : null
             * shellCount : null
             * createDate : 2019-08-06 14:51:48
             * createBy : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * isShow : null
             * sort : null
             * isRec : null
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
            private Object vedio;
            private String vedioPath;
            private Object img;
            private String imgPath;
            private Object clickCount;
            private Object replyCount;
            private Object likeCount;
            private Object collectCount;
            private Object shellCount;
            private String createDate;
            private Object createBy;
            private Object updateBy;
            private Object updateTime;
            private Object remark;
            private Object isShow;
            private Object sort;
            private Object isRec;
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

            public Object getVedio() {
                return vedio;
            }

            public void setVedio(Object vedio) {
                this.vedio = vedio;
            }

            public String getVedioPath() {
                return vedioPath;
            }

            public void setVedioPath(String vedioPath) {
                this.vedioPath = vedioPath;
            }

            public Object getImg() {
                return img;
            }

            public void setImg(Object img) {
                this.img = img;
            }

            public String getImgPath() {
                return imgPath;
            }

            public void setImgPath(String imgPath) {
                this.imgPath = imgPath;
            }

            public Object getClickCount() {
                return clickCount;
            }

            public void setClickCount(Object clickCount) {
                this.clickCount = clickCount;
            }

            public Object getReplyCount() {
                return replyCount;
            }

            public void setReplyCount(Object replyCount) {
                this.replyCount = replyCount;
            }

            public Object getLikeCount() {
                return likeCount;
            }

            public void setLikeCount(Object likeCount) {
                this.likeCount = likeCount;
            }

            public Object getCollectCount() {
                return collectCount;
            }

            public void setCollectCount(Object collectCount) {
                this.collectCount = collectCount;
            }

            public Object getShellCount() {
                return shellCount;
            }

            public void setShellCount(Object shellCount) {
                this.shellCount = shellCount;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public Object getCreateBy() {
                return createBy;
            }

            public void setCreateBy(Object createBy) {
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

            public Object getIsShow() {
                return isShow;
            }

            public void setIsShow(Object isShow) {
                this.isShow = isShow;
            }

            public Object getSort() {
                return sort;
            }

            public void setSort(Object sort) {
                this.sort = sort;
            }

            public Object getIsRec() {
                return isRec;
            }

            public void setIsRec(Object isRec) {
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
}
