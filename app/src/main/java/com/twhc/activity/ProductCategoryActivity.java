package com.twhc.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.twhc.R;
import com.twhc.adapter.ProductCategoryAdapter;
import com.twhc.resources.ProductListing.ProductListingRequest;
import com.twhc.resources.ProductListing.ProductListingResponse;
import com.twhc.resources.ProductListing.ProductListingService;
import com.twhc.utility.Utility;
import com.twhc.web.BaseApiCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.editsoft.api.exception.APIException;

/**
 * Created by Gaurav on 11/10/17.
 */

public class ProductCategoryActivity extends BaseActivity {

    @BindView(R.id.product_category)
    RecyclerView productCategory;
    @BindView(R.id.swipe_rerfresh_layout_category)
    SwipeRefreshLayout swipeRerfreshLayoutCategory;


    ProductCategoryAdapter productCategoryAdapter;
    Context mContext;
    public ArrayList<ProductListingResponse.DataBean.CategoryBean> dataBeanArrayList = new ArrayList<>();
    @BindView(R.id.imageViewBack)
    ImageView imageViewBack;
    @BindView(R.id.textViewTitle)
    TextView textViewTitle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_category);
        mContext = this;
        ButterKnife.bind(this);
        initializations();
        setUpElements();
        setUpListeners();
    }

    private void setUpListeners() {
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void setUpElements() {
    }

    private void initializations() {
        dataBeanArrayList = new ArrayList<>();
        productCategoryAdapter = new ProductCategoryAdapter(this, dataBeanArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        productCategory.setLayoutManager(linearLayoutManager);
        productCategory.computeVerticalScrollOffset();
        productCategory.setItemAnimator(new DefaultItemAnimator());
        productCategory.setAdapter(productCategoryAdapter);
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
        showProgress();
        ProductListingRequest productListingRequest = new ProductListingRequest();
        ProductListingService productListingService = new ProductListingService();
        productListingService.executeService(productListingRequest, new BaseApiCallback<ProductListingResponse>() {
            @Override
            public void onComplete() {
                dismissProgress();
            }

            @Override
            public void onSuccess(@NonNull ProductListingResponse response) {
                super.onSuccess(response);
                List<ProductListingResponse.DataBean.CategoryBean> dataBeen = response.getData().get(0).getCategory();
                String value = new Gson().toJson(dataBeen);
                ProductListingResponse.DataBean.CategoryBean[] temp = new Gson().fromJson(value, ProductListingResponse.DataBean.CategoryBean[].class);
                Collections.addAll(dataBeanArrayList, temp);
                productCategoryAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(APIException e) {
                super.onFailure(e);
                Utility.showToast(e.getData());

            }
        });

    }


}
