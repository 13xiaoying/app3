package com.example.app3.contract;

import com.example.app3.base.BaseView;
import com.example.app3.bean.ProBean;
import com.example.app3.utils.net.INetWorkCallBack;

public class MainContract {
    public interface MainModel{
        <T> void getMain(String url, INetWorkCallBack<T> callBack);
    }
    public interface MainPresenter{
        void fun();
    }
    public interface MainView extends BaseView {
        void onInit(ProBean proBean);
        void onError(String string);
    }
}
