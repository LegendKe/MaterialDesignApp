package com.example.kechuanqi.materialdesign.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import com.example.kechuanqi.materialdesign.R;
import com.example.kechuanqi.materialdesign.base.BaseActivity;
import com.example.kechuanqi.materialdesign.utils.ColorUtils;

public class ShareElementActivity extends BaseActivity implements View.OnClickListener {

    private int[] imgRes = {R.mipmap.img01,R.mipmap.img02,R.mipmap.img03,R.mipmap.img04};
    private TextView tv_title;
    private View rl_actionBar;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_share_element;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initView() {
        super.initView();
        findViewById(R.id.iv_01).setOnClickListener(this);
        findViewById(R.id.iv_02).setOnClickListener(this);
        findViewById(R.id.iv_03).setOnClickListener(this);
        findViewById(R.id.iv_04).setOnClickListener(this);
        tv_title = ((TextView) findViewById(R.id.tv_title));
        rl_actionBar = findViewById(R.id.rl_actionBar);
        String transitionName = getIntent().getStringExtra("transitionName");
        tv_title.setTransitionName(transitionName);
        tv_title.setText(transitionName);
    }

    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ShareElementActivity.this, ShareElementDetailActivity.class);
        int pos = 0;
        switch (v.getId()) {
            case R.id.iv_01:
                pos = 0;
                break;
            case R.id.iv_02:
                pos = 1;
                break;
            case R.id.iv_03:
                pos = 2;
                break;
            case R.id.iv_04:
                pos = 3;
                break;
        }
        intent.putExtra("uri",imgRes[pos]);
        intent.putExtra("transitionName",v.getTransitionName());
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(ShareElementActivity.this, Pair.create(v, v.getTransitionName())).toBundle());
    }

    @Override
    public void themeChange() {
        super.themeChange();
        final int[] ta = ColorUtils.get2ActionStatusBarColors(this);
        rl_actionBar.setBackgroundColor(ta[0]);
    }
}
