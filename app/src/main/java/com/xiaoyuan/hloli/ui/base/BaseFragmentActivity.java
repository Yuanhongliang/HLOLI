package com.xiaoyuan.hloli.ui.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

public abstract class BaseFragmentActivity<T extends BasePresenter, E extends BaseModel> extends BaseActivity<T, E> {
    private static final String TAG = "BaseFragmentActivity";

    public void addFragment(int layout, Fragment fragment) {
        addFragment(new int[]{layout}, new Fragment[]{fragment});
    }

    public void addFragment(int[] layout, Fragment[] fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < layout.length; i++) {
            transaction.add(layout[i], fragment[i]);
        }
        transaction.commit();
    }

    public void removeFragment(Fragment... fragments) {
        try {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            for (Fragment fragment : fragments) {
                transaction.remove(fragment);
            }
            transaction.commit();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    public void showFragment(Fragment... fragments) {
        try {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            for (Fragment fragment : fragments) {
                transaction.show(fragment);
            }
            transaction.commit();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    public void hideFragment(Fragment... fragments) {
        try {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            for (Fragment fragment : fragments) {
                transaction.hide(fragment);
            }
            transaction.commit();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

}
