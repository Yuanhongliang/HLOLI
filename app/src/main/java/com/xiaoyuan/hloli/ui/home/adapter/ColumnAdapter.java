package com.xiaoyuan.hloli.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaoyuan.hloli.R;
import com.xiaoyuan.hloli.bean.ColumnList;
import com.xiaoyuan.hloli.ui.home.activity.ColumnListActivity;
import com.xiaoyuan.hloli.utils.ImageLoadUtils;
import com.xiaoyuan.hloli.utils.ShowTipUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/5/9.
 */
public class ColumnAdapter extends RecyclerView.Adapter<ColumnAdapter.ColumnHolder> {

    private List<ColumnList.ListEntity> data = new ArrayList<>();
    private Context context;

    public ColumnAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ColumnHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_column, parent, false);
        return new ColumnHolder(v);
    }

    public void addData(List<ColumnList.ListEntity> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void setData(List<ColumnList.ListEntity> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ColumnHolder holder, int position) {
        holder.title.setText(data.get(position).getCol_title());
        holder.author.setText(data.get(position).getAuthor());
        holder.des.setText(data.get(position).getCol_des());
        ImageLoadUtils.loadRoundImage(context, data.get(position).getLogo(), holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ColumnHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.item_col_img)
        ImageView img;
        @Bind(R.id.item_col_title)
        TextView title;
        @Bind(R.id.item_col_author)
        TextView author;
        @Bind(R.id.item_col_des)
        TextView des;

        public ColumnHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ColumnListActivity.startActivity(context, data.get(getAdapterPosition()));
        }
    }
}
