package com.example.app3.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app3.MainMadapter;
import com.example.app3.R;
import com.example.app3.base.BaseMainActivity;
import com.example.app3.bean.ProBean;
import com.example.app3.contract.MainContract;
import com.example.app3.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseMainActivity<MainPresenter> implements MainContract.MainView {

    private RecyclerView mRvView;
    private ArrayList<ProBean.DataBean.DatasBean> list;
    private MainMadapter madapter;

    @Override
    public void initView() {
        mRvView = (RecyclerView) findViewById(R.id.rv_view);
        list = new ArrayList<>();
        madapter = new MainMadapter(this, list);
        mRvView.setAdapter(madapter);
        mRvView.setLayoutManager(new LinearLayoutManager(this));
        mRvView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    @Override
    public void initDate() {
        presenter.fun();
    }

    @Override
    public int getIcount() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenter getInterface() {
        return new MainPresenter(this);
    }



    @Override
    public void onInit(ProBean proBean) {
        List<ProBean.DataBean.DatasBean> datas = proBean.getData().getDatas();
        list.addAll(datas);
        madapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String string) {
        Log.i(TAG, "onError: 错误信息"+string);
    };
    private static final String TAG = "MainActivity";
}
