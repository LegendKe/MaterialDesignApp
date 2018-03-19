package com.example.kechuanqi.materialdesign.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kechuanqi.materialdesign.activity.PathAnimActivity;
import com.example.kechuanqi.materialdesign.activity.RefreshAnimActivity;
import com.example.kechuanqi.materialdesign.activity.RevealAnimActivity;
import com.example.kechuanqi.materialdesign.activity.SearchActivity;
import com.example.kechuanqi.materialdesign.activity.ShareElementActivity;

import java.util.List;

/**
 * @Description:
 * @Date: 2017/5/9
 * @Author: KeChuanqi
 * @Version:V1.0
 */

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    //fragments列表
    private List<Fragment> fragments;
    //tab名
    public static String[] pagerTitles = {"ShareElement","Path","Search","Reveal","Refresh"};

    public static Class[] activities = {ShareElementActivity.class, PathAnimActivity.class, SearchActivity.class, RevealAnimActivity.class,
                                       RefreshAnimActivity.class};

    public MainFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return pagerTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pagerTitles[position];
    }
}
