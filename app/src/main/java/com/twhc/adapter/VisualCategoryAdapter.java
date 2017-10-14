package com.twhc.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twhc.R;
import com.twhc.activity.ProductCategoryActivity;
import com.twhc.activity.ProductDetailActivity;
import com.twhc.activity.VisualCategoryActivity;
import com.twhc.activity.VisualDetailActivity;
import com.twhc.resources.ProductListing.ProductListingResponse;
import com.twhc.resources.VisualDetail.VisualDetailService;
import com.twhc.utility.AppConstants;

import java.util.ArrayList;

/**
 * Created by Gaurav on 14/10/17.
 */

public class VisualCategoryAdapter extends RecyclerView.Adapter<VisualCategoryAdapter.ProdutListingViewHolder> {

    public ArrayList<ProductListingResponse.DataBean> dataBeanArrayList;
    ProductListingResponse.DataBean dataBean;
    Context mContext;

    public VisualCategoryAdapter(ArrayList<ProductListingResponse.DataBean> dataBeen, Context mContext) {
        this.dataBeanArrayList = dataBeen;
        this.mContext = mContext;
    }


    @Override
    public VisualCategoryAdapter.ProdutListingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.product_listing_item, parent, false);
        return new VisualCategoryAdapter.ProdutListingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VisualCategoryAdapter.ProdutListingViewHolder holder, int position) {
        dataBean = dataBeanArrayList.get(position);
        holder.textViewProductListing.setText(dataBean.getName());

        holder.cardViewRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, VisualDetailActivity.class);
                intent.putExtra(AppConstants.PRODUCT_ID, dataBean.getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBeanArrayList.size();
    }

    public class ProdutListingViewHolder extends RecyclerView.ViewHolder {
        CardView cardViewRoot;
        TextView textViewProductListing;

        public ProdutListingViewHolder(View itemView) {
            super(itemView);
            textViewProductListing = (TextView) itemView.findViewById(R.id.textViewProductName);
            cardViewRoot = (CardView) itemView.findViewById(R.id.root);
        }
    }
}
