package com.xiaoyuan.hloli.ui.home.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.bean.ColumnList;
import com.xiaoyuan.hloli.ui.base.BaseFragment;
import com.xiaoyuan.hloli.ui.home.adapter.ColumnAdapter;
import com.xiaoyuan.hloli.ui.home.contract.ColumnContract;
import com.xiaoyuan.hloli.ui.home.model.ColumnModelImpl;
import com.xiaoyuan.hloli.ui.home.presenter.ColumnPresenterImpl;
import com.xiaoyuan.hloli.utils.ChangeThemeUtils;
import com.xiaoyuan.hloli.utils.NetworkUtil;
import com.xiaoyuan.hloli.utils.ShowTipUtils;
import com.xiaoyuan.hloli.weiget.view.DividerDecoration;

import java.util.List;

import butterknife.Bind;

/**
 * Created by yuan on 2017/5/9.
 */
public class ColumnFragment extends BaseFragment<ColumnPresenterImpl, ColumnModelImpl> implements ColumnContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.frag_list_swipe)
    SwipeRefreshLayout swipeRefreshLayout;

    @Bind(R.id.frag_list_recycler)
    RecyclerView recyclerView;

    private ColumnAdapter adapter;

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
        adapter = new ColumnAdapter(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new DividerDecoration(context, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!recyclerView.canScrollVertically(1) && dy > 0) {
                    if (NetworkUtil.isNetAvailable(context))
                        mPresenter.getColumnList(false);
                }
            }
        });
        ChangeThemeUtils.changeSwipeRefreshTheme(swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    protected void initData() {
        if (NetworkUtil.isNetAvailable(context)) {
            mPresenter.getColumnList(false);
        } else {
//            ShowTipUtils.showNetError(context);
        }
    }

    @Override
    public void onColumnDataGet(List<ColumnList.ListEntity> data, boolean refresh) {
        if (refresh) {
            adapter.setData(data);
        } else {
            adapter.addData(data);
        }
    }

    @Override
    public void showLoading(String title) {
        if (!swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(true);
        }
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
            mPresenter.getColumnList(true);
        } else {
            stopLoading();
        }
    }
}
