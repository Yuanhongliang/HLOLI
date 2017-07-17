package com.xiaoyuan.hloli.ui.home.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.xiaoyuan.hloli.bean.BannerList;
import com.xiaoyuan.hloli.ui.web.activity.WebActivity;
import com.xiaoyuan.hloli.utils.ImageLoadUtils;

import java.util.List;

/**
 * 轮播图Adapter
 * Created by yuan on 2017/4/26.
 */
public class BannerAdapter extends LoopPagerAdapter {

    private List<BannerList.ListEntity> data;

    public BannerAdapter(RollPagerView viewPager, List<BannerList.ListEntity> data) {
        super(viewPager);
        this.data = data;
    }

    @Override
    public View getView(final ViewGroup container, final int position) {
        ImageView view = new ImageView(container.getContext());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebActivity.start(container.getContext(), data.get(position).getArticle_url(),false);
            }
        });
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ImageLoadUtils.loadImage(container.getContext(), data.get(position).getImage_url_big(), view);
        return view;
    }

    @Override
    public int getRealCount() {
        return data.size();
    }
}
