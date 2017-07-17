package com.xiaoyuan.hloli.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xiaoyuan.hloli.manager.OkHttpManager;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yuan on 2017/4/25.
 */
public class RetrofitBuilder {
    public static Retrofit getRetrofit(String url) {
        Retrofit builder = null;
        try {
            builder = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(url)
                    .client(OkHttpManager.getInstance())
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return builder;
    }
}
