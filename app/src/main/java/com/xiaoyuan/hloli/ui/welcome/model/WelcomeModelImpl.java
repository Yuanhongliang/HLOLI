package com.xiaoyuan.hloli.ui.welcome.model;

import com.xiaoyuan.hloli.bean.AdList;
import com.xiaoyuan.hloli.bean.Channel;
import com.xiaoyuan.hloli.http.HttpMethod;
import com.xiaoyuan.hloli.ui.welcome.contract.WelcomeContract;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yuan on 2017/05/02
 */

public class WelcomeModelImpl implements WelcomeContract.Model {

    @Override
    public void getAdImage(Subscriber<AdList> s) {
        HttpMethod.getInstance().getAdList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(s);
    }

    @Override
    public void getChannelList(Subscriber<List<Channel>> s) {
        HttpMethod.getInstance().getChannelList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(s);
    }
}