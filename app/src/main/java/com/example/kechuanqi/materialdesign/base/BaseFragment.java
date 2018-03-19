package com.example.kechuanqi.materialdesign.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kechuanqi.materialdesign.interfaces.ThemeChangeable;
import com.example.kechuanqi.materialdesign.view.AppPreference;

/**
 * @Description:
 * @Date: 2017/5/9
 * @Author: KeChuanqi
 * @Version:V1.0
 */

public abstract class BaseFragment extends Fragment implements ThemeChangeable{

    public Context mContext;
    private AppPreference appPreference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutId(),null);
        mContext = getActivity();
        appPreference = AppPreference.getInstance(mContext);
        appPreference.bindOnThemeChanged(this);
        initView(view);
        initData();
        initEvent();
        return view;
    }

    /**
     * 设置事件
     */
    protected void initEvent() {

    }

    /**
     * 初始化数据
     */
    protected void initData() {
        themeChange();
    }

    /**
     * 初始化view
     * @param view
     */
    protected void initView(View view) {
    }

    /**
     * 设置布局id
     * @return
     */
    protected abstract int setLayoutId();

    @Override
    public void themeChange() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appPreference.unbindOnThemeChanged(this);
    }
}
