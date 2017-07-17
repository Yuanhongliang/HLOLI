package com.xiaoyuan.hloli.ui.search.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaoyuan.hloli.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 历史记录
 * Created by yuan on 2017/5/3.
 */
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyHolder> {

    private Context context;

    public void setData(List<String> data) {
        this.data = data;
        checkDataSize();
        notifyDataSetChanged();
    }


    public List<String> getData() {
        return data;
    }

    private List<String> data = new ArrayList<>();
    private MyHolder.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(MyHolder.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public HistoryAdapter(Context context) {
        this.context = context;
        registerAdapterDataObserver(observer);
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_history, parent, false);
        return new MyHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.tv.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    RecyclerView.AdapterDataObserver observer = new RecyclerView.AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            checkDataSize();
        }
    };

    public interface DataObserver {
        void onDataChanged(boolean show);
    }

    private DataObserver dataObserver;

    public void setObserver(DataObserver observer) {
        this.dataObserver = observer;
    }

    private void checkDataSize() {
        int n = data.size();
        if (n == 0 && dataObserver != null) {
            dataObserver.onDataChanged(false);
        } else if (dataObserver != null) {
            dataObserver.onDataChanged(true);
        }
    }

    public static class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.item_history_tv)
        TextView tv;
        @Bind(R.id.item_history_del)
        ImageView del;

        public MyHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            this.onItemClickListener = onItemClickListener;
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            del.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v instanceof ImageView && onItemClickListener != null) {
                onItemClickListener.onDeleteClick(v, getLayoutPosition());
            } else if (onItemClickListener != null) {
                onItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }

        private OnItemClickListener onItemClickListener;

        public interface OnItemClickListener {

            void onItemClick(View v, int position);

            void onDeleteClick(View v, int position);
        }
    }

}
