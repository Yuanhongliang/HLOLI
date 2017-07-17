package com.xiaoyuan.hloli.ui.image;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.ui.base.BaseActivity;
import com.xiaoyuan.hloli.utils.ImageLoadUtils;

import butterknife.Bind;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by yuan on 2017/5/11.
 */
public class ImageActivity extends BaseActivity {

    @Bind(R.id.photoView)
    PhotoView photoView;
    public static final String URL = "url";

    @Override
    public int getLayoutId() {
        return R.layout.activity_image;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4 全透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0 全透明实现
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);//calculateStatusColor(Color.WHITE, (int) alphaValue)
        }
        String url = getIntent().getStringExtra(URL);
        ImageLoadUtils.loadImage(mContext, url, photoView);
    }
}
