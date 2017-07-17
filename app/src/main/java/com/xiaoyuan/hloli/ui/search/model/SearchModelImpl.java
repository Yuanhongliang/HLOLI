package com.xiaoyuan.hloli.ui.search.model;

import android.content.Context;

import com.xiaoyuan.hloli.manager.SharedPreManager;
import com.xiaoyuan.hloli.ui.search.contract.SearchContract;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yuan on 2017/05/02
 */

public class SearchModelImpl implements SearchContract.Model {

    @Override
    public void queryHistory(final Context context, Subscriber<List<String>> s) {
        Observable<List<String>> observable = Observable.create(new Observable.OnSubscribe<List<String>>() {
            @Override
            public void call(Subscriber<? super List<String>> subscriber) {
                List<String> list = SharedPreManager.getInstance().getHistory(context);
                subscriber.onNext(list);
                subscriber.onCompleted();
            }
        });
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(s);
    }

    @Override
    public void insertHistory(final Context context, final List<String> data, Subscriber<Void> s) {
        Observable<Void> observable = Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                SharedPreManager.getInstance().putHistory(context, data);
                subscriber.onCompleted();
            }
        });
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(s);
    }
}