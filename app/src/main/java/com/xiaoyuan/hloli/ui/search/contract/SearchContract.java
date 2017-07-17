package com.xiaoyuan.hloli.ui.search.contract;

import android.content.Context;

import com.xiaoyuan.hloli.ui.base.BaseModel;
import com.xiaoyuan.hloli.ui.base.BasePresenter;
import com.xiaoyuan.hloli.ui.base.BaseView;

import java.util.List;

import rx.Subscriber;

/**
 * Created by yuan on 2017/5/2.
 */
public interface SearchContract {


    public interface View extends BaseView {
        void getAllHistory(List<String> data);
    }

    public abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void queryHistory(Context context);

        public abstract void addHistory(Context context, String item);

        public abstract void deleteHistory(Context context, int position);

        public abstract void clearHistory(Context context);
    }

    public interface Model extends BaseModel {
        void queryHistory(Context context, Subscriber<List<String>> s);

        void insertHistory(Context context, List<String> data, Subscriber<Void> s);
    }

}