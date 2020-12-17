package com.example.app3.utils.net;

public interface INetWorkCallBack<T> {
    void onInit(T a);
    void onError(String error);
}
