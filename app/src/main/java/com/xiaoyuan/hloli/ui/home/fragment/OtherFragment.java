package com.xiaoyuan.hloli.ui.home.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.bean.Channel;
import com.xiaoyuan.hloli.manager.SharedPreManager;
import com.xiaoyuan.hloli.ui.base.BaseActivity;
import com.xiaoyuan.hloli.ui.base.BaseFragment;
import com.xiaoyuan.hloli.ui.base.BaseFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 其他页面
 * Created by yuan on 2017/4/25.
 */
public class OtherFragment extends BaseFragment {
    @Bind(R.id.frag_other_tab)
    TabLayout tabLayout;
    @Bind(R.id.frag_other_vp)
    ViewPager viewPager;

    List<String> titles = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_other;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        List<Channel> channelList = SharedPreManager.getInstance().getChannelList(context);
        for (Channel c : channelList) {
            titles.add(c.getName());
            if (c.getId().equals("302")) {
                fragments.add(new ColumnFragment());
            } else {
                fragments.add(ListFragment.newInstance(c));
            }
        }
        viewPager.setOffscreenPageLimit(fragments.size());
        viewPager.setAdapter(new BaseFragmentAdapter(((BaseActivity) context).getSupportFragmentManager(), fragments, titles));
        tabLayout.setupWithViewPager(viewPager);
    }
}
