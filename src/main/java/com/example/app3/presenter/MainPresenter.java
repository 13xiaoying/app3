package com.example.app3.presenter;


import com.example.app3.base.BasePresenter;
import com.example.app3.bean.ProBean;
import com.example.app3.contract.MainContract;
import com.example.app3.model.MainModel;
import com.example.app3.utils.net.INetWorkCallBack;
import com.example.app3.utils.net.URLContstant;

import java.util.List;

public class MainPresenter extends BasePresenter<MainContract.MainView> implements MainContract.MainPresenter {
    public final MainModel mainModel;

    public MainPresenter(MainContract.MainView mainView) {
        this.mainModel = new MainModel(this);
    }

    @Override
    public void fun() {
        mainModel.getMain(URLContstant.url, new INetWorkCallBack<ProBean>() {
            @Override
            public void onInit(ProBean a) {
                //List<ProBean.DataBean.DatasBean> results = a.getData().getDatas();
                iView.onInit(a);
            }

            @Override
            public void onError(String error) {
                iView.onError(error);
            }
        });
    }
}
