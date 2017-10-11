package com.twhc.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.twhc.R;
import com.twhc.adapter.ProductDetailAdapter;
import com.twhc.adapter.ProductListingAdapter;
import com.twhc.resources.ProductDetail.ProductDetailRequest;
import com.twhc.resources.ProductDetail.ProductDetailResponse;
import com.twhc.resources.ProductDetail.ProductDetailService;
import com.twhc.utility.AppConstants;
import com.twhc.utility.Utility;
import com.twhc.web.BaseApiCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.editsoft.api.exception.APIException;

/**
 * Created by Gaurav on 10/10/17.
 */

public class ProductDetailActivity extends AppCompatActivity {
    @BindView(R.id.product_detail_view)
    RecyclerView productDetailView;
    @BindView(R.id.swipe_rerfresh_layout)
    SwipeRefreshLayout swipeRerfreshLayout;

    private ArrayList<ProductDetailResponse.DataBean> dataBeanArrayList;
    Context mContext;
    ProductDetailAdapter productDetailAdapter;
    int productId;
    Intent intent;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail_activity);
        mContext = this;
        ButterKnife.bind(this);
        initialization();
        setUpElement();
        setListeners();
    }

    private void setListeners() {
        swipeRerfreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                dataBeanArrayList.clear();
                productDetailAdapter.notifyDataSetChanged();
                showProductDetail();
            }
        });
    }

    public void initialization() {
        dataBeanArrayList = new ArrayList<>();
        intent =getIntent();
        productId=intent.getIntExtra(AppConstants.PRODUCT_ID,0);

    }

    private void setUpElement() {
        dataBeanArrayList = new ArrayList<>();
        productDetailAdapter = new ProductDetailAdapter(this, dataBeanArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        productDetailView.setLayoutManager(linearLayoutManager);
        productDetailView.computeVerticalScrollOffset();
        productDetailView.setItemAnimator(new DefaultItemAnimator());
        productDetailView.setAdapter(productDetailAdapter);
        checkWebServices();
    }

    private void checkWebServices() {
        if (Utility.isConnected()) {
            showProductDetail();
        } else {
            Utility.showToast(R.string.internet_connection);
        }
    }


    public void showProductDetail() {
        ProductDetailRequest productDetailRequest = new ProductDetailRequest();
        productDetailRequest.setCategoryId(7);
        ProductDetailService productDetailService = new ProductDetailService();
        productDetailService.executeService(productDetailRequest, new BaseApiCallback<ProductDetailResponse>() {
            @Override
            public void onComplete() {
                swipeRerfreshLayout.setRefreshing(false);
            }

            @Override
            public void onSuccess(@NonNull ProductDetailResponse response) {
                super.onSuccess(response);
                List<ProductDetailResponse.DataBean> dataBeen = response.getData();
                String value = new Gson().toJson(dataBeen);
                ProductDetailResponse.DataBean[] temp = new Gson().fromJson(value, ProductDetailResponse.DataBean[].class);
                Collections.addAll(dataBeanArrayList, temp);
                productDetailAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(APIException e) {
                super.onFailure(e);
                Utility.showToast(e.getData());
            }
        });
    }
}
