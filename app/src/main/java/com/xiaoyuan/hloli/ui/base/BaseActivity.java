package com.xiaoyuan.hloli.ui.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.Toast;

import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.manager.AppManager;
import com.xiaoyuan.hloli.utils.ClassUtil;
import com.xiaoyuan.hloli.weiget.view.ProgressWheel;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yubai on 2017/1/3.
 */
public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends AppCompatActivity {

    public T mPresenter;
    public E mModel;
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        doBeforeSetcontentView();
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mContext = this;
        mPresenter = ClassUtil.getT(this, 0);
        mModel = ClassUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this;
            this.initPresenter();
        }
        this.initView();
    }

    @Bind(R.id.toolbar)
    @Nullable
    Toolbar toolbar;
    @Bind(R.id.progressWheel)
    @Nullable
    ProgressWheel progressWheel;

    public void initBaseToolBar(int titleResId, boolean canBack) {
        assert toolbar != null;
        toolbar.setTitle(titleResId);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        if (canBack && getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void initBaseToolBar(String titleStr, boolean canBack) {
        assert toolbar != null;
        toolbar.setTitle(titleStr);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        if (canBack && getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void showLoading() {
        if (progressWheel != null && !progressWheel.isSpinning()) {
            progressWheel.spin();
        }
    }

    public void stopLoading() {
        if (progressWheel != null && progressWheel.isSpinning()) {
            progressWheel.stopSpinning();
        }
    }

    /**
     * 设置layout前配置
     */
    private void doBeforeSetcontentView() {

        // 把actvity放到application栈中管理
        AppManager.getAppManager().addActivity(this);
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//        }
    }

    /*********************
     * 子类实现
     *****************************/
    //获取布局文件
    public abstract int getLayoutId();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();

    //初始化view
    public abstract void initView();


    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
        ButterKnife.unbind(this);
        AppManager.getAppManager().finishActivity(this);
    }

    protected void toast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

}
