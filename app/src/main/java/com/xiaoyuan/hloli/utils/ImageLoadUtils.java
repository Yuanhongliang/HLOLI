package com.xiaoyuan.hloli.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.xiaoyuan.hloli.R;

/**
 * Created by yuan on 2017/4/26.
 */
public class ImageLoadUtils {

    public static void loadImage(Context context, String url, ImageView imgView) {
        Glide.with(context).load(url).placeholder(R.drawable.loading).into(imgView);
    }

    public static void loadImage(Context context, int resId, ImageView imgView) {
        Glide.with(context).load(resId).placeholder(R.drawable.loading).into(imgView);
    }

    public static void loadRoundImage(final Context context, String url, final ImageView imgView) {
        Glide.with(context).load(url).asBitmap().centerCrop().into(new BitmapImageViewTarget(imgView) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imgView.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    public static void loadRoundImage(final Context context, int resId, final ImageView imgView) {
        Glide.with(context).load(resId).asBitmap().centerCrop().into(new BitmapImageViewTarget(imgView) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imgView.setImageDrawable(circularBitmapDrawable);
            }
        });
    }
}
