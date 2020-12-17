package com.example.app3.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app3.MainMadapter;
import com.example.app3.R;
import com.example.app3.bean.ProBean;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRvView;
    private ArrayList<ProBean.DataBean.DatasBean> list;
    private MainMadapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRvView = (RecyclerView) findViewById(R.id.rv_view);
        list = new ArrayList<>();
        madapter = new MainMadapter(this, list);
        mRvView.setAdapter(madapter);
        mRvView.setLayoutManager(new LinearLayoutManager(this));
        mRvView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }
}
