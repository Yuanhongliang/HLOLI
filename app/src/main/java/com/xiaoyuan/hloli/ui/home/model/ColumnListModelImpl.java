package com.xiaoyuan.hloli.ui.home.model;

import com.xiaoyuan.hloli.bean.NewsList;
import com.xiaoyuan.hloli.http.HttpMethod;
import com.xiaoyuan.hloli.ui.home.contract.ColumnListContract;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by yuan on 2017/05/10
 */

public class ColumnListModelImpl implements ColumnListContract.Model {

    @Override
    public void getNewsData(int channelId, int page, Action1<NewsList> s) {
        HttpMethod.getInstance().getNewsByColumn(page, channelId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(s);
    }
}