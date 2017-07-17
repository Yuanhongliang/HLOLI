package com.xiaoyuan.hloli.ui.welcome.presenter;

import com.xiaoyuan.hloli.bean.AdList;
import com.xiaoyuan.hloli.bean.Channel;
import com.xiaoyuan.hloli.manager.SharedPreManager;
import com.xiaoyuan.hloli.ui.welcome.contract.WelcomeContract;

import java.util.List;

import rx.Subscriber;

/**
 * Created by yuan on 2017/05/02
 */

public class WelcomePresenterImpl extends WelcomeContract.Presenter {

    @Override
    public void getAdImage() {
        mModel.getAdImage(new Subscriber<AdList>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorTip(e.getLocalizedMessage());
            }

            @Override
            public void onNext(AdList adList) {
                mView.onAdImgGet(adList);
                SharedPreManager.getInstance().putAdList(mContext, adList);
            }
        });
    }

    @Override
    public void getChannelList() {
        mModel.getChannelList(new Subscriber<List<Channel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorTip(e.getLocalizedMessage());
            }

            @Override
            public void onNext(List<Channel> s) {
                mView.onChannelListGet(s);
            }
        });
    }

    @Override
    public void getCacheAdImage() {
        AdList adList = SharedPreManager.getInstance().getAdList(mContext);
        if (adList != null) {
            mView.onAdImgGet(adList);
        }
    }
}