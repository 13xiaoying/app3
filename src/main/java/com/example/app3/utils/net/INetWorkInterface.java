package com.example.app3.utils.net;

public interface INetWorkInterface {
    public <T> void get(String url, INetWorkCallBack<T> callBack);
}
