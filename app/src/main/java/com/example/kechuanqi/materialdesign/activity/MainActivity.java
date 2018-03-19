package com.example.kechuanqi.materialdesign.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.kechuanqi.materialdesign.R;
import com.example.kechuanqi.materialdesign.adapter.MainFragmentPagerAdapter;
import com.example.kechuanqi.materialdesign.base.BaseActivity;
import com.example.kechuanqi.materialdesign.fragment.TabFragment;
import com.example.kechuanqi.materialdesign.utils.ColorUtils;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        tabLayout = ((TabLayout) findViewById(R.id.tabLayout));
        viewPager = ((ViewPager) findViewById(R.id.viewPager));
        initFragments();
        MainFragmentPagerAdapter fragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * 初始化fragment
     */
    private void initFragments() {
        fragments = new ArrayList<>();
        TabFragment tabFragment;
        for (int i = 0; i < 8; i++) {
            tabFragment = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position",i);
            tabFragment.setArguments(bundle);
            fragments.add(tabFragment);
        }
    }

    @Override
    public void themeChange() {
        super.themeChange();
        final int[] ta = ColorUtils.get2ActionStatusBarColors(this);
        tabLayout.setBackgroundColor(ta[0]);
    }
}
