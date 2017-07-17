package com.xiaoyuan.hloli.ui.search.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.bean.SearchResult;
import com.xiaoyuan.hloli.ui.web.activity.WebActivity;
import com.xiaoyuan.hloli.utils.ImageLoadUtils;
import com.xiaoyuan.hloli.utils.TextUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/5/5.
 */
public class SearchResultAdapter extends RecyclerView.Adapter {
    private final RecyclerView recyclerView;
    private List<SearchResult.ListEntity> data = new ArrayList<>();
    private static final int NEWS = 1;
    private static final int VIDEO = 2;
    private static final int FOOTER = 3;
    private Context context;
    private int totalItemCount;
    private int lastVisibleItemPosition;
    private FooterHolder footerHolder;


    public void stopLoadMore() {
        isLoadingMore = false;
        footerHolder.hideProgress();
    }

    private boolean isLoadingMore;

    public SearchResultAdapter(Context context, RecyclerView recyclerView) {
        this.context = context;
        this.recyclerView = recyclerView;
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            //mRecyclerView添加滑动事件监听
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                }

                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    if (!isLoadingMore && totalItemCount > 0 && newState == RecyclerView.SCROLL_STATE_IDLE && ((lastVisibleItemPosition) >= totalItemCount - 1)) {
                        //此时是刷新状态
                        if (mMoreDataListener != null) {
                            mMoreDataListener.loadMoreData();
                            isLoadingMore = true;
                            footerHolder.showProgress();
                        }
                    }
                }
            });
        }
    }

    private LoadMoreDataListener mMoreDataListener;

    //加载更多监听方法
    public void setOnMoreDataLoadListener(LoadMoreDataListener onMoreDataLoadListener) {
        mMoreDataListener = onMoreDataLoadListener;
    }

    public interface LoadMoreDataListener {
        void loadMoreData();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder holder;
        switch (viewType) {
            case NEWS:
                View newsView = inflater.inflate(R.layout.item_news, null);
                holder = new NewsHolder(newsView);
                return holder;
            case VIDEO:
                View videoView = inflater.inflate(R.layout.item_video, null);
                holder = new VideoHolder(videoView);
                return holder;
            case FOOTER:
                View footerView = inflater.inflate(R.layout.view_footer, parent, false);
                footerHolder = new FooterHolder(footerView);
                return footerHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NewsHolder) {
            NewsHolder newsHolder = (NewsHolder) holder;
            SearchResult.ListEntity object = data.get(position);
            ImageLoadUtils.loadImage(context, object.getImage_url_small(), newsHolder.img);
            newsHolder.title.setText(object.getTitle());
            newsHolder.des.setText(object.getSummary());
            newsHolder.time.setText(TextUtils.getCurrentDate(object.getPublication_date()));
            newsHolder.watches.setText(TextUtils.getCurrentWatches(object.getPv()));
        } else if (holder instanceof VideoHolder) {
            VideoHolder videoHolder = (VideoHolder) holder;
            SearchResult.ListEntity object = data.get(position);
            ImageLoadUtils.loadImage(context, object.getImage_url_big(), videoHolder.img);
            videoHolder.title.setText(object.getTitle());
            videoHolder.des.setText(object.getSummary());
            videoHolder.time.setText(TextUtils.getCurrentDate(object.getPublication_date()));
            videoHolder.watches.setText(TextUtils.getCurrentWatches(object.getPv()));
        }
    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == data.size()) {
            return FOOTER;
        } else if ("视频".equals(data.get(position).getNewstype())) {
            return VIDEO;
        } else
            return NEWS;
    }

    public void addNewsData(List<SearchResult.ListEntity> data) {
        if (data == null) {
            return;
        } else {
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }


    class NewsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        @Bind(R.id.item_news_img)
        ImageView img;
        @Bind(R.id.item_news_title)
        TextView title;
        @Bind(R.id.item_news_des)
        TextView des;
        @Bind(R.id.item_news_time)
        TextView time;
        @Bind(R.id.item_news_watches)
        TextView watches;


        public NewsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            WebActivity.start(context, data.get(getAdapterPosition()).getArticle_url(), false);
        }
    }

    class VideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        @Bind(R.id.item_video_img)
        ImageView img;
        @Bind(R.id.item_video_title)
        TextView title;
        @Bind(R.id.item_video_des)
        TextView des;
        @Bind(R.id.item_video_time)
        TextView time;
        @Bind(R.id.item_video_watches)
        TextView watches;

        public VideoHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            WebActivity.start(context, data.get(getAdapterPosition()).getArticle_url(), false);
        }
    }

    class FooterHolder extends RecyclerView.ViewHolder {

        private View itemView;

        public FooterHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public void showProgress() {
            if (itemView != null) {
                itemView.setVisibility(View.VISIBLE);
            }
        }

        public void hideProgress() {
            if (itemView != null) {
                itemView.setVisibility(View.GONE);
            }
        }


    }
}
