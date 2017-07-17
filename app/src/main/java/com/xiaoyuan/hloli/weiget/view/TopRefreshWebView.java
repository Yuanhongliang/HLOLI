package com.xiaoyuan.hloli.weiget.view;

import android.content.Context;
import android.util.AttributeSet;

import com.tencent.smtt.sdk.WebView;


/**
 * 解决webView与SwipeRefreshLayout滑动冲突
 * Created by yuan on 2017/4/27.
 */
public class TopRefreshWebView extends WebView {
    public TopRefreshWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TopRefreshWebView(Context context) {
        super(context);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollChangedListener == null) return;
        if (t == 0) {
            onScrollChangedListener.onScrollChanged(true);
        } else {
            onScrollChangedListener.onScrollChanged(false);
        }
    }

    public interface OnScrollChangedListener {
        void onScrollChanged(boolean enable);
    }

    private OnScrollChangedListener onScrollChangedListener;

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }
}
