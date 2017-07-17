package com.xiaoyuan.hloli.manager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by yubai on 2017/1/3.
 */

public class OkHttpManager {

    private static OkHttpClient singleton;

    public static OkHttpClient getInstance() throws IOException, ClassNotFoundException {
        if (singleton == null) {
            synchronized (OkHttpManager.class) {
                if (singleton == null) {
                    singleton = new OkHttpClient.Builder()
                            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                            .addInterceptor(new Interceptor() {
                                @Override
                                public Response intercept(Chain chain) throws IOException {

                                    Request request = chain.request();
                                    request = request.newBuilder()
                                            .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
//                                            .addHeader("Accept-Encoding", "gzip, deflate")
                                            .addHeader("Connection", "keep-alive")
                                            .addHeader("accept", "application/json")
                                            .build();
                                    return chain.proceed(request);
                                }
                            })
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .build();

                }
            }
        }
        return singleton;
    }


}
