package com.xiaoyuan.hloli.ui.home.contract;

import com.xiaoyuan.hloli.bean.ColumnList;
import com.xiaoyuan.hloli.ui.base.BaseModel;
import com.xiaoyuan.hloli.ui.base.BasePresenter;
import com.xiaoyuan.hloli.ui.base.BaseView;

import java.util.List;

import rx.Subscriber;

/**
 * * Created by yuan on 2017/5/9.
 */
public interface ColumnContract {


    public interface View extends BaseView {
        void onColumnDataGet(List<ColumnList.ListEntity> data, boolean refresh);
    }

    public abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getColumnList(boolean refresh);
    }

    public interface Model extends BaseModel {
        void getColumnList(int page, Subscriber<ColumnList> s);
    }


}