package com.example.kechuanqi.materialdesign.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * @Description:
 * @Date: 2018/2/9
 * @Author: KeChuanqi
 * @Version:V1.0
 */

public class BehaviorAdapter extends RecyclerView.Adapter {


    private List<String> list;

    public BehaviorAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String str = list.get(position);
        MyViewHolder hd = (MyViewHolder) holder;
        hd.text1.setText(str);
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView text1;

        public MyViewHolder(View itemView) {
            super(itemView);
            text1 = (TextView) itemView.findViewById(android.R.id.text1);
        }

    }

}