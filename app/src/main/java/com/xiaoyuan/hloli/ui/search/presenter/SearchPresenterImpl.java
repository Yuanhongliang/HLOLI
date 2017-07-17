package com.xiaoyuan.hloli.ui.search.presenter;

import android.content.Context;

import com.xiaoyuan.hloli.ui.search.contract.SearchContract;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by yuan on 2017/05/02
 */

public class SearchPresenterImpl extends SearchContract.Presenter {

    private List<String> data = new ArrayList<>();

    @Override
    public void queryHistory(Context context) {
        mModel.queryHistory(context, new Subscriber<List<String>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorTip(e.getLocalizedMessage());
            }

            @Override
            public void onNext(List<String> strings) {
                data.clear();
                if (strings != null) {
                    data.addAll(strings);
                    mView.getAllHistory(data);
                }
            }
        });
    }


    private void insertHistory(final Context context) {
        mModel.insertHistory(context, data, new Subscriber<Void>() {
            @Override
            public void onCompleted() {
                queryHistory(context);
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorTip(e.getLocalizedMessage());
            }

            @Override
            public void onNext(Void aVoid) {

            }
        });
    }

    @Override
    public void addHistory(Context context, String item) {
        if (data.contains(item)) return;
        data.add(0, item);
        insertHistory(context);
    }

    @Override
    public void deleteHistory(Context context, int position) {
        data.remove(position);
        insertHistory(context);
    }

    @Override
    public void clearHistory(Context context) {
        data.clear();
        insertHistory(context);
    }
}