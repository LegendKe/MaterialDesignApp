package com.example.kechuanqi.materialdesign.bean;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

import com.example.kechuanqi.materialdesign.R;

import java.io.Serializable;

/**
 * @Description:
 * @Date: 2018/3/16
 * @Author: KeChuanqi
 * @Version:V1.0
 */

public class MyHandler implements Serializable {
    public void showToast(View view) {
        Toast.makeText(view.getContext(), "展示吐司", Toast.LENGTH_SHORT).show();
    }



    public void onEventListenerExecute(MyTask task) {
        task.run();
    }
}
