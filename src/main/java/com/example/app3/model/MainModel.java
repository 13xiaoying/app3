package com.example.app3.model;


import com.example.app3.contract.MainContract;
import com.example.app3.utils.net.INetWorkCallBack;

public class MainModel implements MainContract.MainModel {
    public MainContract.MainPresenter presenter;

    public MainModel(MainContract.MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getMain(String url, INetWorkCallBack<T> callBack) {

    }
}
