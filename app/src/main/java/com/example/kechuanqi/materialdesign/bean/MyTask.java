package com.example.kechuanqi.materialdesign.bean;

import android.content.Context;
import android.widget.Toast;

/**
 * @Description:
 * @Date: 2018/3/16
 * @Author: KeChuanqi
 * @Version:V1.0
 */

public class MyTask implements Runnable {

    private Context mContext;

    public MyTask(Context context) {
        mContext = context;
    }

    @Override
    public void run() {
        Toast.makeText(mContext, "执行任务", Toast.LENGTH_SHORT).show();
    }
}