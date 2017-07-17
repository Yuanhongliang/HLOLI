package com.xiaoyuan.hloli.ui.home.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.bean.BannerList;
import com.xiaoyuan.hloli.bean.NewsList;
import com.xiaoyuan.hloli.ui.base.BaseFragment;
import com.xiaoyuan.hloli.ui.home.adapter.HomeAdapter;
import com.xiaoyuan.hloli.ui.home.contract.HomeContract;
import com.xiaoyuan.hloli.ui.home.model.HomeModelImpl;
import com.xiaoyuan.hloli.ui.home.presenter.HomePresenterImpl;
import com.xiaoyuan.hloli.utils.ChangeThemeUtils;
import com.xiaoyuan.hloli.utils.NetworkUtil;
import com.xiaoyuan.hloli.utils.ShowTipUtils;
import com.xiaoyuan.hloli.weiget.view.DividerDecoration;

import java.util.List;

import butterknife.Bind;

/**
 * 主页的fragment
 * Created by yuan on 2017/4/25.
 */
public class HomeFragment extends BaseFragment<HomePresenterImpl, HomeModelImpl> implements HomeContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.frag_home_swipe)
    SwipeRefreshLayout swipeRefreshLayout;

    @Bind(R.id.frag_home_recycler)
    RecyclerView recyclerView;

    HomeAdapter adapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        adapter = new HomeAdapter(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new DividerDecoration(context, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!recyclerView.canScrollVertically(1) && dy > 0) {
                    if (NetworkUtil.isNetAvailable(context)) {
                        mPresenter.getNewsData(12, false);
                    }
                }
            }
        });
        ChangeThemeUtils.changeSwipeRefreshTheme(swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    protected void initData() {
        if (NetworkUtil.isNetAvailable(context)) {
            mPresenter.getNewsData(12, true);
            mPresenter.getBannerData();
        } else {
            mPresenter.getCacheBannerData();
            mPresenter.getCacheNewsData();
            ShowTipUtils.showNetError(context);
        }
    }

    @Override
    public void onBannerDataGet(List<BannerList.ListEntity> data) {
        adapter.addBannerData(data);
    }

    @Override
    public void onNewsData(List<NewsList.ListEntity> data, boolean refresh) {
        if (refresh) {
            adapter.replaceNewsData(data);
        } else {
            adapter.addNewsData(data);
        }
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {
        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing())
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showErrorTip(String msg) {

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onRefresh() {
        if (NetworkUtil.isNetAvailable(context)) {
            mPresenter.getNewsData(12, true);
        } else {
            stopLoading();
        }
    }
}
