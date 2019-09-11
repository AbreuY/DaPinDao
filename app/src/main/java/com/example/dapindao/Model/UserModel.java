package com.example.dapindao.Model;

import java.util.List;

public class UserModel {


    /**
     * msg : 成功
     * code : 0
     * user : {"searchValue":null,"createBy":null,"createTime":"2019-08-16 10:07:20","updateBy":null,"updateTime":null,"remark":null,"params":{},"search":null,"userId":13,"deptId":null,"parentId":null,"roleId":null,"loginName":"18552026537","userName":"新用户24957677","email":"","phonenumber":"18552026537","sex":"0","avatar":"","avatarPath":null,"password":"","salt":"","status":"0","delFlag":"0","loginIp":"","loginDate":null,"dept":{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"deptId":null,"parentId":null,"ancestors":null,"deptName":null,"orderNum":null,"leader":null,"phone":null,"email":null,"status":null,"delFlag":null,"parentName":null},"roles":[],"roleIds":null,"postIds":null,"integral":0,"contineCheckDays":0,"checkDate":null,"isAuth":"0","actName":null,"actCard":null,"cardPo":null,"cardPoPath":null,"cardNe":null,"cardNePath":null,"cardAll":null,"cardAllPath":null,"company":null,"job":null,"authRemark":null,"articleNum":0,"redEnvelope":0,"allWithdraw":0,"wxOpenId":null,"wbOpenId":null,"isFirstAuth":"0","isFirstBindWB":"0","isFirstBindWX":"0","isFirstUpdateInfo":"0","balance":0,"isShuiYin":"0","intro":null,"isCheck":"0","isGuan":null,"vipLevel":"0","vipExpireDate":null,"authorLevel":0,"levelDate":null,"banNum":0,"banDate":null,"todayPubArtNum":0,"weekPubArtNum":0,"weekRecArtNum":0,"userLikeClickNum":0,"qualityScore":0,"activeScore":0,"userLikeScore":0,"dpdScore":0,"allActiveScore":0,"allWeekNum":0,"userType":null,"admin":false}
     */


    private int code;
    private String msg;
    private UserBean user;

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

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * searchValue : null
         * createBy : null
         * createTime : 2019-08-16 10:07:20
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * search : null
         * userId : 13
         * deptId : null
         * parentId : null
         * roleId : null
         * loginName : 18552026537
         * userName : 新用户24957677
         * email :
         * phonenumber : 18552026537
         * sex : 0
         * avatar :
         * avatarPath : null
         * password :
         * salt :
         * status : 0
         * delFlag : 0
         * loginIp :
         * loginDate : null
         * dept : {"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"deptId":null,"parentId":null,"ancestors":null,"deptName":null,"orderNum":null,"leader":null,"phone":null,"email":null,"status":null,"delFlag":null,"parentName":null}
         * roles : []
         * roleIds : null
         * postIds : null
         * integral : 0
         * contineCheckDays : 0
         * checkDate : null
         * isAuth : 0
         * actName : null
         * actCard : null
         * cardPo : null
         * cardPoPath : null
         * cardNe : null
         * cardNePath : null
         * cardAll : null
         * cardAllPath : null
         * company : null
         * job : null
         * authRemark : null
         * articleNum : 0
         * redEnvelope : 0
         * allWithdraw : 0
         * wxOpenId : null
         * wbOpenId : null
         * isFirstAuth : 0
         * isFirstBindWB : 0
         * isFirstBindWX : 0
         * isFirstUpdateInfo : 0
         * balance : 0
         * isShuiYin : 0
         * intro : null
         * isCheck : 0
         * isGuan : null
         * vipLevel : 0
         * vipExpireDate : null
         * authorLevel : 0
         * levelDate : null
         * banNum : 0
         * banDate : null
         * todayPubArtNum : 0
         * weekPubArtNum : 0
         * weekRecArtNum : 0
         * userLikeClickNum : 0
         * qualityScore : 0
         * activeScore : 0
         * userLikeScore : 0
         * dpdScore : 0
         * allActiveScore : 0
         * allWeekNum : 0
         * userType : null
         * admin : false
         */

        private Object searchValue;
        private Object createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsBean params;
        private Object search;
        private int userId;
        private int deptId;
        private int parentId;
        private int roleId;
        private String loginName;
        private String userName;
        private String email;
        private String phonenumber;
        private String sex;
        private String avatar;
        private String avatarPath;
        private String password;
        private String salt;
        private String status;
        private String delFlag;
        private String loginIp;
        private Object loginDate;
        private DeptBean dept;
        private Object roleIds;
        private Object postIds;
        private int integral;
        private int contineCheckDays;
        private Object checkDate;
        private String isAuth;
        private Object actName;
        private Object actCard;
        private Object cardPo;
        private Object cardPoPath;
        private Object cardNe;
        private Object cardNePath;
        private Object cardAll;
        private Object cardAllPath;
        private Object company;
        private Object job;
        private Object authRemark;
        private int articleNum;
        private int redEnvelope;
        private int allWithdraw;
        private Object wxOpenId;
        private Object wbOpenId;
        private String isFirstAuth;
        private String isFirstBindWB;
        private String isFirstBindWX;
        private String isFirstUpdateInfo;
        private int balance;
        private long fansNum;
        private String isShuiYin;
        private Object intro;
        private String isCheck;
        private Object isGuan;
        private String vipLevel;
        private Object vipExpireDate;
        private int authorLevel;
        private Object levelDate;
        private int banNum;
        private Object banDate;
        private int todayPubArtNum;
        private int weekPubArtNum;
        private int weekRecArtNum;
        private int userLikeClickNum;
        private int qualityScore;
        private int activeScore;
        private int userLikeScore;
        private int dpdScore;
        private int allActiveScore;
        private int allWeekNum;
        private Object userType;
        private boolean admin;
        private List<?> roles;

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
            this.searchValue = searchValue;
        }

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
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

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public Object getSearch() {
            return search;
        }

