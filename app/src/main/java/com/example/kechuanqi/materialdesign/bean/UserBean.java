package com.example.kechuanqi.materialdesign.bean;

import java.io.Serializable;

/**
 * @Description:
 * @Date: 2018/3/16
 * @Author: KeChuanqi
 * @Version:V1.0
 */

public class UserBean implements Serializable {

    private String userName = "";
    private int age = 0;

    public UserBean(String userName, int age, boolean isShow) {
        this.userName = userName;
        this.age = age;
        this.isShow = isShow;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    private boolean isShow;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
