package com.twhc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.twhc.R;
import com.twhc.adapter.ProductListingAdapter;
import com.twhc.adapter.VisualDetailAdapter;
import com.twhc.resources.ProductListing.ProductListingResponse;
import com.twhc.resources.VisualDetail.VisualDetailRequest;
import com.twhc.resources.VisualDetail.VisualDetailResponse;
import com.twhc.resources.VisualDetail.VisualDetailService;
import com.twhc.utility.AppConstants;
import com.twhc.utility.Utility;
import com.twhc.web.BaseApiCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.editsoft.api.exception.APIException;

/**
 * Created by Gaurav on 14/10/17.
 */

public class VisualDetailActivity extends BaseActivity {


    @BindView(R.id.imageViewBack)
    ImageView imageViewBack;
    @BindView(R.id.textViewTitle)
    TextView textViewTitle;
    @BindView(R.id.visual_detail_recyclerview)
    RecyclerView visualDetailRecyclerview;
    @BindView(R.id.swipe_rerfresh_visual)
    SwipeRefreshLayout swipeRerfreshVisual;
    int productId;
    Intent intent;
    VisualDetailAdapter visualDetailAdapter;
    private ArrayList<VisualDetailResponse.DataBean> dataBeanArrayList;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visual_detail_activity);
        context = this;
        ButterKnife.bind(this);
        initialization();
        setupElements();
        setUpListeners();
    }

    private void setUpListeners() {
        swipeRerfreshVisual.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                dataBeanArrayList.clear();
                visualDetailAdapter.notifyDataSetChanged();
                VisualListing();
            }
        });
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setupElements() {
        dataBeanArrayList = new ArrayList<>();
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        visualDetailAdapter = new VisualDetailAdapter(context, dataBeanArrayList);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(context, 2);
        visualDetailRecyclerview.setLayoutManager(linearLayoutManager);
        visualDetailRecyclerview.computeVerticalScrollOffset();
        visualDetailRecyclerview.setItemAnimator(new DefaultItemAnimator());
        visualDetailRecyclerview.setAdapter(visualDetailAdapter);
        checkWebServices();
    }

    private void initialization() {
        dataBeanArrayList = new ArrayList<>();
        intent = getIntent();
        productId = intent.getIntExtra(AppConstants.PRODUCT_ID, 0);
        textViewTitle.setText("Visual Detail");


    }

    private void checkWebServices() {
        if (Utility.isConnected()) {
            VisualListing();
        } else {
            Utility.showToast(R.string.internet_connection);
        }
    }

    public void VisualListing() {
        showProgress();
        VisualDetailRequest visualDetailRequest = new VisualDetailRequest();
        visualDetailRequest.setCategoryId(productId);
        VisualDetailService visualDetailService = new VisualDetailService();
        visualDetailService.executeService(visualDetailRequest, new BaseApiCallback<VisualDetailResponse>() {
            @Override
            public void onComplete() {
                swipeRerfreshVisual.setRefreshing(false);
                dismissProgress();
            }

            @Override
            public void onSuccess(@NonNull VisualDetailResponse response) {
                super.onSuccess(response);
                List<VisualDetailResponse.DataBean> dataBeen = response.getData();
                String value = new Gson().toJson(dataBeen);
                VisualDetailResponse.DataBean[] temp = new Gson().fromJson(value, VisualDetailResponse.DataBean[].class);
                for (VisualDetailResponse.DataBean item : temp) {
                    dataBeanArrayList.add(item);

                }
                visualDetailAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(APIException e) {
                super.onFailure(e);
                Utility.showToast(e.getData());
            }
        });
    }


}
