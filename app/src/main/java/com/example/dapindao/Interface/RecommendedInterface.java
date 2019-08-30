package com.example.dapindao.Interface;

public interface RecommendedInterface {
    //view
    interface View{
        void succeed();
        void failed();
    }
    //presenter
    interface Presenter{
        void recFront(int type);
    }
}
