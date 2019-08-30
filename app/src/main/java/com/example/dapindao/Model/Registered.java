package com.example.dapindao.Model;

public class Registered {
    //注册返回信息实体类
    private int code; //返回的code 1成功
    private String msg;//返回的具体信息
    private int userId;//返回的userid
    private String token;//返回token
    private String deviceType;//设备类型：1-电脑，2-手机

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
