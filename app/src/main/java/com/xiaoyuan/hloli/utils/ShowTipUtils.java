package com.xiaoyuan.hloli.utils;

import android.content.Context;
import android.widget.Toast;

import com.xiaoyuan.hloli.R;

/**
 * Created by yuan on 2017/4/28.
 */
public class ShowTipUtils {
    public static void showTip(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showTip(Context context, int message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showNetError(Context context) {
        Toast.makeText(context, R.string.net_error, Toast.LENGTH_SHORT).show();
    }
}
