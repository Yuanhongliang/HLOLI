package com.xiaoyuan.hloli.ui.home.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.bean.BannerList;
import com.xiaoyuan.hloli.bean.Channel;
import com.xiaoyuan.hloli.bean.NewsList;
import com.xiaoyuan.hloli.ui.base.BaseFragment;
import com.xiaoyuan.hloli.ui.home.adapter.HomeAdapter;
import com.xiaoyuan.hloli.ui.home.adapter.ListAdapter;
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
 * 列表页
 * Created by yuan on 2017/5/2.
 */
public class ListFragment extends BaseFragment<HomePresenterImpl, HomeModelImpl> implements HomeContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.frag_list_swipe)
    SwipeRefreshLayout swipeRefreshLayout;

    @Bind(R.id.frag_list_recycler)
    RecyclerView recyclerView;

    ListAdapter adapter;

    //居中TextView显示的内容
    private Channel c;

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_list;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        adapter = new ListAdapter(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new DividerDecoration(context, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!recyclerView.canScrollVertically(1) && dy > 0) {
                    if (NetworkUtil.isNetAvailable(context)) {
                        mPresenter.getNewsData(Integer.parseInt(c.getId()), false);
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
            mPresenter.getNewsData(Integer.parseInt(c.getId()), true);
        } else {
//            ShowTipUtils.showNetError(context);
        }
    }

    public static ListFragment newInstance(Channel channel) {
        ListFragment simpleFragment = new ListFragment();
        simpleFragment.c = channel;
        return simpleFragment;
    }

    @Override
    public void onBannerDataGet(List<BannerList.ListEntity> data) {
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
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();
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
    public void onRefresh() {
        if (NetworkUtil.isNetAvailable(context)) {
            mPresenter.getNewsData(Integer.parseInt(c.getId()), true);
        } else {
            stopLoading();
        }
    }
}
