package com.example.kechuanqi.materialdesign.bean;

import android.support.annotation.ColorRes;

import java.io.Serializable;

/**
 * @Description:
 * @Date: 2018/3/16
 * @Author: KeChuanqi
 * @Version:V1.0
 */

public class ThemeColor implements Serializable {

    private int color;
    private final String name;

    public ThemeColor(@ColorRes int color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }
}
