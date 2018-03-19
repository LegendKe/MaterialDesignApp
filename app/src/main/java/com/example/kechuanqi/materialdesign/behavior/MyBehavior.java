package com.example.kechuanqi.materialdesign.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @Description:
 * @Date: 2018/2/9
 * @Author: KeChuanqi
 * @Version:V1.0
 */

public class MyBehavior extends CoordinatorLayout.Behavior<View>{

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.e("TAG","----1----MyBehavior()-");
    }
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        Log.e("TAG","----2----layoutDependsOn()-");
        return super.layoutDependsOn(parent, child, dependency);
    }
    /**
     * 当recyclerview滑动时，回调该方法
     * @param coordinatorLayout
     * @param child
     * @param directTargetChild
     * @param target
     * @param nestedScrollAxes
     * @return
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child,
                                       View directTargetChild, View target, int nestedScrollAxes) {
        Log.e("TAG","--------onStartNestedScroll()-");
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;//垂直方向滑动
    }
    /**
     * 当recyclerview滑动的过程中进行回调，floatactionbar怎么回应
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param dxConsumed
     * @param dyConsumed
     * @param dxUnconsumed
     * @param dyUnconsumed
     */
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout,
                               View child, View target,
                               int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.e("TAG","--------onNestedScroll()-");
        if (dyConsumed > 0 && dyUnconsumed == 0) {
            Log.d("TAG", "上滑中。。。");
        }
        if (dyConsumed == 0 && dyUnconsumed > 0) {
            Log.d("TAG", "到边界了还在上滑。。。");
        }
        if (dyConsumed < 0 && dyUnconsumed == 0) {
            Log.d("TAG", "下滑中。。。");
        }
        if (dyConsumed == 0 && dyUnconsumed < 0) {
            Log.d("TAG", "到边界了，还在下滑。。。");
        }
        if(dyConsumed > 0){//列表往下滑，手指上滑
            animOut(child);
        }else {//往上滑
            animIn(child);
        }
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }
    private void animIn(View child) {
        Log.e("TAG","--------animIn()-");
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(child);
        animate.translationY(0).start();
    }
    private void animOut(View child) {
        Log.e("TAG","--------animOut()-");
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(child);
        animate.translationY(-child.getHeight()).start();
    }

}
