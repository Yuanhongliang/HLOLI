package com.xiaoyuan.hloli.ui.search.contract;

import com.xiaoyuan.hloli.bean.SearchResult;
import com.xiaoyuan.hloli.ui.base.BaseModel;
import com.xiaoyuan.hloli.ui.base.BasePresenter;
import com.xiaoyuan.hloli.ui.base.BaseView;

import java.util.List;

import rx.Subscriber;

/**
 * Created by yuan on 2017/5/5.
 */
public interface SearchResultContract {

    public interface View extends BaseView {
        void onArticlesGet(List<SearchResult.ListEntity> data, boolean refresh);
        void noMoreData();
    }

    public abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void searchArticles(String keyword, boolean refresh);
    }

    public interface Model extends BaseModel {
        void searchArticles(String keyword, int num, int page, Subscriber<SearchResult> s);
    }

}