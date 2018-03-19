package com.example.kechuanqi.materialdesign.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;

import com.example.kechuanqi.materialdesign.R;
import com.example.kechuanqi.materialdesign.base.BaseActivity;
import com.example.kechuanqi.materialdesign.utils.ColorUtils;
import com.example.kechuanqi.materialdesign.view.ColorPickerView;


public class ThemeColorSettingActivity extends BaseActivity implements ColorPickerView.OnColorPickerChangeListener {
    private ImageView iv_toolbar;
    private ColorPickerView pickerPrimary;
    private ImageView iv_group_call;
    private ImageView iv_soundWave;
    private ImageView iv_fullScreen;
    private ColorPickerView pickerIconColor;
    //状态栏颜色
    private int statusBarColor;
    private View rl_actionBar;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_theme_setting;
    }

    @Override
    protected void initView() {

        pickerPrimary = (ColorPickerView) findViewById(R.id.theme_custom_color_primary);
        pickerIconColor = ((ColorPickerView) findViewById(R.id.theme_custom_color_icon));
        iv_toolbar = (ImageView) findViewById(R.id.theme_custom_pic_status_);
        iv_group_call = ((ImageView) findViewById(R.id.iv_group_call));
        iv_soundWave = ((ImageView) findViewById(R.id.iv_soundWave));
        iv_fullScreen = ((ImageView) findViewById(R.id.iv_fullScreen));
        pickerPrimary.setOnColorPickerChangeListener(this);
        pickerIconColor.setOnColorPickerChangeListener(this);
        findViewById(R.id.tv_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //主题颜色保存
                appPreference.updateStatusBarColor(statusBarColor);
            }
        });
        rl_actionBar = findViewById(R.id.rl_actionBar);
    }

    @Override
    public void themeChange() {
        super.themeChange();
        final int[] ta = ColorUtils.get2ActionStatusBarColors(this);
        statusBarColor = ta[0];
        rl_actionBar.setBackgroundColor(statusBarColor);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onColorChanged(ColorPickerView picker, int color) {
        switch (picker.getId()){
            case R.id.theme_custom_color_icon://图标颜色
                iv_group_call.getDrawable().setTint(color);
                iv_soundWave.getDrawable().setTint(color);
                iv_fullScreen.getDrawable().setTint(color);
                break;
            case R.id.theme_custom_color_primary://状态栏颜色
                statusBarColor = color;
                iv_toolbar.getDrawable().setTint(color);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(ColorPickerView picker) {}

    @Override
    public void onStopTrackingTouch(ColorPickerView picker) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
