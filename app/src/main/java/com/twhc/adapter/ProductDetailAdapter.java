package com.twhc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.twhc.utility.SectionedRecyclerViewAdapter;

/**
 * Created by Gaurav on 10/10/17.
 */

public class ProductDetailAdapter extends SectionedRecyclerViewAdapter{
    @Override
    public int getSectionCount() {
        return 0;
    }

    @Override
    public int getItemCount(int section) {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, boolean header) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int section) {

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int section, int relativePosition, int absolutePosition) {

    }


}
