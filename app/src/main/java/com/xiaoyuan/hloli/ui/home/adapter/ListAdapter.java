package com.xiaoyuan.hloli.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.bean.NewsList;
import com.xiaoyuan.hloli.ui.web.activity.WebActivity;
import com.xiaoyuan.hloli.utils.ImageLoadUtils;
import com.xiaoyuan.hloli.utils.TextUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/5/2.
 */
public class ListAdapter extends RecyclerView.Adapter {

    private List<NewsList.ListEntity> data = new ArrayList<>();
    private static final int NEWS = 1;
    private static final int VIDEO = 2;
    private Context context;

    public ListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
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
        if (holder instanceof NewsHolder) {
            NewsHolder newsHolder = (NewsHolder) holder;
            NewsList.ListEntity object = data.get(position);
            ImageLoadUtils.loadImage(context, object.getImage_url_small(), newsHolder.img);
            newsHolder.title.setText(object.getTitle());
            newsHolder.des.setText(object.getSummary());
            newsHolder.time.setText(TextUtils.getCurrentDate(object.getPublication_date()));
            newsHolder.watches.setText(TextUtils.getCurrentWatches(object.getPv()));
        } else if (holder instanceof VideoHolder) {
            VideoHolder videoHolder = (VideoHolder) holder;
            NewsList.ListEntity object = data.get(position);
            ImageLoadUtils.loadImage(context, object.getImage_url_big(), videoHolder.img);
            videoHolder.title.setText(object.getTitle());
            videoHolder.des.setText(object.getSummary());
            videoHolder.time.setText(TextUtils.getCurrentDate(object.getPublication_date()));
            videoHolder.watches.setText(TextUtils.getCurrentWatches(object.getPv()));
        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if ("视频".equals(data.get(position).getNewstype())) {
            return VIDEO;
        }
        return NEWS;
    }


    public void replaceNewsData(List<NewsList.ListEntity> data) {
        this.data.clear();
        if (data == null) return;
        this.data.addAll(data);
        notifyDataSetChanged();

    }

    public void addNewsData(List<NewsList.ListEntity> data) {
        if (data == null) return;
        this.data.addAll(data);
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
}
