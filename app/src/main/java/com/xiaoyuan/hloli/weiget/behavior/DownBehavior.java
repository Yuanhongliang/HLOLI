package com.xiaoyuan.hloli.weiget.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * 底部向下的behavior
 * Created by yuan on 2017/4/26.
 */
public class DownBehavior extends CoordinatorLayout.Behavior<View> {
    public DownBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        child.setTranslationY(-dependency.getY());
        return true;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }
}
