package com.example.kechuanqi.materialdesign.activity;

import android.animation.Animator;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kechuanqi.materialdesign.R;
import com.example.kechuanqi.materialdesign.base.BaseActivity;
import com.example.kechuanqi.materialdesign.bean.MyHandler;
import com.example.kechuanqi.materialdesign.bean.ThemeColor;
import com.example.kechuanqi.materialdesign.bean.UserBean;
import com.example.kechuanqi.materialdesign.databinding.ActivityRevealAnimBinding;

public class RevealAnimActivity extends BaseActivity implements View.OnTouchListener {


    private ViewGroup container;
    private View btnRed;
    private TextView tv_content;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_reveal_anim;
    }

    @Override
    protected void initView() {
        super.initView();
        ActivityRevealAnimBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_reveal_anim);

        viewDataBinding.setUser(new UserBean("Reveal",27,true));

        // 绑定方法和监听
        viewDataBinding.setHandler(new MyHandler());

        viewDataBinding.setThemeColor(new ThemeColor(R.color.colorAccent,"title"));

        View btnAccent = findViewById(R.id.square_accent);
        findViewById(R.id.square_blue).setOnTouchListener(this);
        container = (ViewGroup)findViewById(R.id.container);
        btnAccent.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                revealAccent();
            }
        });
        btnRed = findViewById(R.id.square_red);
        btnRed.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                revealRed();
            }
        });
        tv_content = ((TextView) findViewById(R.id.tv_content));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void revealBlue(float x, float y) {
        animateRevealColorFromCoordinates(container, R.color.colorBlue, (int) x, (int) y);
        tv_content.setText(R.string.reveal_body1);
        tv_content.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        revealAccent();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void revealAccent() {
        animateRevealColor(container, R.color.colorAccent);
        tv_content.setText(R.string.reveal_body2);
        tv_content.setTextColor(ContextCompat.getColor(this,android.R.color.black));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void animateRevealColor(ViewGroup viewRoot, @ColorRes int color) {
        int cx = (viewRoot.getLeft() + viewRoot.getRight()) / 2;
        int cy = (viewRoot.getTop() + viewRoot.getBottom()) / 2;
        animateRevealColorFromCoordinates(viewRoot, color, cx, cy);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private Animator animateRevealColorFromCoordinates(ViewGroup viewRoot, @ColorRes int color, int x, int y) {
        float finalRadius = (float) Math.hypot(viewRoot.getWidth(), viewRoot.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(viewRoot, x, y, 0, finalRadius);
        viewRoot.setBackgroundColor(ContextCompat.getColor(this, color));
        anim.setDuration(500);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
        return anim;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void revealRed() {
        final ViewGroup.LayoutParams originalParams = btnRed.getLayoutParams();
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.changebounds_with_arcmotion);
        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTransitionEnd(Transition transition) {
                animateRevealColor(container, R.color.colorPurple);
                tv_content.setText(R.string.reveal_body3);
                tv_content.setTextColor(ContextCompat.getColor(RevealAnimActivity.this, android.R.color.black));
                btnRed.setLayoutParams(originalParams);
            }

            @Override
            public void onTransitionCancel(Transition transition) {
            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });
        TransitionManager.beginDelayedTransition(container, transition);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        btnRed.setLayoutParams(layoutParams);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            if (v.getId() == R.id.square_blue) {
                revealBlue(motionEvent.getRawX(), motionEvent.getRawY());
            }
        }
        return false;
    }
}
