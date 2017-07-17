package com.xiaoyuan.hloli.ui.home.presenter;

import com.xiaoyuan.hloli.bean.ColumnList;
import com.xiaoyuan.hloli.ui.home.contract.ColumnContract;

import rx.Subscriber;

/**
 * Created by yuan on 2017/05/09
 */

public class ColumnPresenterImpl extends ColumnContract.Presenter {


    int page = 0;
    boolean hasMore = true;


    @Override
    public void getColumnList(final boolean refresh) {
        if (refresh) {
            page = 0;
            hasMore = true;
        }
        if (!hasMore) return;
        mModel.getColumnList(page, new Subscriber<ColumnList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorTip(e.getLocalizedMessage());
            }

            @Override
            public void onNext(ColumnList columnList) {
                if ("1".equals(columnList.getHasnext())) {
                    page++;
                } else {
                    hasMore = false;
                }
                mView.stopLoading();
                mView.onColumnDataGet(columnList.getUnbook_list(), refresh);
            }
        });
    }

}