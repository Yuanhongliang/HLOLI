package com.xiaoyuan.hloli.ui.search.model;

import com.xiaoyuan.hloli.bean.SearchResult;
import com.xiaoyuan.hloli.http.HttpMethod;
import com.xiaoyuan.hloli.ui.search.contract.SearchResultContract;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yuan on 2017/05/05
 */

public class SearchResultModelImpl implements SearchResultContract.Model {

    @Override
    public void searchArticles(String keyword, int num, int page, Subscriber<SearchResult> s) {
        HttpMethod.getInstance().searchArticles(keyword, num, page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(s);
    }
}