package com.xiaoyuan.hloli.ui.home.contract;

import com.xiaoyuan.hloli.bean.BannerList;
import com.xiaoyuan.hloli.bean.NewsList;
import com.xiaoyuan.hloli.ui.base.BaseModel;
import com.xiaoyuan.hloli.ui.base.BasePresenter;
import com.xiaoyuan.hloli.ui.base.BaseView;

import java.util.List;

import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by yuan on 2017/4/25.
 */
public interface HomeContract {

    public interface View extends BaseView {

        void onBannerDataGet(List<BannerList.ListEntity> data);

        void onNewsData(List<NewsList.ListEntity> data, boolean refresh);
    }

    public abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getBannerData();

        public abstract void getNewsData(int channelId, boolean refresh);

        public abstract void getCacheBannerData();

        public abstract void getCacheNewsData();
    }

    public interface Model extends BaseModel {
        void getBannerData(Subscriber<BannerList> s);

        void getNewsData(int channelId, int page, Action1<NewsList> s);
    }
}