package com.xiaoyuan.hloli.ui.welcome.contract;

import com.xiaoyuan.hloli.bean.AdList;
import com.xiaoyuan.hloli.bean.Channel;
import com.xiaoyuan.hloli.ui.base.BaseModel;
import com.xiaoyuan.hloli.ui.base.BasePresenter;
import com.xiaoyuan.hloli.ui.base.BaseView;

import java.util.List;

import rx.Subscriber;

/**
 * Created by yuan on 2017/5/2.
 */
public interface WelcomeContract {


    public interface View extends BaseView {
        void onAdImgGet(AdList adList);

        void onChannelListGet(List<Channel> s);
    }

    public abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getAdImage();

        public abstract void getChannelList();

        public abstract void getCacheAdImage();

    }

    public interface Model extends BaseModel {
        void getAdImage(Subscriber<AdList> s);

        void getChannelList(Subscriber<List<Channel>> s);
    }

}