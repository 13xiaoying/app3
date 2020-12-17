package com.example.app3.utils.net;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUrils implements INetWorkInterface {
    public static RetrofitUrils retrofitUrils;
    public final ApiServer apiServer;

    public RetrofitUrils() {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(URLContstant.baseurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiServer = build.create(ApiServer.class);
    }
    public static RetrofitUrils getInstance(){
        if(retrofitUrils==null){
            synchronized (RetrofitUrils.class){
                if(retrofitUrils==null){
                    retrofitUrils=new RetrofitUrils();
                }
            }
        }
        return retrofitUrils;
    }

    @Override
    public <T> void get(String url, final INetWorkCallBack<T> callBack) {
        apiServer.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = actualTypeArguments[0];
                            Gson gson = new Gson();
                            T o = gson.fromJson(string, type);
                            callBack.onInit(o);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
