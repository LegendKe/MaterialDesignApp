package com.example.kechuanqi.materialdesign.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.kechuanqi.materialdesign.interfaces.ThemeChangeable;
import com.example.kechuanqi.materialdesign.utils.ColorUtils;
import com.example.kechuanqi.materialdesign.view.AppPreference;


/**
 * @Description: 基础Activity类，所有的Activity需要继承该类，包含一些抽象公有方法，和Activity共用的方法
 * @Date: 2017/4/24
 * @Author: ShaFei
 * @Version: V1.0
 */
public abstract class BaseActivity extends AppCompatActivity implements ThemeChangeable{

    protected Context mContext;
    protected AppPreference appPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        appPreference = AppPreference.getInstance(this);
        appPreference.bindOnThemeChanged(this);
        setContentView(setLayoutId());

        initView();

        initData();

        initEvent();
    }

    /**
     * 初始化控件
     */
    protected void initView() {
    }

    protected void initData() {
        themeChange();
    }

    protected void initEvent() {
    }

    /**
     * 设置布局id
     * @return
     */
    protected abstract int setLayoutId();

    @Override
    public void themeChange() {
        final int[] ta = ColorUtils.get2ActionStatusBarColors(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ta[0]);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appPreference.unbindOnThemeChanged(this);
    }
}