        public void setSearch(Object search) {
            this.search = search;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getDeptId() {
            return deptId;
        }

        public void setDeptId(int deptId) {
            this.deptId = deptId;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
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

        public String getAvatarPath() {
            return avatarPath;
        }

        public void setAvatarPath(String avatarPath) {
            this.avatarPath = avatarPath;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public long getFansNum() {
            return fansNum;
        }

        public void setFansNum(long fansNum) {
            this.fansNum = fansNum;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(String delFlag) {
            this.delFlag = delFlag;
        }

        public String getLoginIp() {
            return loginIp;
        }

        public void setLoginIp(String loginIp) {
            this.loginIp = loginIp;
        }

        public Object getLoginDate() {
            return loginDate;
        }

        public void setLoginDate(Object loginDate) {
            this.loginDate = loginDate;
        }

        public DeptBean getDept() {
            return dept;
        }

        public void setDept(DeptBean dept) {
            this.dept = dept;
        }

        public Object getRoleIds() {
            return roleIds;
        }

        public void setRoleIds(Object roleIds) {
            this.roleIds = roleIds;
        }

        public Object getPostIds() {
            return postIds;
        }

        public void setPostIds(Object postIds) {
            this.postIds = postIds;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public int getContineCheckDays() {
            return contineCheckDays;
        }

        public void setContineCheckDays(int contineCheckDays) {
            this.contineCheckDays = contineCheckDays;
        }

        public Object getCheckDate() {
            return checkDate;
        }

        public void setCheckDate(Object checkDate) {
            this.checkDate = checkDate;
        }

        public String getIsAuth() {
            return isAuth;
        }

        public void setIsAuth(String isAuth) {
            this.isAuth = isAuth;
        }

        public Object getActName() {
            return actName;
        }

        public void setActName(Object actName) {
            this.actName = actName;
        }

        public Object getActCard() {
            return actCard;
        }

        public void setActCard(Object actCard) {
            this.actCard = actCard;
        }

        public Object getCardPo() {
            return cardPo;
        }

        public void setCardPo(Object cardPo) {
            this.cardPo = cardPo;
        }

        public Object getCardPoPath() {
            return cardPoPath;
        }

        public void setCardPoPath(Object cardPoPath) {
            this.cardPoPath = cardPoPath;
        }

        public Object getCardNe() {
            return cardNe;
        }

        public void setCardNe(Object cardNe) {
            this.cardNe = cardNe;
        }

        public Object getCardNePath() {
            return cardNePath;
        }

        public void setCardNePath(Object cardNePath) {
            this.cardNePath = cardNePath;
        }

        public Object getCardAll() {
            return cardAll;
        }

        public void setCardAll(Object cardAll) {
            this.cardAll = cardAll;
        }

        public Object getCardAllPath() {
            return cardAllPath;
        }

        public void setCardAllPath(Object cardAllPath) {
            this.cardAllPath = cardAllPath;
        }

        public Object getCompany() {
            return company;
        }

        public void setCompany(Object company) {
            this.company = company;
        }

        public Object getJob() {
            return job;
        }

        public void setJob(Object job) {
            this.job = job;
        }

        public Object getAuthRemark() {
            return authRemark;
        }

        public void setAuthRemark(Object authRemark) {
            this.authRemark = authRemark;
        }

        public int getArticleNum() {
            return articleNum;
        }

        public void setArticleNum(int articleNum) {
            this.articleNum = articleNum;
        }

        public int getRedEnvelope() {
            return redEnvelope;
        }

        public void setRedEnvelope(int redEnvelope) {
            this.redEnvelope = redEnvelope;
        }

        public int getAllWithdraw() {
            return allWithdraw;
        }

        public void setAllWithdraw(int allWithdraw) {
            this.allWithdraw = allWithdraw;
        }

        public Object getWxOpenId() {
            return wxOpenId;
        }

        public void setWxOpenId(Object wxOpenId) {
            this.wxOpenId = wxOpenId;
        }

        public Object getWbOpenId() {
            return wbOpenId;
        }

        public void setWbOpenId(Object wbOpenId) {
            this.wbOpenId = wbOpenId;
        }

        public String getIsFirstAuth() {
            return isFirstAuth;
        }

        public void setIsFirstAuth(String isFirstAuth) {
            this.isFirstAuth = isFirstAuth;
        }

        public String getIsFirstBindWB() {
            return isFirstBindWB;
        }

        public void setIsFirstBindWB(String isFirstBindWB) {
            this.isFirstBindWB = isFirstBindWB;
        }

        public String getIsFirstBindWX() {
            return isFirstBindWX;
        }

        public void setIsFirstBindWX(String isFirstBindWX) {
            this.isFirstBindWX = isFirstBindWX;
        }

        public String getIsFirstUpdateInfo() {
            return isFirstUpdateInfo;
        }

        public void setIsFirstUpdateInfo(String isFirstUpdateInfo) {
            this.isFirstUpdateInfo = isFirstUpdateInfo;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public String getIsShuiYin() {
            return isShuiYin;
        }

        public void setIsShuiYin(String isShuiYin) {
            this.isShuiYin = isShuiYin;
        }

        public Object getIntro() {
            return intro;
        }

        public void setIntro(Object intro) {
            this.intro = intro;
        }

        public String getIsCheck() {
            return isCheck;
        }

        public void setIsCheck(String isCheck) {
            this.isCheck = isCheck;
        }

        public Object getIsGuan() {
            return isGuan;
        }

        public void setIsGuan(Object isGuan) {
            this.isGuan = isGuan;
        }

        public String getVipLevel() {
            return vipLevel;
        }

        public void setVipLevel(String vipLevel) {
            this.vipLevel = vipLevel;
        }

        public Object getVipExpireDate() {
            return vipExpireDate;
        }

        public void setVipExpireDate(Object vipExpireDate) {
            this.vipExpireDate = vipExpireDate;
        }

        public int getAuthorLevel() {
            return authorLevel;
        }

        public void setAuthorLevel(int authorLevel) {
            this.authorLevel = authorLevel;
        }

        public Object getLevelDate() {
            return levelDate;
        }

        public void setLevelDate(Object levelDate) {
            this.levelDate = levelDate;
        }

        public int getBanNum() {
            return banNum;
        }

        public void setBanNum(int banNum) {
            this.banNum = banNum;
        }

        public Object getBanDate() {
            return banDate;
        }

        public void setBanDate(Object banDate) {
            this.banDate = banDate;
        }

        public int getTodayPubArtNum() {
            return todayPubArtNum;
        }

        public void setTodayPubArtNum(int todayPubArtNum) {
            this.todayPubArtNum = todayPubArtNum;
        }

        public int getWeekPubArtNum() {
            return weekPubArtNum;
        }

        public void setWeekPubArtNum(int weekPubArtNum) {
            this.weekPubArtNum = weekPubArtNum;
        }

        public int getWeekRecArtNum() {
            return weekRecArtNum;
        }

        public void setWeekRecArtNum(int weekRecArtNum) {
            this.weekRecArtNum = weekRecArtNum;
        }

        public int getUserLikeClickNum() {
            return userLikeClickNum;
        }

        public void setUserLikeClickNum(int userLikeClickNum) {
            this.userLikeClickNum = userLikeClickNum;
        }

        public int getQualityScore() {
            return qualityScore;
        }

        public void setQualityScore(int qualityScore) {
            this.qualityScore = qualityScore;
        }

        public int getActiveScore() {
            return activeScore;
        }

        public void setActiveScore(int activeScore) {
            this.activeScore = activeScore;
        }

        public int getUserLikeScore() {
            return userLikeScore;
        }

        public void setUserLikeScore(int userLikeScore) {
            this.userLikeScore = userLikeScore;
        }

        public int getDpdScore() {
            return dpdScore;
        }

        public void setDpdScore(int dpdScore) {
            this.dpdScore = dpdScore;
        }

        public int getAllActiveScore() {
            return allActiveScore;
        }

        public void setAllActiveScore(int allActiveScore) {
            this.allActiveScore = allActiveScore;
        }

        public int getAllWeekNum() {
            return allWeekNum;
        }

        public void setAllWeekNum(int allWeekNum) {
            this.allWeekNum = allWeekNum;
        }

        public Object getUserType() {
            return userType;
        }

        public void setUserType(Object userType) {
            this.userType = userType;
        }

        public boolean isAdmin() {
            return admin;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public List<?> getRoles() {
            return roles;
        }

        public void setRoles(List<?> roles) {
            this.roles = roles;
        }

        public static class ParamsBean {
        }

        public static class DeptBean {
            /**
             * searchValue : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * remark : null
             * params : {}
             * deptId : null
             * parentId : null
             * ancestors : null
             * deptName : null
             * orderNum : null
             * leader : null
             * phone : null
             * email : null
             * status : null
             * delFlag : null
             * parentName : null
             */

            private Object searchValue;
            private Object createBy;
            private Object createTime;
            private Object updateBy;
            private Object updateTime;
            private Object remark;
            private ParamsBeanX params;
            private Object deptId;
            private Object parentId;
            private Object ancestors;
            private Object deptName;
            private Object orderNum;
            private Object leader;
            private Object phone;
            private Object email;
            private Object status;
            private Object delFlag;
            private Object parentName;

            public Object getSearchValue() {
                return searchValue;
            }

            public void setSearchValue(Object searchValue) {
                this.searchValue = searchValue;
            }

            public Object getCreateBy() {
                return createBy;
            }

            public void setCreateBy(Object createBy) {
                this.createBy = createBy;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
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

            public ParamsBeanX getParams() {
                return params;
            }

            public void setParams(ParamsBeanX params) {
                this.params = params;
            }

            public Object getDeptId() {
                return deptId;
            }

            public void setDeptId(Object deptId) {
                this.deptId = deptId;
            }

            public Object getParentId() {
                return parentId;
            }

            public void setParentId(Object parentId) {
                this.parentId = parentId;
            }

            public Object getAncestors() {
                return ancestors;
            }

            public void setAncestors(Object ancestors) {
                this.ancestors = ancestors;
            }

            public Object getDeptName() {
                return deptName;
            }

            public void setDeptName(Object deptName) {
                this.deptName = deptName;
            }

            public Object getOrderNum() {
                return orderNum;
            }

            public void setOrderNum(Object orderNum) {
                this.orderNum = orderNum;
            }

            public Object getLeader() {
                return leader;
            }

            public void setLeader(Object leader) {
                this.leader = leader;
            }

            public Object getPhone() {
                return phone;
            }

            public void setPhone(Object phone) {
                this.phone = phone;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(Object delFlag) {
                this.delFlag = delFlag;
            }

            public Object getParentName() {
                return parentName;
            }

            public void setParentName(Object parentName) {
                this.parentName = parentName;
            }

            public static class ParamsBeanX {
            }
        }
    }

}
