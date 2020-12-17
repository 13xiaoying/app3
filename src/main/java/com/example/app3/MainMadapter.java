package com.example.app3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app3.bean.ProBean;

import java.util.ArrayList;

public class MainMadapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ProBean.DataBean.DatasBean> list;

    public MainMadapter(Context context, ArrayList<ProBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_bady, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProBean.DataBean.DatasBean datasBean = list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.text_bady.setText(datasBean.getDesc());
        Glide.with(context).load(datasBean.getEnvelopePic()).into(viewHolder.img_bady);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_bady;
        TextView text_bady;
        public ViewHolder(View inflate) {
            super(inflate);
            img_bady=inflate.findViewById(R.id.iv_bady);
            text_bady=inflate.findViewById(R.id.tv_bady);
        }
    }
}
