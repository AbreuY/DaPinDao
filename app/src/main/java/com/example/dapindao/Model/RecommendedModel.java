package com.example.dapindao.Model;

import java.util.List;

public class RecommendedModel {


    private String msg;
    private int code;
    private List<DataBean> data;
    private List<ArticleBoBean> articleBo;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<ArticleBoBean> getArticleBo() {
        return articleBo;
    }

    public void setArticleBo(List<ArticleBoBean> articleBo) {
        this.articleBo = articleBo;
    }

    public static class DataBean {
        /**
         * name : 文章
         * id : 2
         * list : [{"search":null,"params":null,"id":"5d4b8e12578427472518dc8c","uuid":"590ba8499eb54c4695bbe23ddfd25d45","artTypeId":4,"userId":2,"user":null,"adMentId":null,"labels":null,"isAdment":null,"admentClick":null,"status":null,"isTime":null,"publishDate":"2019-08-08 10:50:58","isRec":"1","introduction":"《隐秘而伟大》","title":"王伟执导、李易峰主演《隐秘而伟大》即将开播","img":null,"imgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/518e9f1d1fb1442e93b00029a9c328d8.jpg","content":null,"clickCount":null,"replyCount":null,"likeCount":null,"collectCount":null,"shellCount":null,"createDate":null,"updateTime":"2019-08-13 14:36:58","remark":null,"searchStartDate":null,"searchEndDate":null,"bigOrSmall":null,"queryUserIds":null},{"search":null,"params":null,"id":"5d4b8f14578427472518dc8d","uuid":"82f048bd2072480cb98d4d9d1bb16637","artTypeId":4,"userId":2,"user":null,"adMentId":null,"labels":null,"isAdment":null,"admentClick":null,"status":null,"isTime":null,"publishDate":"2019-08-08 10:55:16","isRec":"1","introduction":"《长安十二时辰》","title":"国产剧《长安十二时辰》表现惊艳  谨防高开走低","img":null,"imgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/8d7e07ea54b64b4abfcd3a866ea7ba8b.jpg","content":null,"clickCount":null,"replyCount":null,"likeCount":null,"collectCount":null,"shellCount":null,"createDate":null,"updateTime":"2019-08-13 14:36:56","remark":null,"searchStartDate":null,"searchEndDate":null,"bigOrSmall":null,"queryUserIds":null},{"search":null,"params":null,"id":"5d4b906b578427472518dc8e","uuid":"f28da9babab84b889a00dd50312ba878","artTypeId":3,"userId":2,"user":null,"adMentId":null,"labels":null,"isAdment":null,"admentClick":null,"status":null,"isTime":null,"publishDate":"2019-08-08 11:00:59","isRec":"1","introduction":"《哪吒之魔童降世》","title":"《哪吒之魔童降世》：\u201c每个人心中都住着一个小哪吒\u201d","img":null,"imgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/ad4ad8678a49427fba2575fc39b67cc6.jpg","content":null,"clickCount":null,"replyCount":null,"likeCount":null,"collectCount":null,"shellCount":null,"createDate":null,"updateTime":"2019-08-13 14:36:54","remark":null,"searchStartDate":null,"searchEndDate":null,"bigOrSmall":null,"queryUserIds":null}]
         */

        private String name;
        private String id;
        private List<ListBean> list;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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
             * id : 5d4b8e12578427472518dc8c
             * uuid : 590ba8499eb54c4695bbe23ddfd25d45
             * artTypeId : 4
             * userId : 2
             * user : null
             * adMentId : null
             * labels : null
             * isAdment : null
             * admentClick : null
             * status : null
             * isTime : null
             * publishDate : 2019-08-08 10:50:58
             * isRec : 1
             * introduction : 《隐秘而伟大》
             * title : 王伟执导、李易峰主演《隐秘而伟大》即将开播
             * img : null
             * imgPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/518e9f1d1fb1442e93b00029a9c328d8.jpg
             * content : null
             * clickCount : null
             * replyCount : null
             * likeCount : null
             * collectCount : null
             * shellCount : null
             * createDate : null
             * updateTime : 2019-08-13 14:36:58
             * remark : null
             * searchStartDate : null
             * searchEndDate : null
             * bigOrSmall : null
             * queryUserIds : null
             */

