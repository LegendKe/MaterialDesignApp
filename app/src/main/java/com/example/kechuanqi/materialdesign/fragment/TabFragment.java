package com.example.kechuanqi.materialdesign.fragment;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kechuanqi.materialdesign.R;
import com.example.kechuanqi.materialdesign.adapter.MainFragmentPagerAdapter;
import com.example.kechuanqi.materialdesign.base.BaseFragment;
import com.example.kechuanqi.materialdesign.utils.ColorUtils;

/**
 * @Description:
 * @Date: 2018/3/14
 * @Author: KeChuanqi
 * @Version:V1.0
 */

public class TabFragment extends BaseFragment {
    private View btn_jump2Activity;
    private View tv_content;
    private int position;
    private View iv_logo;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_tab;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initView(View view) {
        super.initView(view);
        position = getArguments().getInt("position");
        btn_jump2Activity = view.findViewById(R.id.btn_jump2Activity);
        view.findViewById(R.id.btn_jump2Activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
        tv_content = view.findViewById(R.id.tv_content);
        ((TextView) view.findViewById(R.id.tv_content)).setText(MainFragmentPagerAdapter.pagerTitles[position]);
        iv_logo = view.findViewById(R.id.iv_logo);
        if(position == 3){
            ((ImageView) iv_logo).setImageResource(R.drawable.circle_yellow);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void doClick() {
        Intent intent = new Intent(getActivity(), MainFragmentPagerAdapter.activities[position]);
        switch (position){
            case 0:
            case 1:
            case 3:
            case 4:
            case 5:
                tv_content.setTransitionName(MainFragmentPagerAdapter.pagerTitles[position]);
                iv_logo.setTransitionName(MainFragmentPagerAdapter.pagerTitles[position]+position);
                intent.putExtra("transitionName",tv_content.getTransitionName());
                Pair<View, String> pair = Pair.create(tv_content, tv_content.getTransitionName());
                Pair<View, String> logoPair = Pair.create(iv_logo, iv_logo.getTransitionName());
                getActivity().startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity(),pair,logoPair).toBundle());
                break;
            case 2://SearchActivity
                getActivity().startActivity(intent);
                break;
        }
    }

    @Override
    public void themeChange() {
        final int[] ta = ColorUtils.get2ActionStatusBarColors(mContext);
        btn_jump2Activity.setBackgroundColor(ta[0]);
    }
}
