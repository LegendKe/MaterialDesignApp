package com.example.kechuanqi.collapsingtoolbarlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "SearchActivity";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(R.style.Theme_Search_WHITE);
        setContentView(R.layout.activity_search);
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
        int duration = 400;
        animation.setDuration(duration);
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
        int duration = 300;
        animation.setDuration(duration);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                recyclerView.setVisibility(View.GONE);
                SearchActivity.super.finish();
                overridePendingTransition(
                        R.anim.slide_in_right_no_alpha,
                        R.anim.slide_out_right_no_alpha);
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
