package com.example.kechuanqi.materialdesign.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.kechuanqi.materialdesign.R;
import com.example.kechuanqi.materialdesign.base.BaseActivity;
import com.example.kechuanqi.materialdesign.view.PathAnimView;

public class PathAnimActivity extends BaseActivity implements View.OnClickListener {

    private PathAnimView pathAnimView;
    private ImageView iv_light;
    private ImageView mImageView;
    private boolean mIsChecked = false;
    private ImageView iv_animatorSelector;
    private static final int[] STATE_CHECKED = new int[]{android.R.attr.state_checked};
    private static final int[] STATE_UNCHECKED = new int[]{};
    private boolean flag;
    private ImageView iv_numberChange;
    private int mCurrentNum = 0;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_path_anim;
    }

    @Override
    protected void initView() {
        super.initView();

        iv_light = ((ImageView) findViewById(R.id.iv_light));
        iv_light.setOnClickListener(this);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mImageView.setOnClickListener(this);
        iv_animatorSelector = ((ImageView) findViewById(R.id.iv_animatorSelector));
        iv_animatorSelector.setOnClickListener(this);
        iv_numberChange = ((ImageView) findViewById(R.id.iv_numberChange));
        iv_numberChange.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.iv_light:
                iv_light.setImageState(new int[]{R.attr.state_on},true);
                break;
            case R.id.imageView:
                mIsChecked = !mIsChecked;
                final int[] stateSet = {android.R.attr.state_checked * (mIsChecked ? 1 : -1)};
                mImageView.setImageState(stateSet, true);
                break;
            case R.id.iv_animatorSelector:
                if (flag) {
                    iv_animatorSelector.setImageState(STATE_UNCHECKED, true);
                    flag = false;
                } else {
                    iv_animatorSelector.setImageState(STATE_CHECKED, true);
                    flag = true;
                }
                break;
            case R.id.iv_numberChange:
                Log.e("TAG","iv_numberChange onClick()");
                mCurrentNum++;
                if (mCurrentNum > 9) {
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
//                iv_numberChange.setImageState(state, true);
                iv_numberChange.setImageState(new int[]{-DIGIT_STATES[0],DIGIT_STATES[1]}, true);
                break;
        }
    }
    private static final int[] DIGIT_STATES = {
            R.attr.state_zero,
            R.attr.state_one,
    };
}
