package com.example.kechuanqi.collapsingtoolbarlayout;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.kechuanqi.collapsingtoolbarlayout.utils.ColorUtils;
import com.example.kechuanqi.collapsingtoolbarlayout.view.AppPreference;
import com.example.kechuanqi.collapsingtoolbarlayout.view.ColorPickerView;
import com.example.kechuanqi.collapsingtoolbarlayout.view.ThemeEnum;


public class ThemeColorSettingActivity extends AppCompatActivity implements ColorPickerView.OnColorPickerChangeListener {
    protected AppPreference appPreference;
    private ImageView iv_toolbar;
    private ColorPickerView pickerPrimary;
//    private ColorPickerView pickerDark;

    private Toolbar toolbar;

    private int colorActionStatus = Integer.MAX_VALUE;

    private boolean mode = false; // true 为图标颜色选择 false 为状态栏颜色选择
    private ImageView iv_group_call;
    private ImageView iv_soundWave;
    private ImageView iv_fullScreen;
    private ColorPickerView pickperIconColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_setting);
        appPreference = new AppPreference(this);
        initViews();
        themeChange(null, null);
        mode = false;
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.theme_custom_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        pickerPrimary = (ColorPickerView) findViewById(R.id.theme_custom_color_primary);
        pickperIconColor = ((ColorPickerView) findViewById(R.id.theme_custom_color_icon));
        iv_toolbar = (ImageView) findViewById(R.id.theme_custom_pic_status_);
        iv_group_call = ((ImageView) findViewById(R.id.iv_group_call));
        iv_soundWave = ((ImageView) findViewById(R.id.iv_soundWave));
        iv_fullScreen = ((ImageView) findViewById(R.id.iv_fullScreen));
        pickerPrimary.setOnColorPickerChangeListener(this);
        pickperIconColor.setOnColorPickerChangeListener(this);
    }

    public void themeChange(ThemeEnum themeEnum, int[] colors) {

        final int[] ta = ColorUtils.get2ActionStatusBarColors(this);
        toolbar.setBackgroundColor(ta[1]);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ta[0]);
        }
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
                iv_toolbar.getDrawable().setTint(color);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(ColorPickerView picker) {}

    @Override
    public void onStopTrackingTouch(ColorPickerView picker) {
    }
}
