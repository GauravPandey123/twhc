package com.twhc.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.twhc.R;
import com.twhc.resources.ProductListingRequest;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gaurav on 7/10/17.
 */

public class ProductListingActivity extends AppCompatActivity {

    @BindView(R.id.recylerViewProductListing)
    RecyclerView recylerViewProductListing;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_listing_page);
        ButterKnife.bind(this);
        setUpElements();
        setUpListeners();
    }

    private void setUpListeners() {
    }

    private void setUpElements() {
    }

    public void showProductLis() {
        ProductListingRequest productListingRequest = new ProductListingRequest();

    }


}
