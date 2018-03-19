package com.example.kechuanqi.materialdesign.activity;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.kechuanqi.materialdesign.R;
import com.example.kechuanqi.materialdesign.base.BaseActivity;

public class SearchActivity extends BaseActivity{

    private static final String TAG = "SearchActivity";
    private RecyclerView recyclerView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        super.initView();
        recyclerView = ((RecyclerView) findViewById(R.id.recyclerView));
    }

    /**
     * 进场动画结束后走这个方法
     */
    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        Log.e(TAG,"onEnterAnimationComplete()");
        showResultContainer();
    }

    /**
     * 内容从底部往上出来显示
     */
    private void showResultContainer() {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                recyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                isResultContainerShowing = true;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        recyclerView.startAnimation(animation);

    }

    /**
     * 隐藏内容
     */
    private void hideResultContainerThenFinish() {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                recyclerView.setVisibility(View.GONE);
                overridePendingTransition(
                        R.anim.slide_in_right_no_alpha,
                        R.anim.slide_out_right_no_alpha);
                SearchActivity.super.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        recyclerView.startAnimation(animation);
    }


    @Override
    public void finish() {
        hideResultContainerThenFinish();
    }
}
