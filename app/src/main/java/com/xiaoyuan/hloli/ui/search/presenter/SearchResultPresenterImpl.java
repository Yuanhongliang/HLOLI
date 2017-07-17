package com.xiaoyuan.hloli.ui.search.presenter;

import android.util.Log;

import com.xiaoyuan.hloli.bean.SearchResult;
import com.xiaoyuan.hloli.ui.search.contract.SearchResultContract;

import rx.Subscriber;

/**
 * Created by yuan on 2017/05/05
 */

public class SearchResultPresenterImpl extends SearchResultContract.Presenter {

    public final int num = 10;
    private int page = 0;
    private boolean hasMoreData = true;

    @Override
    public void searchArticles(String keyword, final boolean refresh) {
        mModel.searchArticles(keyword, num, page, new Subscriber<SearchResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SearchResult searchResult) {
                if (!hasMoreData) {
                    mView.noMoreData();
                    return;
                }
                if (refresh) {
                    page = 0;
                } else if (!searchResult.isIs_end()) {
                    page++;
                } else {
                    hasMoreData = false;
                }
                mView.onArticlesGet(searchResult.getList(), refresh);
            }
        });
    }
}