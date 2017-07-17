package com.xiaoyuan.hloli.utils;

import android.annotation.SuppressLint;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间数量的转换类
 * Created by yuan on 2017/4/27.
 */
public class TextUtils {

    public static DecimalFormat df = new DecimalFormat("0.0");
    @SuppressLint("SimpleDateFormat")
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:m:ss");

    public static String getCurrentDate(String date) {
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert d != null;
        long delta = (new Date().getTime() - d.getTime()) / 1000;
        if (delta <= 0) return date;
        if (delta / (60 * 60 * 24 * 365) > 0) return delta / (60 * 60 * 24 * 365) + "年前";
        if (delta / (60 * 60 * 24 * 30) > 0) return delta / (60 * 60 * 24 * 30) + "个月前";
        if (delta / (60 * 60 * 24 * 7) > 0) return delta / (60 * 60 * 24 * 7) + "周前";
        if (delta / (60 * 60 * 24) > 0) return delta / (60 * 60 * 24) + "天前";
        if (delta / (60 * 60) > 0) return delta / (60 * 60) + "小时前";
        if (delta / (60) > 0) return delta / (60) + "分钟前";
        return "刚刚";
    }

    public static String getCurrentWatches(String num) {
        int numInt = Integer.parseInt(num);
        if (numInt / 10000 > 1) {
            float a = (float) numInt / 10000;
            return df.format(a) + "万阅";
        } else {
            return num + "阅";
        }
    }
}
