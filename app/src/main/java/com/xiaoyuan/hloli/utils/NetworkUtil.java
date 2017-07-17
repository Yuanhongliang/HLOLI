package com.xiaoyuan.hloli.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static android.net.ConnectivityManager.*;

/**
 * 判断网络是否可用
 * Created by yuan on 2017/5/16.
 */
public class NetworkUtil {


    public static boolean isNetAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable();
    }

    public static boolean isWifiAvaliable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressWarnings("deprecation") NetworkInfo wifiWorkInfo = manager.getNetworkInfo(TYPE_WIFI);
        return wifiWorkInfo != null && wifiWorkInfo.isAvailable();
    }

}
