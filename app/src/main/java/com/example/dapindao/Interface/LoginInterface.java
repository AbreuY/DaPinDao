package com.example.dapindao.Interface;

public interface LoginInterface {
    //view
    interface View{
        void succeed();
        void failed();
    }
    //presenter
    interface Presenter{
        void login(String mobile, String code);
        void sendMobileCode(String code);
    }
}
