package com.twhc.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twhc.R;
import com.twhc.resources.ProductListing.ProductListingResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gaurav on 11/10/17.
 */

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ProductCategoryViewHolder> {
    Context mContext;
    public ArrayList<ProductListingResponse.DataBean.CategoryBean> categoryBeen;
    ProductListingResponse.DataBean.CategoryBean categoryBean;


    public ProductCategoryAdapter(Context mContext, ArrayList<ProductListingResponse.DataBean.CategoryBean> categoryBeen) {
        this.mContext = mContext;
        this.categoryBeen = categoryBeen;
    }


    @Override
    public ProductCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.product_listing_item, parent, false);
        return new ProductCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductCategoryViewHolder holder, int position) {
        categoryBean=categoryBeen.get(position);
        holder.textViewProductName.setText(categoryBean.getName());
    }

    @Override
    public int getItemCount() {
        return categoryBeen.size();
    }

    public class ProductCategoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewProductName)
        TextView textViewProductName;
        @BindView(R.id.root)
        CardView root;

        public ProductCategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
