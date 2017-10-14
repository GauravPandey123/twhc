package com.twhc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.twhc.R;
import com.twhc.resources.VisualDetail.VisualDetailResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gaurav on 14/10/17.
 */

public class VisualDetailAdapter extends RecyclerView.Adapter<VisualDetailAdapter.VisualViewHolder> {

    Context context;
    public ArrayList<VisualDetailResponse.DataBean> dataBeanArrayList;
    VisualDetailResponse.DataBean dataBean;


    public VisualDetailAdapter(Context mContext, ArrayList<VisualDetailResponse.DataBean> dataBeen) {
        this.context = mContext;
        this.dataBeanArrayList = dataBeen;
    }

    @Override
    public VisualViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.visual_item, parent, false);
        return new VisualViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VisualViewHolder holder, int position) {
        dataBean = dataBeanArrayList.get(position);
        if (dataBean.getProducts().get(position).getImages() != null) {
            Picasso.with(context).load(R.drawable.about_us).into(holder.imageView);
        }
        holder.textView.setText(dataBean.getName());
    }

    @Override
    public int getItemCount() {
        return dataBeanArrayList.size();
    }

    public class VisualViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.textView)
        TextView textView;

        public VisualViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
