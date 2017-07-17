package com.xiaoyuan.hloli.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaoyuan.hloli.bean.AdList;
import com.xiaoyuan.hloli.bean.BannerList;
import com.xiaoyuan.hloli.bean.Channel;
import com.xiaoyuan.hloli.bean.NewsList;

import java.util.List;

/**
 * 本地存储的
 * Created by yuan on 2017/5/2.
 */
public class SharedPreManager {

    private static SharedPreManager instance;
    private static final String SP_TAG = "Data";
    private static final String CHANNEL = "channel";
    private static final String HISTORY = "history";
    private static final String LANGUAGE = "language";
    private static final String ADLIST = "adList";
    private static final String BANNER = "banner";
    private static final String NEWS = "news";

    static Gson gson = new Gson();

    private SharedPreManager() {
    }

    public static SharedPreManager getInstance() {
        if (instance == null) {
            synchronized (SharedPreManager.class) {
                if (instance == null) {
                    instance = new SharedPreManager();
                }
            }
        }
        return instance;
    }

    /**
     * 放入频道列表
     *
     * @param context
     * @param data
     */
    public void putChannelList(Context context, List<Channel> data) {
        SharedPreferences sp = context.getSharedPreferences(SP_TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(CHANNEL, gson.toJson(data));
        editor.commit();
    }

    /**
     * 取出频道列表
     *
     * @param context
     * @return
     */
    public List<Channel> getChannelList(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_TAG, Context.MODE_PRIVATE);
        String jsonData = sp.getString(CHANNEL, "");
        return gson.fromJson(jsonData, new TypeToken<List<Channel>>() {
        }.getType());
    }


    /**
     * 存储搜索历史
     *
     * @param context
     * @param history
     */
    public void putHistory(Context context, List<String> history) {
        SharedPreferences sp = context.getSharedPreferences(SP_TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(HISTORY, gson.toJson(history));
        editor.commit();
    }

    /**
     * 获取搜索历史
     *
     * @param context
     * @return
     */
    public List<String> getHistory(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_TAG, Context.MODE_PRIVATE);
        String jsonData = sp.getString(HISTORY, "");
        return gson.fromJson(jsonData, new TypeToken<List<String>>() {
        }.getType());
    }

    /**
     * 设置语言
     *
     * @param context
     * @param language
     */
    public void setLanguage(Context context, int language) {
        SharedPreferences sp = context.getSharedPreferences(SP_TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(LANGUAGE, language);
        editor.commit();
    }

    /**
     * find language
     *
     * @param context
     * @return
     */
    public int getLanguage(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_TAG, Context.MODE_PRIVATE);
        return sp.getInt(LANGUAGE, 0);
    }

    /**
     * 把广告放入缓存
     *
     * @param context
     * @param adList
     */
    public void putAdList(Context context, AdList adList) {
        SharedPreferences sp = context.getSharedPreferences(SP_TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String json = gson.toJson(adList);
        editor.putString(ADLIST, json);
        editor.commit();
    }

    /**
     * 从缓存中获取广告
     *
     * @param context
     * @return
     */
    public AdList getAdList(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_TAG, Context.MODE_PRIVATE);
        String json = sp.getString(ADLIST, "");
        return gson.fromJson(json, AdList.class);
    }

    /**
     * 轮播图放入缓存
     *
     * @param context
     * @param bannerList
     */
    public void putBannerList(Context context, BannerList bannerList) {
        SharedPreferences sp = context.getSharedPreferences(SP_TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String json = gson.toJson(bannerList);
        editor.putString(BANNER, json);
        editor.commit();
    }

    /**
     * 获取轮播图
     *
     * @param context
     * @return
     */
    public BannerList getBannerList(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_TAG, Context.MODE_PRIVATE);
        String json = sp.getString(BANNER, "");
        return gson.fromJson(json, BannerList.class);
    }

    /**
     * 资讯放入缓存
     *
     * @param context
     * @param newsList
     */
    public void putNewsList(Context context, NewsList newsList) {
        SharedPreferences sp = context.getSharedPreferences(SP_TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String json = gson.toJson(newsList);
        editor.putString(NEWS, json);
        editor.commit();
    }

    /**
     * 缓存中获取资讯
     *
     * @param context
     * @return
     */
    public NewsList getNewsList(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_TAG, Context.MODE_PRIVATE);
        String json = sp.getString(NEWS, "");
        return gson.fromJson(json, NewsList.class);
    }


}
