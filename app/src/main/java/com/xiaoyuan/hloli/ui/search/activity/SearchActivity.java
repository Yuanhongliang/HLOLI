package com.xiaoyuan.hloli.ui.search.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.ui.base.BaseActivity;
import com.xiaoyuan.hloli.ui.search.adapter.HistoryAdapter;
import com.xiaoyuan.hloli.ui.search.contract.SearchContract;
import com.xiaoyuan.hloli.ui.search.model.SearchModelImpl;
import com.xiaoyuan.hloli.ui.search.presenter.SearchPresenterImpl;
import com.xiaoyuan.hloli.utils.DialogUtils;
import com.xiaoyuan.hloli.utils.ShowTipUtils;
import com.xiaoyuan.hloli.weiget.view.DividerDecoration;

import java.util.List;

import butterknife.Bind;

/**
 * 搜索界面
 * Created by yuan on 2017/5/2.
 */
public class SearchActivity extends BaseActivity<SearchPresenterImpl, SearchModelImpl> implements View.OnClickListener, TextView.OnEditorActionListener, TextWatcher, SearchContract.View, HistoryAdapter.MyHolder.OnItemClickListener, HistoryAdapter.DataObserver {

    @Bind(R.id.act_search_toolbar)
    Toolbar toolbar;

    @Bind(R.id.act_search_et)
    EditText et;

    @Bind(R.id.act_search_back)
    ImageView back;

    @Bind(R.id.act_search_clear)
    Button clear;

    @Bind(R.id.act_search_recycler)
    RecyclerView recyclerView;

    @Bind(R.id.act_search_clear_all)
    Button clearAll;
    private HistoryAdapter adapter;


    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        setSupportActionBar(toolbar);
        back.setOnClickListener(this);
        clear.setOnClickListener(this);
        et.setOnEditorActionListener(this);
        et.addTextChangedListener(this);
        clearAll.setOnClickListener(this);
        adapter = new HistoryAdapter(mContext);
        adapter.setOnItemClickListener(this);
        adapter.setObserver(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.addItemDecoration(new DividerDecoration(mContext, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        mPresenter.queryHistory(this);
    }


    public static void startActivity(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        if (context != null) context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_search_back:
                finish();
                overridePendingTransition(0, 0);
                break;
            case R.id.act_search_clear:
                et.setText("");
                break;
            case R.id.act_search_clear_all:
                onClearClick();
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            String item = v.getText().toString().trim();
            if (v.getText().length() > 0) {
                mPresenter.addHistory(mContext, item);
                v.setText("");
                SearchResultActivity.startActivity(mContext, item);
            }
        }
        return false;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length() == 0) {
            clear.setVisibility(View.GONE);
        } else {
            clear.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void getAllHistory(List<String> data) {
        adapter.setData(data);
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void showErrorTip(String msg) {
        ShowTipUtils.showTip(mContext, msg);
    }

    @Override
    public void onItemClick(View v, int position) {
        SearchResultActivity.startActivity(mContext, adapter.getData().get(position));
    }

    @Override
    public void onDeleteClick(View v, int position) {
        mPresenter.deleteHistory(mContext, position);
    }


    private void onClearClick() {
        DialogUtils.showDialog(mContext, R.string.reminder, R.string.ensure, true, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mPresenter.clearHistory(mContext);
                dialog.dismiss();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onDataChanged(boolean show) {
        if (show) {
            clearAll.setVisibility(View.VISIBLE);
        } else {
            clearAll.setVisibility(View.GONE);
        }
    }
}
