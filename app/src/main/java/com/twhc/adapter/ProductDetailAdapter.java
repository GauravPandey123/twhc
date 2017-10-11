package com.twhc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twhc.R;
import com.twhc.resources.ProductDetail.ProductDetailResponse;
import com.twhc.utility.SectionedRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by Gaurav on 10/10/17.
 */

public class ProductDetailAdapter extends SectionedRecyclerViewAdapter<RecyclerView.ViewHolder> {
    Context mContext;
    public ArrayList<ProductDetailResponse.DataBean> dataBeen;
    ProductDetailResponse.DataBean dataBean;

    public ProductDetailAdapter(Context mContext, ArrayList<ProductDetailResponse.DataBean> dataBeanArrayList) {
        this.mContext = mContext;
        this.dataBeen = dataBeanArrayList;
    }

    @Override
    public int getSectionCount() {
        return dataBeen.size();
    }

    @Override
    public int getItemCount(int section) {
        return dataBeen.get(section).getProducts().size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, boolean header) {
        View view = null;
        if (header) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.product_detail_header, parent, false);
            return new HeaderViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.product_detail_footer, parent, false);
            return new FooterViewHolder(view);
        }
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int section) {
        dataBean = dataBeen.get(section);
        HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
        headerViewHolder.textViewHeader.setText(dataBean.getName());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int section, int relativePosition, int absolutePosition) {
        FooterViewHolder footerViewHolder = (FooterViewHolder) holder;
        footerViewHolder.textViewFooter.setText(dataBeen.get(section).getProducts().get(section).getName());

    }


    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView textViewHeader;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            textViewHeader = (TextView) itemView.findViewById(R.id.sectionTitle);
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {
        TextView textViewFooter;

        public FooterViewHolder(View itemView) {
            super(itemView);
            textViewFooter = (TextView) itemView.findViewById(R.id.itemTitle);

        }
    }


}
