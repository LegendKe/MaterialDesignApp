package com.example.kechuanqi.materialdesign.activity;

import android.animation.ValueAnimator;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.view.View;
import android.widget.ImageView;

import com.example.kechuanqi.materialdesign.R;
import com.example.kechuanqi.materialdesign.base.BaseActivity;

public class PathAnimActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_plusMinus;
    private boolean mIsChecked = false;
    private ImageView iv_numberChange;
    private int mCurrentNum = 0;
    private ImageView iv_back;
    private DrawerArrowDrawable drawerArrowDrawable;
    private ImageView iv_record;
    private boolean isChecked;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_path_anim;
    }

    @Override
    protected void initView() {
        super.initView();

        iv_plusMinus = (ImageView) findViewById(R.id.iv_plus_minus);
        iv_plusMinus.setOnClickListener(this);
        iv_numberChange = ((ImageView) findViewById(R.id.iv_numberChange));
        iv_numberChange.setOnClickListener(this);
        iv_back = ((ImageView) findViewById(R.id.iv_back));
        drawerArrowDrawable = new DrawerArrowDrawable(this);
        drawerArrowDrawable.setColor(getResources().getColor(R.color.colorAccent));
        iv_back.setImageDrawable(drawerArrowDrawable);
        iv_back.setOnClickListener(this);
        iv_record = ((ImageView) findViewById(R.id.iv_record));
        iv_record.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.iv_plus_minus://+-切换
                mIsChecked = !mIsChecked;
                final int[] stateSet = {android.R.attr.state_checked * (mIsChecked ? 1 : -1)};
                iv_plusMinus.setImageState(stateSet, true);
                break;
            case R.id.iv_numberChange://数字切换
                mCurrentNum++;
                if (mCurrentNum > 1) {
                    mCurrentNum = 0;
                }
                int[] state = new int[DIGIT_STATES.length];
                for (int i = 0 ; i < DIGIT_STATES.length; i++) {
                    if (i == mCurrentNum) {
                        state[i] = DIGIT_STATES[i];
                    } else {
                        state[i] = -DIGIT_STATES[i];
                    }
                }
                iv_numberChange.setImageState(state, true);
                break;
            case R.id.iv_back://返回 原生
                mIsChecked = !mIsChecked;
                drawerArrowChange(mIsChecked);
                break;
            case R.id.iv_record://录像
                isChecked = !isChecked;
                final int[] stateSet2 = {android.R.attr.state_checked * (isChecked ? 1 : -1)};
                iv_record.setImageState(stateSet2,true);
                break;
        }
    }

    private void drawerArrowChange(boolean isChecked) {
        ValueAnimator animator;
        if(isChecked){
            animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        }else {
            animator = ValueAnimator.ofFloat(1.0f, 0.0f);
        }
        animator.setDuration(400);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator arg0) {
                float animatedValue = (float) arg0.getAnimatedValue();
                drawerArrowDrawable.setProgress(animatedValue);
            }
        });
        animator.start();
    }

    private static final int[] DIGIT_STATES = {
            R.attr.state_zero,
            R.attr.state_one,
    };
}
