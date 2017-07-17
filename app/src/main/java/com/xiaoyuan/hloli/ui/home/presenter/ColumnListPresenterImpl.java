package com.xiaoyuan.hloli.ui.home.presenter;

import com.xiaoyuan.hloli.bean.NewsList;
import com.xiaoyuan.hloli.ui.home.contract.ColumnListContract;

import rx.functions.Action1;

/**
 * Created by yuan on 2017/05/10
 */

public class ColumnListPresenterImpl extends ColumnListContract.Presenter {

    private int pageNum = 0;

    @Override
    public void getNewsData(int channelId, final boolean refresh) {
        if (refresh) pageNum = 0;
        mModel.getNewsData(channelId, pageNum, new Action1<NewsList>() {
            @Override
            public void call(NewsList newsList) {
                mView.onNewsData(newsList.getList(), refresh);
                mView.stopLoading();
                if ("True".equals(newsList.getNext())) {
                    pageNum = Integer.parseInt(newsList.getNextpage());
                }
            }
        });
    }
}