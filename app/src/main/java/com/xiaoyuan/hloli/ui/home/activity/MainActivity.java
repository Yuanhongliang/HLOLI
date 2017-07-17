package com.xiaoyuan.hloli.ui.home.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.app.App;
import com.xiaoyuan.hloli.manager.SharedPreManager;
import com.xiaoyuan.hloli.ui.base.BaseFragmentActivity;
import com.xiaoyuan.hloli.ui.home.fragment.HomeFragment;
import com.xiaoyuan.hloli.ui.home.fragment.OtherFragment;
import com.xiaoyuan.hloli.ui.image.ImageActivity;
import com.xiaoyuan.hloli.ui.search.activity.SearchActivity;
import com.xiaoyuan.hloli.utils.CacheUtil;
import com.xiaoyuan.hloli.utils.DialogUtils;
import com.xiaoyuan.hloli.utils.ImageLoadUtils;
import com.xiaoyuan.hloli.utils.ShowTipUtils;

import butterknife.Bind;

/**
 * 主页面
 * Created by yuan on 2017/4/25.
 */
public class MainActivity extends BaseFragmentActivity implements View.OnClickListener {

    @Bind(R.id.act_main_toolbar)
    Toolbar toolbar;

    @Bind(R.id.act_main_drawer)
    DrawerLayout drawerLayout;

    @Bind(R.id.act_main_home)
    ImageView mHomeBtn;

    @Bind(R.id.act_main_other)
    ImageView mOtherBtn;

    @Bind(R.id.act_main_icon)
    ImageView icon;

    HomeFragment homeFragment;
    OtherFragment otherFragment;

    private ActionBarDrawerToggle toggle;

    @Bind(R.id.act_main_language)
    TextView changeLanguage;
    @Bind(R.id.act_main_about)
    TextView about;
    @Bind(R.id.act_main_cache)
    TextView cache;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void initView() {
        initToolBar();
        mHomeBtn.setOnClickListener(this);
        mOtherBtn.setOnClickListener(this);
        icon.setOnClickListener(this);
        changeLanguage.setOnClickListener(this);
        about.setOnClickListener(this);
        cache.setOnClickListener(this);
        homeFragment = new HomeFragment();
        otherFragment = new OtherFragment();
        addFragment(R.id.act_main_frame, homeFragment);
        addFragment(R.id.act_main_frame, otherFragment);
        hideFragment(otherFragment);
        ImageLoadUtils.loadRoundImage(mContext, R.drawable.icon, icon);
    }

    private void initToolBar() {
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle(R.string.home);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() == null) return;
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.home, R.string.other) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                setCacheText();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.addDrawerListener(toggle);
    }

    private void setCacheText() {
        try {
            String size = CacheUtil.getCacheSize(getCacheDir());
            cache.setText(String.format(getString(R.string.clear_cache), size));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_main_home:
                homeChecked(true);
                hideFragment(otherFragment);
                showFragment(homeFragment);
                break;
            case R.id.act_main_other:
                homeChecked(false);
                hideFragment(homeFragment);
                showFragment(otherFragment);
                break;
            case R.id.act_main_icon:
                iconClick();
                break;
            case R.id.act_main_about:
                onAboutClick();
                break;
            case R.id.act_main_language:
                onLanguageClick();
                break;
            case R.id.act_main_cache:
                onClearCacheClick();
                break;
        }
    }


    private void onClearCacheClick() {
        drawerLayout.closeDrawers();
        DialogUtils.showDialog(mContext, R.string.reminder, R.string.ensure, true, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CacheUtil.cleanInternalCache(mContext);
                dialog.dismiss();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }

    private void onLanguageClick() {
        drawerLayout.closeDrawers();
        DialogUtils.showMultiItemsDialog(mContext, R.string.switch_language, R.array.language, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                SharedPreManager.getInstance().setLanguage(mContext, which);
                App.changeLanguage(mContext);
                Intent intent = new Intent(mContext, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
//                // 杀掉进程
//                android.os.Process.killProcess(android.os.Process.myPid());
//                System.exit(0);
            }
        });
    }

    private void onAboutClick() {
        drawerLayout.closeDrawers();
        View view = getLayoutInflater().inflate(R.layout.view_about_me, null);
        DialogUtils.showDialog(mContext, R.string.about_title, view, true);
    }

    private void iconClick() {
        ShowTipUtils.showTip(mContext, R.string.fake);
    }

    private void homeChecked(boolean checked) {
        if (checked) {
            mHomeBtn.setImageResource(R.drawable.home_checked);
            mOtherBtn.setImageResource(R.drawable.other_unchecked);
            toolbar.setTitle(R.string.home);
        } else {
            mHomeBtn.setImageResource(R.drawable.home_unchecked);
            mOtherBtn.setImageResource(R.drawable.other_checked);
            toolbar.setTitle(R.string.other);
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                SearchActivity.startActivity(mContext);
                overridePendingTransition(0, 0);
                break;
            case R.id.action_share:
                shareApp();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        if (context != null) context.startActivity(intent);
    }

    private void shareApp() {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text));
        String title = getString(R.string.share_title);
        startActivity(Intent.createChooser(shareIntent, title));
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
