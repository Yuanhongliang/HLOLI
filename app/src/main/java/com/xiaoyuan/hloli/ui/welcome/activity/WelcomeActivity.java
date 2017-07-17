package com.xiaoyuan.hloli.ui.welcome.activity;

import android.view.WindowManager;
import android.widget.ImageView;

import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.bean.AdList;
import com.xiaoyuan.hloli.bean.Channel;
import com.xiaoyuan.hloli.manager.SharedPreManager;
import com.xiaoyuan.hloli.ui.base.BaseActivity;
import com.xiaoyuan.hloli.ui.home.activity.MainActivity;
import com.xiaoyuan.hloli.ui.welcome.contract.WelcomeContract;
import com.xiaoyuan.hloli.ui.welcome.model.WelcomeModelImpl;
import com.xiaoyuan.hloli.ui.welcome.presenter.WelcomePresenterImpl;
import com.xiaoyuan.hloli.utils.ImageLoadUtils;
import com.xiaoyuan.hloli.utils.NetworkUtil;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;

/**
 * 欢迎页
 * Created by yuan on 2017/5/2.
 */
public class WelcomeActivity extends BaseActivity<WelcomePresenterImpl, WelcomeModelImpl> implements WelcomeContract.View {

    @Bind(R.id.act_wel_img)
    ImageView img;
    private AdList adList;

    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (NetworkUtil.isNetAvailable(mContext)) {
            mPresenter.getAdImage();
            mPresenter.getChannelList();
        } else {
            mPresenter.getCacheAdImage();
        }
    }

    @Override
    public void onAdImgGet(AdList adList) {
        this.adList = adList;
        ImageLoadUtils.loadImage(this, adList.getList().get(0).getImage_url(), img);
//        img.setOnClickListener(this);
        startDelay();
    }

    private void startDelay() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                MainActivity.startActivity(mContext);
                finish();
            }
        };
        timer.schedule(task, 3000);
    }

    @Override
    public void onChannelListGet(List<Channel> s) {
        SharedPreManager.getInstance().putChannelList(mContext, s);
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void showErrorTip(String msg) {

    }
//
//    @Override
//    public void onClick(View v) {
//        if (adList != null) {
//            WebActivity.start(this, adList.getList().get(0).getJump_url(),true);
//            finish();
//        }
//    }
}
