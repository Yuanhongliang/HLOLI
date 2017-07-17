package com.xiaoyuan.hloli.ui.home.contract;

import com.xiaoyuan.hloli.bean.NewsList;
import com.xiaoyuan.hloli.ui.base.BaseModel;
import com.xiaoyuan.hloli.ui.base.BasePresenter;
import com.xiaoyuan.hloli.ui.base.BaseView;

import java.util.List;

import rx.functions.Action1;

/**
 * Created by yuan on 2017/5/10.
 */
public interface ColumnListContract {

    public interface View extends BaseView {
        void onNewsData(List<NewsList.ListEntity> data, boolean refresh);
    }

    public abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getNewsData(int channelId, boolean refresh);
    }

    public interface Model extends BaseModel {
        void getNewsData(int channelId, int page, Action1<NewsList> s);
    }
}