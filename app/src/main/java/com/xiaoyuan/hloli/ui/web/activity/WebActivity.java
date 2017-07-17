package com.xiaoyuan.hloli.ui.web.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.MenuItem;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.ui.base.BaseActivity;
import com.xiaoyuan.hloli.utils.ChangeThemeUtils;
import com.xiaoyuan.hloli.weiget.view.TopRefreshWebView;

import butterknife.Bind;

/**
 * 资讯详情
 * Created by yuan on 2017/4/27.
 */
public class WebActivity extends BaseActivity implements TopRefreshWebView.OnScrollChangedListener, SwipeRefreshLayout.OnRefreshListener {

    private static final String URL = "url";

    @Bind(R.id.act_web_swipe)
    SwipeRefreshLayout swipeRefreshLayout;

    @Bind(R.id.act_web_webView)
    TopRefreshWebView webView;


    @Override
    public int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    public void initPresenter() {

    }


    @SuppressLint({"SetJavaScriptEnabled"})
    @Override
    public void initView() {
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        WebSettings webSetting = webView.getSettings();
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(false);
        // webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        // webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setJavaScriptEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webView.loadUrl(getIntent().getStringExtra(URL));
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
                stopLoading();
                if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }

            @Override
            public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
                super.onPageStarted(webView, s, bitmap);
                showLoading();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                return super.shouldOverrideUrlLoading(webView, s);
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        webView.setOnScrollChangedListener(this);
        initBaseToolBar(R.string.news_detail, true);
        ChangeThemeUtils.changeSwipeRefreshTheme(swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    public static void start(Context context, String url, boolean newTask) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(URL, url);
        if (newTask) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void onScrollChanged(boolean enable) {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setEnabled(true);
        } else {
            swipeRefreshLayout.setEnabled(enable);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onRefresh() {
        webView.reload();
    }
}
