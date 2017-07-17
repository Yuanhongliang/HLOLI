package com.xiaoyuan.hloli.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;
import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.bean.BannerList;
import com.xiaoyuan.hloli.bean.NewsList;
import com.xiaoyuan.hloli.ui.web.activity.WebActivity;
import com.xiaoyuan.hloli.utils.ImageLoadUtils;
import com.xiaoyuan.hloli.utils.TextUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 主页Adapter
 * Created by yuan on 2017/4/27.
 */
public class HomeAdapter extends RecyclerView.Adapter {


    private final Context context;
    private List<NewsList.ListEntity> data = new ArrayList<>();
    private List<BannerList.ListEntity> bannerData = new ArrayList<>();

    private static final int BANNER = 0;
    private static final int NEWS = 1;
    private static final int VIDEO = 2;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case BANNER:
                View bannerView = inflater.inflate(R.layout.item_banner, null);
                holder = new BannerHolder(bannerView);
                break;
            case NEWS:
                View newsView = inflater.inflate(R.layout.item_news, null);
                holder = new NewsHolder(newsView);
                break;
            case VIDEO:
                View videoView = inflater.inflate(R.layout.item_video, null);
                holder = new VideoHolder(videoView);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int newPosition = position - 1;
        if (holder instanceof BannerHolder) {
            BannerHolder bannerHolder = ((BannerHolder) holder);
            bannerHolder.pagerView.setAdapter(new BannerAdapter(bannerHolder.pagerView, bannerData));
        } else if (holder instanceof NewsHolder) {
            NewsHolder newsHolder = (NewsHolder) holder;
            NewsList.ListEntity object = data.get(newPosition);
            ImageLoadUtils.loadImage(context, object.getImage_url_small(), newsHolder.img);
            newsHolder.title.setText(object.getTitle());
            newsHolder.des.setText(object.getSummary());
            newsHolder.time.setText(TextUtils.getCurrentDate(object.getPublication_date()));
            newsHolder.watches.setText(TextUtils.getCurrentWatches(object.getPv()));
        } else if (holder instanceof VideoHolder) {
            VideoHolder videoHolder = (VideoHolder) holder;
            NewsList.ListEntity object = data.get(newPosition);
            ImageLoadUtils.loadImage(context, object.getImage_url_big(), videoHolder.img);
            videoHolder.title.setText(object.getTitle());
            videoHolder.des.setText(object.getSummary());
            videoHolder.time.setText(TextUtils.getCurrentDate(object.getPublication_date()));
            videoHolder.watches.setText(TextUtils.getCurrentWatches(object.getPv()));
        }
    }


    @Override
    public int getItemCount() {
        return data.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER;
        } else if ("视频".equals(data.get(position - 1).getNewstype())) {
            return VIDEO;
        }
        return NEWS;
    }


    public void replaceNewsData(List<NewsList.ListEntity> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();

    }

    public void addNewsData(List<NewsList.ListEntity> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void addBannerData(List<BannerList.ListEntity> data) {
        this.bannerData.addAll(data);
        notifyDataSetChanged();
    }


    class BannerHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.item_banner_pager)
        RollPagerView pagerView;

        public BannerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
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
            WebActivity.start(context, data.get(getAdapterPosition() - 1).getArticle_url(),false);
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
            WebActivity.start(context, data.get(getAdapterPosition() - 1).getArticle_url(),false);
        }
    }

}
