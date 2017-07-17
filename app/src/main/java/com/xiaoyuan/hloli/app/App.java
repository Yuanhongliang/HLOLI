package com.xiaoyuan.hloli.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import com.tencent.smtt.sdk.QbSdk;
import com.xiaoyuan.hloli.constant.Constant;
import com.xiaoyuan.hloli.manager.SharedPreManager;

import java.util.Locale;

/**
 *
 * Created by yuan on 2017/4/25.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
        changeLanguage(this);
    }

    public static void changeLanguage(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        switch (SharedPreManager.getInstance().getLanguage(context)) {
            case Constant.LANGUAGE_CHINA:
                config.locale = Locale.SIMPLIFIED_CHINESE;
                break;
            case Constant.LANGUAGE_ENGLISH:
                config.locale = Locale.ENGLISH;
                break;
            case Constant.LANGUAGE_DEFAULT:
                config.locale = Locale.getDefault();
                break;
        }
        // 应用用户选择语言
        resources.updateConfiguration(config, dm);
    }
}
