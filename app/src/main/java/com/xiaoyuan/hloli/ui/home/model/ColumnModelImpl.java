package com.xiaoyuan.hloli.ui.home.model;

import com.xiaoyuan.hloli.bean.ColumnList;
import com.xiaoyuan.hloli.http.HttpMethod;
import com.xiaoyuan.hloli.ui.home.contract.ColumnContract;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yuan on 2017/05/09
 */

public class ColumnModelImpl implements ColumnContract.Model {

    @Override
    public void getColumnList(int page, Subscriber<ColumnList> s) {
        HttpMethod.getInstance().getColumnList(page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(s);
    }
}