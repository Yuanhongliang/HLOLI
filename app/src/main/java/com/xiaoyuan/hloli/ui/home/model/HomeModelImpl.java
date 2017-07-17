package com.xiaoyuan.hloli.ui.home.model;

import com.xiaoyuan.hloli.bean.BannerList;
import com.xiaoyuan.hloli.bean.NewsList;
import com.xiaoyuan.hloli.http.HttpMethod;
import com.xiaoyuan.hloli.ui.home.contract.HomeContract;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by yuan on 2017/04/25
 */

public class HomeModelImpl implements HomeContract.Model {

    @Override
    public void getBannerData(Subscriber<BannerList> s) {
        HttpMethod.getInstance().getBanner().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(s);
    }

    @Override
    public void getNewsData(int channelId, int page, Action1<NewsList> s) {
        HttpMethod.getInstance().getNews(channelId, page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(s);
    }
}