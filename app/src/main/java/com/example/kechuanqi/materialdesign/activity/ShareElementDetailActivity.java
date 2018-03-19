package com.example.kechuanqi.materialdesign.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;

import com.example.kechuanqi.materialdesign.R;
import com.example.kechuanqi.materialdesign.base.BaseActivity;

public class ShareElementDetailActivity extends BaseActivity {

    private ImageView imageView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_share_element_detail;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initView() {
        super.initView();
        int uri = getIntent().getIntExtra("uri", R.mipmap.img01);
        String transitionName = getIntent().getStringExtra("transitionName");
        imageView = ((ImageView) findViewById(R.id.imageView));
        imageView.setTransitionName(transitionName);
        imageView.setImageResource(uri);
    }

}
