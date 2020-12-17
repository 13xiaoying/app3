package com.example.app3.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseMainActivity<T extends > extends AppCompatActivity {
    public T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        if(){

        }
    }
    public abstract void initView();
    public abstract void initDate();
    public abstract void getIcount();
    public abstract void initView();
}
