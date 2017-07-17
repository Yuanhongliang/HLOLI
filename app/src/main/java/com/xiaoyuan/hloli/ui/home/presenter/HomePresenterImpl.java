package com.xiaoyuan.hloli.ui.home.presenter;

import android.util.Log;

import com.xiaoyuan.hloli.bean.BannerList;
import com.xiaoyuan.hloli.bean.NewsList;
import com.xiaoyuan.hloli.manager.SharedPreManager;
import com.xiaoyuan.hloli.ui.home.contract.HomeContract;

import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by yuan on 2017/04/25
 */

public class HomePresenterImpl extends HomeContract.Presenter {

    private int pageNum = 0;

    @Override
    public void getBannerData() {
        mModel.getBannerData(new Subscriber<BannerList>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorTip(e.getLocalizedMessage());
            }

            @Override
            public void onNext(BannerList bannerList) {
                mView.onBannerDataGet(bannerList.getList());
                SharedPreManager.getInstance().putBannerList(mContext, bannerList);
            }
        });
    }

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
                if (refresh) {
                    SharedPreManager.getInstance().putNewsList(mContext, newsList);
                }
            }
        });
    }

    @Override
    public void getCacheBannerData() {
        BannerList bannerList = SharedPreManager.getInstance().getBannerList(mContext);
        if (bannerList != null && bannerList.getList() != null) {
            mView.onBannerDataGet(bannerList.getList());
        }
    }

    @Override
    public void getCacheNewsData() {
        NewsList newsList = SharedPreManager.getInstance().getNewsList(mContext);
        if (newsList != null && newsList.getList() != null) {
            mView.onNewsData(newsList.getList(), true);
        }
    }
}