            private Object search;
            private Object params;
            private String id;
            private String uuid;
            private int artTypeId;
            private int userId;
            private Object user;
            private Object adMentId;
            private Object labels;
            private Object isAdment;
            private Object admentClick;
            private Object status;
            private Object isTime;
            private String publishDate;
            private String isRec;
            private String introduction;
            private String title;
            private Object img;
            private String imgPath;
            private Object content;
            private Object clickCount;
            private Object replyCount;
            private Object likeCount;
            private Object collectCount;
            private Object shellCount;
            private Object createDate;
            private String updateTime;
            private Object remark;
            private Object searchStartDate;
            private Object searchEndDate;
            private Object bigOrSmall;
            private Object queryUserIds;

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

            public int getArtTypeId() {
                return artTypeId;
            }

            public void setArtTypeId(int artTypeId) {
                this.artTypeId = artTypeId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public Object getUser() {
                return user;
            }

            public void setUser(Object user) {
                this.user = user;
            }

            public Object getAdMentId() {
                return adMentId;
            }

            public void setAdMentId(Object adMentId) {
                this.adMentId = adMentId;
            }

            public Object getLabels() {
                return labels;
            }

            public void setLabels(Object labels) {
                this.labels = labels;
            }

            public Object getIsAdment() {
                return isAdment;
            }

            public void setIsAdment(Object isAdment) {
                this.isAdment = isAdment;
            }

            public Object getAdmentClick() {
                return admentClick;
            }

            public void setAdmentClick(Object admentClick) {
                this.admentClick = admentClick;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getIsTime() {
                return isTime;
            }

            public void setIsTime(Object isTime) {
                this.isTime = isTime;
            }

            public String getPublishDate() {
                return publishDate;
            }

            public void setPublishDate(String publishDate) {
                this.publishDate = publishDate;
            }

            public String getIsRec() {
                return isRec;
            }

            public void setIsRec(String isRec) {
                this.isRec = isRec;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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

            public Object getContent() {
                return content;
            }

            public void setContent(Object content) {
                this.content = content;
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

            public Object getCreateDate() {
                return createDate;
            }

            public void setCreateDate(Object createDate) {
                this.createDate = createDate;
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

            public Object getSearchStartDate() {
                return searchStartDate;
            }

            public void setSearchStartDate(Object searchStartDate) {
                this.searchStartDate = searchStartDate;
            }

            public Object getSearchEndDate() {
                return searchEndDate;
            }

            public void setSearchEndDate(Object searchEndDate) {
                this.searchEndDate = searchEndDate;
            }

            public Object getBigOrSmall() {
                return bigOrSmall;
            }

            public void setBigOrSmall(Object bigOrSmall) {
                this.bigOrSmall = bigOrSmall;
            }

            public Object getQueryUserIds() {
                return queryUserIds;
            }

            public void setQueryUserIds(Object queryUserIds) {
                this.queryUserIds = queryUserIds;
            }
        }
    }

    public static class ArticleBoBean {
        /**
         * search : null
         * params : null
         * id : 5d417ff55784271d3fdb1a4f
         * articleId : 5d3ee36c5784273c15b2cadd
         * type : 1
         * sort : 1
         * img : 201908/f2419537736b4137a667ed3dc5b807a0.jpg
         * imgPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/f2419537736b4137a667ed3dc5b807a0.jpg
         * vedioes : null
         * article : {"search":null,"params":null,"id":"5d3ee36c5784273c15b2cadd","uuid":"edb34332a7da423d9bfd764342990877","artTypeId":12,"userId":2,"user":{"id":"5d10a81125bd2b3c68e54a69","userId":2,"loginName":"13218992617","userName":"大频道","email":"1188@qq.com","phonenumber":"13218992617","sex":"0","avatar":"201908/1cacde8b6b7d4da3ad05679f312aa53c.png","avatarpath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/1cacde8b6b7d4da3ad05679f312aa53c.png","intro":"zty"},"adMentId":null,"labels":"","isAdment":"0","admentClick":0,"status":"4","isTime":"0","publishDate":"2019-07-29 20:15:40","isRec":"0","introduction":"第十一届两岸电影展之台湾电影展开幕","title":"第十一届两岸电影展之台湾电影展隆重开幕","img":"201907/380c2d7de137419488a61eff5d467120.png","imgPath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201907/380c2d7de137419488a61eff5d467120.png","content":"<p><font color=\"#000000\" face=\"宋体\" size=\"3\">\n\n<\/font><\/p><p align=\"center\" style=\"margin: 0cm 0cm 0pt; text-align: center; line-height: 150%; text-indent: 28.1pt; mso-char-indent-count: 2.0;\"><a name=\"_GoBack\"><b><span lang=\"EN-US\" style=\"line-height: 150%; font-size: 14pt;\"><font color=\"#000000\" face=\"Calibri\">[<\/font><\/span><\/b><\/a><font color=\"#000000\"><span style=\"mso-bookmark: _GoBack;\"><b><span style=\"line-height: 150%; font-family: 宋体; font-size: 14pt; mso-fareast-font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-latin;\">大频道<\/span><\/b><\/span><span style=\"mso-bookmark: _GoBack;\"><b><span lang=\"EN-US\" style=\"line-height: 150%; font-size: 14pt;\"><font face=\"Calibri\">]<\/font><\/span><\/b><\/span><span style=\"mso-bookmark: _GoBack;\"><b><span style=\"line-height: 150%; font-family: 宋体; font-size: 14pt; mso-fareast-font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-latin;\">资讯<\/span><\/b><\/span><span style=\"mso-bookmark: _GoBack;\"><b><span lang=\"EN-US\" style=\"line-height: 150%; font-size: 14pt;\"><font face=\"Calibri\">:<\/font><\/span><\/b><\/span><span style=\"mso-bookmark: _GoBack;\"><b><span style=\"line-height: 150%; font-family: 宋体; font-size: 14pt; mso-fareast-font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-latin;\">第十一届两岸电影展之台湾电影展隆重开幕<\/span><\/b><\/span><\/font><\/p><p><font color=\"#000000\" face=\"宋体\" size=\"3\">\n\n\n\n<\/font><\/p><p style=\"margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;\"><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>2019<\/span><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">年<\/span><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>5<\/span><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">月<\/span><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>26<\/span><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">日下午<\/span><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>1<\/span><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">点<\/span><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>30<\/span><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">分，第十一届两岸电影展之台湾电影展<\/span><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>26<\/span><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">日在京开幕。该活动由国家电影局指导，中国电影基金会、两岸电影交流委员会、北京电影学院、中国电影资料馆主办。<\/span><\/p><p><font color=\"#000000\" face=\"宋体\" size=\"3\">\n\n<\/font><\/p><p align=\"left\" style=\"margin: 0cm 0cm 0pt; text-align: left; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;\"><span lang=\"EN-US\" style=\"background: white; line-height: 150%; mso-fareast-font-family: 宋体; mso-no-proof: yes;\"><font color=\"#000000\" face=\"宋体\" size=\"3\"><img style=\"max-width: 100%;\" src=\"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201907/ff73f3d28b314f63bf5c9b3a0d59fbd6.png\"><\/font><\/span><\/p><p><font color=\"#000000\" face=\"宋体\" size=\"3\">\n\n<\/font><\/p><p style=\"margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;\"><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">中央电视台<\/span><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>CCTV6<\/span><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">知名主持人郭玮担任主持开幕式。台湾著名导演、台湾电影代表团团长、两岸电影交流委员会主任委员李行，台湾著名导演、台湾电影事业发展基金会董事长朱延平，中国电影基金会理事长张丕民，中国电影基金会常务副理事长兼秘书长阎晓明，著名导演、编剧、制片人谢飞，国家电影局国际交流处处长刘春，著名表演艺术家、原八一电影制片厂厂长王晓棠，著名导演、原中国电影家协会主席、原中国电影基金会会长李前宽，台湾电影代表团全体成员，香港银都机构有限公司总裁陈一奇，香港银都机构有限公司副总经理杨雪雯，香港南方影业有限公司副总经理林云华，以及著名导演肖桂云，著名演员丛姗，北京电影学院图书馆馆长、教授、中国电影学派研究部常务副主任王海洲，中国电影评论学会常务副会长张卫，中国文联电影艺术中心电影理论研究处处长王纯等嘉宾出席了开幕式。北京电影学院师生代表、社会观众和媒体记者约<\/span><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>200<\/span><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">人参加了活动。<\/span><\/p><p><font color=\"#000000\" face=\"宋体\" size=\"3\">\n\n<\/font><\/p><p style=\"margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;\"><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">作为两岸电影交流委员会主任委员，李行表示，虽然自己<\/span><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>90<\/span><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">岁，但仍愿意担任两岸电影的搭桥人，他的毕生梦想就是能为自己所热爱的电影事业做出贡献。感谢两岸多位电影人到场参与了这次活动，同样是出于对电影事业的热爱而投身其中的各位，让李老先生感受到了很大的动力，他也表示会为两岸电影继续奉献。<\/span><\/p><p><font color=\"#000000\" face=\"宋体\" size=\"3\">\n\n<\/font><\/p><p style=\"margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;\"><span lang=\"EN-US\" style=\"background: white; line-height: 150%; mso-fareast-font-family: 宋体; mso-no-proof: yes;\"><font color=\"#000000\" face=\"宋体\" size=\"3\"><img style=\"max-width: 100%;\" src=\"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201907/96185f75bfb348b2a7dc0f22bdf0e0bd.png\"><\/font><\/span><\/p><p><font color=\"#000000\" face=\"宋体\" size=\"3\">\n\n<\/font><\/p><p style=\"margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;\"><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">本次电影展持续时间为<\/span><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>5<\/span><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">月<\/span><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>25<\/span><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">日至<\/span><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>5<\/span><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">月<\/span><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>31<\/span><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">日，在北京、承德两地举行，期间将展映《狂徒》《寒单》《山的那一边》《疯狂电视台疯电影》《只有大海知道》《小美》共<\/span><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>6<\/span><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">部影片。<\/span><\/p><p><font color=\"#000000\" face=\"宋体\" size=\"3\">\n\n<\/font><\/p><p style=\"margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;\"><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">主办方同时策划了李行电影展以及\u201c两岸电影创作：人才与市场\u201d主题论坛等活动。在活动结束后，大陆电影代表团还将赴台湾开展一系列电影文化交流活动。希望通过这些形式多样的交流活动，持续扩大两岸电影的影响力，同时让观众深入了解两岸电影和文化。<\/span><\/p><p><font color=\"#000000\" face=\"宋体\" size=\"3\">\n\n<\/font><\/p><p style=\"margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;\"><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>&nbsp;<\/span><\/p><p><font color=\"#000000\" face=\"宋体\" size=\"3\">\n\n<\/font><\/p><p style=\"margin: 0cm 0cm 0pt; line-height: 150%;\"><b><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">免责声明<\/span><\/b><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\"><font size=\"3\">：<\/font><\/span><span style=\"background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;\">自媒体综合提供的内容均源自自媒体，版权归原作者所有，转载请联系原作者并获许可。文章观点仅代表作者本人，不代表大频道立场。若内容涉及投资建议，仅供参考勿作为投资依据。寻求报道合作，请联系简先生，微信<\/span><span lang=\"EN-US\" style='background: white; color: black; line-height: 150%; font-family: \"Arial\",\"sans-serif\"; font-size: 12pt; mso-fareast-font-family: 宋体;'>wujun565028<\/span><\/p><p><font color=\"#000000\" face=\"宋体\" size=\"3\">\n\n<\/font><br><\/p>","clickCount":0,"replyCount":0,"likeCount":0,"collectCount":0,"shellCount":0,"createDate":"2019-07-29 20:15:40","updateTime":"2019-07-29 20:15:40","remark":null,"searchStartDate":null,"searchEndDate":null,"bigOrSmall":null,"queryUserIds":null}
         */

        private Object search;
        private Object params;
        private String id;
        private String articleId;
        private String type;
        private int sort;
        private String img;
        private String imgPath;
        private Object vedioes;
        private ArticleBean article;

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

        public String getArticleId() {
            return articleId;
        }

        public void setArticleId(String articleId) {
            this.articleId = articleId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
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

        public Object getVedioes() {
            return vedioes;
        }

        public void setVedioes(Object vedioes) {
            this.vedioes = vedioes;
        }

        public ArticleBean getArticle() {
            return article;
        }

        public void setArticle(ArticleBean article) {
            this.article = article;
        }

        public static class ArticleBean {
            /**
             * search : null
             * params : null
             * id : 5d3ee36c5784273c15b2cadd
             * uuid : edb34332a7da423d9bfd764342990877
             * artTypeId : 12
             * userId : 2
             * user : {"id":"5d10a81125bd2b3c68e54a69","userId":2,"loginName":"13218992617","userName":"大频道","email":"1188@qq.com","phonenumber":"13218992617","sex":"0","avatar":"201908/1cacde8b6b7d4da3ad05679f312aa53c.png","avatarpath":"http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/1cacde8b6b7d4da3ad05679f312aa53c.png","intro":"zty"}
             * adMentId : null
             * labels :
             * isAdment : 0
             * admentClick : 0
             * status : 4
             * isTime : 0
             * publishDate : 2019-07-29 20:15:40
             * isRec : 0
             * introduction : 第十一届两岸电影展之台湾电影展开幕
             * title : 第十一届两岸电影展之台湾电影展隆重开幕
             * img : 201907/380c2d7de137419488a61eff5d467120.png
             * imgPath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201907/380c2d7de137419488a61eff5d467120.png
             * content : <p><font color="#000000" face="宋体" size="3">

             </font></p><p align="center" style="margin: 0cm 0cm 0pt; text-align: center; line-height: 150%; text-indent: 28.1pt; mso-char-indent-count: 2.0;"><a name="_GoBack"><b><span lang="EN-US" style="line-height: 150%; font-size: 14pt;"><font color="#000000" face="Calibri">[</font></span></b></a><font color="#000000"><span style="mso-bookmark: _GoBack;"><b><span style="line-height: 150%; font-family: 宋体; font-size: 14pt; mso-fareast-font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-latin;">大频道</span></b></span><span style="mso-bookmark: _GoBack;"><b><span lang="EN-US" style="line-height: 150%; font-size: 14pt;"><font face="Calibri">]</font></span></b></span><span style="mso-bookmark: _GoBack;"><b><span style="line-height: 150%; font-family: 宋体; font-size: 14pt; mso-fareast-font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-latin;">资讯</span></b></span><span style="mso-bookmark: _GoBack;"><b><span lang="EN-US" style="line-height: 150%; font-size: 14pt;"><font face="Calibri">:</font></span></b></span><span style="mso-bookmark: _GoBack;"><b><span style="line-height: 150%; font-family: 宋体; font-size: 14pt; mso-fareast-font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri; mso-ascii-theme-font: minor-latin; mso-fareast-theme-font: minor-fareast; mso-hansi-theme-font: minor-latin;">第十一届两岸电影展之台湾电影展隆重开幕</span></b></span></font></p><p><font color="#000000" face="宋体" size="3">



             </font></p><p style="margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;"><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>2019</span><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">年</span><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>5</span><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">月</span><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>26</span><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">日下午</span><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>1</span><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">点</span><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>30</span><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">分，第十一届两岸电影展之台湾电影展</span><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>26</span><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">日在京开幕。该活动由国家电影局指导，中国电影基金会、两岸电影交流委员会、北京电影学院、中国电影资料馆主办。</span></p><p><font color="#000000" face="宋体" size="3">

             </font></p><p align="left" style="margin: 0cm 0cm 0pt; text-align: left; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;"><span lang="EN-US" style="background: white; line-height: 150%; mso-fareast-font-family: 宋体; mso-no-proof: yes;"><font color="#000000" face="宋体" size="3"><img style="max-width: 100%;" src="http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201907/ff73f3d28b314f63bf5c9b3a0d59fbd6.png"></font></span></p><p><font color="#000000" face="宋体" size="3">

             </font></p><p style="margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;"><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">中央电视台</span><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>CCTV6</span><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">知名主持人郭玮担任主持开幕式。台湾著名导演、台湾电影代表团团长、两岸电影交流委员会主任委员李行，台湾著名导演、台湾电影事业发展基金会董事长朱延平，中国电影基金会理事长张丕民，中国电影基金会常务副理事长兼秘书长阎晓明，著名导演、编剧、制片人谢飞，国家电影局国际交流处处长刘春，著名表演艺术家、原八一电影制片厂厂长王晓棠，著名导演、原中国电影家协会主席、原中国电影基金会会长李前宽，台湾电影代表团全体成员，香港银都机构有限公司总裁陈一奇，香港银都机构有限公司副总经理杨雪雯，香港南方影业有限公司副总经理林云华，以及著名导演肖桂云，著名演员丛姗，北京电影学院图书馆馆长、教授、中国电影学派研究部常务副主任王海洲，中国电影评论学会常务副会长张卫，中国文联电影艺术中心电影理论研究处处长王纯等嘉宾出席了开幕式。北京电影学院师生代表、社会观众和媒体记者约</span><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>200</span><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">人参加了活动。</span></p><p><font color="#000000" face="宋体" size="3">

             </font></p><p style="margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;"><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">作为两岸电影交流委员会主任委员，李行表示，虽然自己</span><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>90</span><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">岁，但仍愿意担任两岸电影的搭桥人，他的毕生梦想就是能为自己所热爱的电影事业做出贡献。感谢两岸多位电影人到场参与了这次活动，同样是出于对电影事业的热爱而投身其中的各位，让李老先生感受到了很大的动力，他也表示会为两岸电影继续奉献。</span></p><p><font color="#000000" face="宋体" size="3">

             </font></p><p style="margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;"><span lang="EN-US" style="background: white; line-height: 150%; mso-fareast-font-family: 宋体; mso-no-proof: yes;"><font color="#000000" face="宋体" size="3"><img style="max-width: 100%;" src="http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201907/96185f75bfb348b2a7dc0f22bdf0e0bd.png"></font></span></p><p><font color="#000000" face="宋体" size="3">

             </font></p><p style="margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;"><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">本次电影展持续时间为</span><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>5</span><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">月</span><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>25</span><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">日至</span><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>5</span><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">月</span><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>31</span><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">日，在北京、承德两地举行，期间将展映《狂徒》《寒单》《山的那一边》《疯狂电视台疯电影》《只有大海知道》《小美》共</span><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>6</span><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">部影片。</span></p><p><font color="#000000" face="宋体" size="3">

             </font></p><p style="margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;"><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">主办方同时策划了李行电影展以及“两岸电影创作：人才与市场”主题论坛等活动。在活动结束后，大陆电影代表团还将赴台湾开展一系列电影文化交流活动。希望通过这些形式多样的交流活动，持续扩大两岸电影的影响力，同时让观众深入了解两岸电影和文化。</span></p><p><font color="#000000" face="宋体" size="3">

             </font></p><p style="margin: 0cm 0cm 0pt; line-height: 150%; text-indent: 24pt; mso-char-indent-count: 2.0;"><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>&nbsp;</span></p><p><font color="#000000" face="宋体" size="3">

             </font></p><p style="margin: 0cm 0cm 0pt; line-height: 150%;"><b><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">免责声明</span></b><span style="background: white; color: black; line-height: 150%; font-family: 宋体; mso-bidi-font-size: 10.5pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;"><font size="3">：</font></span><span style="background: white; color: black; line-height: 150%; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: Arial; mso-ascii-font-family: Arial; mso-hansi-font-family: Arial;">自媒体综合提供的内容均源自自媒体，版权归原作者所有，转载请联系原作者并获许可。文章观点仅代表作者本人，不代表大频道立场。若内容涉及投资建议，仅供参考勿作为投资依据。寻求报道合作，请联系简先生，微信</span><span lang="EN-US" style='background: white; color: black; line-height: 150%; font-family: "Arial","sans-serif"; font-size: 12pt; mso-fareast-font-family: 宋体;'>wujun565028</span></p><p><font color="#000000" face="宋体" size="3">

             </font><br></p>
             * clickCount : 0
             * replyCount : 0
             * likeCount : 0
             * collectCount : 0
             * shellCount : 0
             * createDate : 2019-07-29 20:15:40
             * updateTime : 2019-07-29 20:15:40
             * remark : null
             * searchStartDate : null
             * searchEndDate : null
             * bigOrSmall : null
             * queryUserIds : null
             */

            private Object search;
            private Object params;
            private String id;
            private String uuid;
            private int artTypeId;
            private int userId;
            private UserBean user;
            private Object adMentId;
            private String labels;
            private String isAdment;
            private int admentClick;
            private String status;
            private String isTime;
            private String publishDate;
            private String isRec;
            private String introduction;
            private String title;
            private String img;
            private String imgPath;
            private String content;
            private int clickCount;
            private int replyCount;
            private int likeCount;
            private int collectCount;
            private int shellCount;
            private String createDate;
            private String updateTime;
            private Object remark;
            private Object searchStartDate;
            private Object searchEndDate;
            private Object bigOrSmall;
            private Object queryUserIds;

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

            public int getArtTypeId() {
                return artTypeId;
            }

            public void setArtTypeId(int artTypeId) {
                this.artTypeId = artTypeId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public Object getAdMentId() {
                return adMentId;
            }

            public void setAdMentId(Object adMentId) {
                this.adMentId = adMentId;
            }

            public String getLabels() {
                return labels;
            }

            public void setLabels(String labels) {
                this.labels = labels;
            }

            public String getIsAdment() {
                return isAdment;
            }

            public void setIsAdment(String isAdment) {
                this.isAdment = isAdment;
            }

            public int getAdmentClick() {
                return admentClick;
            }

            public void setAdmentClick(int admentClick) {
                this.admentClick = admentClick;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getIsTime() {
                return isTime;
            }

            public void setIsTime(String isTime) {
                this.isTime = isTime;
            }

            public String getPublishDate() {
                return publishDate;
            }

            public void setPublishDate(String publishDate) {
                this.publishDate = publishDate;
            }

            public String getIsRec() {
                return isRec;
            }

            public void setIsRec(String isRec) {
                this.isRec = isRec;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
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

            public Object getSearchStartDate() {
                return searchStartDate;
            }

            public void setSearchStartDate(Object searchStartDate) {
                this.searchStartDate = searchStartDate;
            }

            public Object getSearchEndDate() {
                return searchEndDate;
            }

            public void setSearchEndDate(Object searchEndDate) {
                this.searchEndDate = searchEndDate;
            }

            public Object getBigOrSmall() {
                return bigOrSmall;
            }

            public void setBigOrSmall(Object bigOrSmall) {
                this.bigOrSmall = bigOrSmall;
            }

            public Object getQueryUserIds() {
                return queryUserIds;
            }

            public void setQueryUserIds(Object queryUserIds) {
                this.queryUserIds = queryUserIds;
            }

            public static class UserBean {
                /**
                 * id : 5d10a81125bd2b3c68e54a69
                 * userId : 2
                 * loginName : 13218992617
                 * userName : 大频道
                 * email : 1188@qq.com
                 * phonenumber : 13218992617
                 * sex : 0
                 * avatar : 201908/1cacde8b6b7d4da3ad05679f312aa53c.png
                 * avatarpath : http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/1cacde8b6b7d4da3ad05679f312aa53c.png
                 * intro : zty
                 */

                private String id;
                private int userId;
                private String loginName;
                private String userName;
                private String email;
                private String phonenumber;
                private String sex;
                private String avatar;
                private String avatarpath;
                private String intro;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getLoginName() {
                    return loginName;
                }

                public void setLoginName(String loginName) {
                    this.loginName = loginName;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public String getPhonenumber() {
                    return phonenumber;
                }

                public void setPhonenumber(String phonenumber) {
                    this.phonenumber = phonenumber;
                }

                public String getSex() {
                    return sex;
                }

                public void setSex(String sex) {
                    this.sex = sex;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getAvatarpath() {
                    return avatarpath;
                }

                public void setAvatarpath(String avatarpath) {
                    this.avatarpath = avatarpath;
                }

                public String getIntro() {
                    return intro;
                }

                public void setIntro(String intro) {
                    this.intro = intro;
                }
            }
        }
    }
}
