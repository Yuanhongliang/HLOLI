package com.xiaoyuan.hloli.ui.base;

import android.content.Context;

/**
 * des:基类presenter
 */
public abstract class BasePresenter<V, M> {
    public Context mContext;
    public M mModel;
    public V mView;

    public void setVM(V v, M m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    public void onStart() {
    }

    public void onDestroy() {

    }
}
