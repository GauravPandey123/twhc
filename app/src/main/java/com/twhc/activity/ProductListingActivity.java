package com.twhc.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.twhc.R;
import com.twhc.adapter.ProductListingAdapter;
import com.twhc.resources.ProductListingRequest;
import com.twhc.resources.ProductListingResponse;
import com.twhc.resources.ProductListingService;
import com.twhc.utility.Utility;
import com.twhc.web.BaseApiCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.editsoft.api.exception.APIException;

/**
 * Created by Gaurav on 7/10/17.
 */

public class ProductListingActivity extends AppCompatActivity {

    @BindView(R.id.recylerViewProductListing)
    RecyclerView recylerViewProductListing;

    private ArrayList<ProductListingResponse.DataBean> dataBeanArrayList;
    ProductListingAdapter productListingAdapter;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_listing_page);
        context = this;
        ButterKnife.bind(this);
        setUpElements();
        setUpListeners();
    }

    private void setUpListeners() {

    }

    private void setUpElements() {
        dataBeanArrayList = new ArrayList<>();
        productListingAdapter = new ProductListingAdapter(dataBeanArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recylerViewProductListing.setLayoutManager(linearLayoutManager);
        recylerViewProductListing.computeVerticalScrollOffset();
        recylerViewProductListing.setItemAnimator(new DefaultItemAnimator());
        recylerViewProductListing.setAdapter(productListingAdapter);
        checkWebServices();
    }

    private void checkWebServices() {
        if (Utility.isConnected()) {
            showProductList();
        } else {
            Utility.showToast(R.string.internet_connection);
        }
    }

    public void showProductList() {
        ProductListingRequest productListingRequest = new ProductListingRequest();
        ProductListingService productListingService = new ProductListingService();
        productListingService.executeService(productListingRequest, new BaseApiCallback<ProductListingResponse>() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onSuccess(@NonNull ProductListingResponse response) {
                super.onSuccess(response);
                List<ProductListingResponse.DataBean> dataBeen = response.getData();
                String value = new Gson().toJson(dataBeen);
                ProductListingResponse.DataBean[] temp = new Gson().fromJson(value, ProductListingResponse.DataBean[].class);
                for (ProductListingResponse.DataBean item : temp) {
                    dataBeanArrayList.add(item);

                }
                productListingAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(APIException e) {
                super.onFailure(e);
                Utility.showToast(e.getData());

            }
        });

    }


}
