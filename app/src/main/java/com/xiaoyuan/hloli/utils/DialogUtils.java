package com.xiaoyuan.hloli.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.view.View;

import com.xiaoyuan.hloli.R;

/**
 * 显示dialog工具类
 * Created by yuan on 2017/5/5.
 */
public class DialogUtils {

    /**
     * @param context
     * @param titleResId
     * @param messageResId
     * @param cancelable
     * @param yesOnClick
     * @param noOnClick
     */
    public static void showDialog(Context context, int titleResId, int messageResId, boolean cancelable, DialogInterface.OnClickListener yesOnClick, DialogInterface.OnClickListener noOnClick) {
        AlertDialog dialog = new AlertDialog.Builder(context).setTitle(titleResId).setMessage(messageResId).setCancelable(cancelable).setPositiveButton(R.string.yes, yesOnClick).setNegativeButton(R.string.no, noOnClick).create();
        dialog.show();
    }

    /**
     * 自定义View
     *
     * @param context
     * @param titleResId
     * @param v
     * @param cancelable
     */
    public static void showDialog(Context context, int titleResId, View v, boolean cancelable) {
        AlertDialog dialog = new AlertDialog.Builder(context).setTitle(titleResId).setView(v).setCancelable(cancelable).setPositiveButton(R.string.yes, null).create();
        dialog.show();
    }

    public static void showMultiItemsDialog(Context context, int titleResId, int arrayId, DialogInterface.OnClickListener choiceOnClickListener) {
        AlertDialog dialog =
                new AlertDialog.Builder(context).setTitle(titleResId).setSingleChoiceItems(arrayId, -1, choiceOnClickListener).setCancelable(true).create();
        dialog.show();
    }


}
