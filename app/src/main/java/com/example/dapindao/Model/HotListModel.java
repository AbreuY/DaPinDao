package com.example.dapindao.Model;

import java.util.List;

public class HotListModel {

    /**
     * msg : 成功
     * code : 0
     * list : [{"element":"5d4b8f14578427472518dc8d:::国产剧《长安十二时辰》表现惊艳  谨防高开走低:::http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/8d7e07ea54b64b4abfcd3a866ea7ba8b.jpg:::2019-08-08 10:55:16","score":2,"binaryElement":"NWQ0YjhmMTQ1Nzg0Mjc0NzI1MThkYzhkOjo65Zu95Lqn5Ymn44CK6ZW/5a6J5Y2B5LqM5pe26L6w44CL6KGo546w5oOK6ImzICDosKjpmLLpq5jlvIDotbDkvY46OjpodHRwOi8vYmlnY2hhbm5lbC5vc3MtY24taGFuZ3pob3UuYWxpeXVuY3MuY29tLzIwMTkwOC84ZDdlMDdlYTU0YjY0YjRhYmZjZDNhODY2ZWE3YmE4Yi5qcGc6OjoyMDE5LTA4LTA4IDEwOjU1OjE2"},{"element":"5d493732578427472518dc7c:::《柯南》:30年都长不大的侦探:::http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/83395ed443044ff58d1b36b4aaa08cf6.jpg:::2019-08-06 16:15:46","score":1,"binaryElement":"NWQ0OTM3MzI1Nzg0Mjc0NzI1MThkYzdjOjo644CK5p+v5Y2X44CLOjMw5bm06YO96ZW/5LiN5aSn55qE5L6m5o6iOjo6aHR0cDovL2JpZ2NoYW5uZWwub3NzLWNuLWhhbmd6aG91LmFsaXl1bmNzLmNvbS8yMDE5MDgvODMzOTVlZDQ0MzA0NGZmNThkMWIzNmI0YWFhMDhjZjYuanBnOjo6MjAxOS0wOC0wNiAxNjoxNTo0Ng=="},{"element":"5d493457578427472518dc7b:::《白蛇：缘起》：古风唯美周边:::http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/3f64169b59f348c69635e4f15bc18a0f.jpg:::2019-08-06 16:03:35","score":1,"binaryElement":"NWQ0OTM0NTc1Nzg0Mjc0NzI1MThkYzdiOjo644CK55m96JuH77ya57yY6LW344CL77ya5Y+k6aOO5ZSv576O5ZGo6L65Ojo6aHR0cDovL2JpZ2NoYW5uZWwub3NzLWNuLWhhbmd6aG91LmFsaXl1bmNzLmNvbS8yMDE5MDgvM2Y2NDE2OWI1OWYzNDhjNjk2MzVlNGYxNWJjMThhMGYuanBnOjo6MjAxOS0wOC0wNiAxNjowMzozNQ=="}]
     * type : 3
     */

    private String msg;
    private int code;
    private int type;
    private List<ListBean> list;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * element : 5d4b8f14578427472518dc8d:::国产剧《长安十二时辰》表现惊艳  谨防高开走低:::http://bigchannel.oss-cn-hangzhou.aliyuncs.com/201908/8d7e07ea54b64b4abfcd3a866ea7ba8b.jpg:::2019-08-08 10:55:16
         * score : 2
         * binaryElement : NWQ0YjhmMTQ1Nzg0Mjc0NzI1MThkYzhkOjo65Zu95Lqn5Ymn44CK6ZW/5a6J5Y2B5LqM5pe26L6w44CL6KGo546w5oOK6ImzICDosKjpmLLpq5jlvIDotbDkvY46OjpodHRwOi8vYmlnY2hhbm5lbC5vc3MtY24taGFuZ3pob3UuYWxpeXVuY3MuY29tLzIwMTkwOC84ZDdlMDdlYTU0YjY0YjRhYmZjZDNhODY2ZWE3YmE4Yi5qcGc6OjoyMDE5LTA4LTA4IDEwOjU1OjE2
         */

        private String element;
        private int score;
        private String binaryElement;

        public String getElement() {
            return element;
        }

        public void setElement(String element) {
            this.element = element;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getBinaryElement() {
            return binaryElement;
        }

        public void setBinaryElement(String binaryElement) {
            this.binaryElement = binaryElement;
        }
    }
}
