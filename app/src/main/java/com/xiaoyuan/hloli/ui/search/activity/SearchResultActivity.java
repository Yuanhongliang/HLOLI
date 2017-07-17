package com.xiaoyuan.hloli.ui.search.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.bean.SearchResult;
import com.xiaoyuan.hloli.ui.base.BaseActivity;
import com.xiaoyuan.hloli.ui.search.adapter.SearchResultAdapter;
import com.xiaoyuan.hloli.ui.search.contract.SearchResultContract;
import com.xiaoyuan.hloli.ui.search.model.SearchResultModelImpl;
import com.xiaoyuan.hloli.ui.search.presenter.SearchResultPresenterImpl;
import com.xiaoyuan.hloli.utils.ShowTipUtils;

import java.util.List;

import butterknife.Bind;

/**
 * 搜索结果界面
 * Created by yuan on 2017/5/2.
 */
public class SearchResultActivity extends BaseActivity<SearchResultPresenterImpl, SearchResultModelImpl> implements SearchResultContract.View, SearchResultAdapter.LoadMoreDataListener {

    public static final String KEYWORD = "keyword";

    @Bind(R.id.act_search_result_recycler)
    RecyclerView recyclerView;

    private SearchResultAdapter adapter;
    private String keyword;


    @Override
    public int getLayoutId() {
        return R.layout.activity_search_result;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        keyword = getIntent().getStringExtra(KEYWORD);
        initBaseToolBar(keyword, true);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));
        adapter = new SearchResultAdapter(mContext, recyclerView);
        recyclerView.setAdapter(adapter);
        adapter.setOnMoreDataLoadListener(this);
        mPresenter.searchArticles(keyword, false);
    }

    @Override
    public void onArticlesGet(List<SearchResult.ListEntity> data, boolean refresh) {
        stopLoading();
        adapter.addNewsData(data);
        adapter.stopLoadMore();
    }

    @Override
    public void noMoreData() {
        ShowTipUtils.showTip(mContext, R.string.no_more_data);
        adapter.stopLoadMore();
    }

    @Override
    public void showLoading(String title) {
        showLoading();
    }

    @Override
    public void showErrorTip(String msg) {
        ShowTipUtils.showTip(mContext, msg);
    }

    public static void startActivity(Context context, String keyword) {
        Intent intent = new Intent(context, SearchResultActivity.class);
        intent.putExtra(KEYWORD, keyword);
        context.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loadMoreData() {
        mPresenter.searchArticles(keyword, false);
    }
}
