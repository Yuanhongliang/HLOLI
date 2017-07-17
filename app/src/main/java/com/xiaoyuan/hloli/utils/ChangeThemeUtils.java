package com.xiaoyuan.hloli.utils;

import android.support.v4.widget.SwipeRefreshLayout;

import com.xiaoyuan.hloli.R;

/**
 * Created by yuan on 2017/4/28.
 */
public class ChangeThemeUtils {
    public static void changeSwipeRefreshTheme(SwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.setColorSchemeResources(R.color.blue, R.color.yellow);
    }
}
