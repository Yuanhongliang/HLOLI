package com.xiaoyuan.hloli.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.bean.ColumnList;
import com.xiaoyuan.hloli.bean.NewsList;
import com.xiaoyuan.hloli.ui.base.BaseActivity;
import com.xiaoyuan.hloli.ui.home.adapter.ListAdapter;
import com.xiaoyuan.hloli.ui.home.contract.ColumnListContract;
import com.xiaoyuan.hloli.ui.home.model.ColumnListModelImpl;
import com.xiaoyuan.hloli.ui.home.presenter.ColumnListPresenterImpl;
import com.xiaoyuan.hloli.utils.ImageLoadUtils;
import com.xiaoyuan.hloli.utils.ShowTipUtils;
import com.xiaoyuan.hloli.weiget.view.DividerDecoration;

import java.util.List;

import butterknife.Bind;

/**
 * Created by yuan on 2017/5/9.
 */
public class ColumnListActivity extends BaseActivity<ColumnListPresenterImpl, ColumnListModelImpl> implements ColumnListContract.View, AppBarLayout.OnOffsetChangedListener, View.OnClickListener {

    @Bind(R.id.app_bar)
    AppBarLayout appBarLayout;

    @Bind(R.id.act_col_toolbar)
    Toolbar toolbar;

    @Bind(R.id.act_col_img)
    ImageView icon;

    @Bind(R.id.act_col_title)
    TextView title;
    private ColumnList.ListEntity c;

    @Bind(R.id.act_col_img_bg)
    ImageView iconBg;

    @Bind(R.id.act_col_title_bg)
    TextView titleBg;

    @Bind(R.id.act_col_des_bg)
    TextView desBg;

    @Bind(R.id.act_col_back)
    ImageView back;

    @Bind(R.id.act_col_recycler)
    RecyclerView recyclerView;


    ListAdapter adapter;

    private int id;

    @Override
    public int getLayoutId() {
        return R.layout.activity_column;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        c = (ColumnList.ListEntity) getIntent().getSerializableExtra("c");
        appBarLayout.addOnOffsetChangedListener(this);
        setSupportActionBar(toolbar);
        if (c != null) {
            title.setText(c.getCol_title());
            titleBg.setText(c.getCol_title());
            desBg.setText(c.getCol_des());
            ImageLoadUtils.loadRoundImage(mContext, c.getLogo(), icon);
            ImageLoadUtils.loadRoundImage(mContext, c.getLogo(), iconBg);
        }
        back.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.addItemDecoration(new DividerDecoration(mContext, LinearLayoutManager.VERTICAL));
        adapter = new ListAdapter(mContext);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!recyclerView.canScrollVertically(1) && dy > 0) {
                    mPresenter.getNewsData(id, false);
                }
            }
        });
    }


    public static void startActivity(Context context, ColumnList.ListEntity c) {
        Intent intent = new Intent(context, ColumnListActivity.class);
        intent.putExtra("c", c);
        context.startActivity(intent);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int a = appBarLayout.getTotalScrollRange();
//        Log.e("offset", verticalOffset + "----" + a);
        if (verticalOffset == 0) {
            //expand all
            back.setImageResource(R.drawable.back_black);
        } else if (Math.abs(verticalOffset) >= a) {
            //closed totally
            title.setVisibility(View.VISIBLE);
            icon.setVisibility(View.VISIBLE);
            back.setImageResource(R.drawable.back_white);
        } else {
            title.setVisibility(View.GONE);
            icon.setVisibility(View.GONE);
            //doing the transition
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_col_back:
                finish();
                break;
        }
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
    public void showErrorTip(String msg) {
        ShowTipUtils.showTip(mContext, msg);
    }

    @Override
    protected void onStart() {
        super.onStart();
        id = Integer.parseInt(c.getCol_id());
        mPresenter.getNewsData(id, true);
    }
}
