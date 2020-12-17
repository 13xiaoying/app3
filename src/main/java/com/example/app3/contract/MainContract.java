package com.example.app3.contract;

import com.example.app3.bean.ProBean;

public class MainContract {
    public interface MainModel{
        <T> void getMain(String url,MainCallBack<T> callBack);
    }
    public interface MainPresenter{
        void fun();
    }
    public interface MainView{
        void onInit(ProBean proBean);
        void onError(String string);
    }
}
