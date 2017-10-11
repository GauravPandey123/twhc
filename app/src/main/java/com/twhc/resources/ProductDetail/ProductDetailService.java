package com.twhc.resources.ProductDetail;

import com.twhc.web.BaseService;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Gaurav on 11/10/17.
 */

public class ProductDetailService extends BaseService<ProductDetailService.ProductDetail, ProductDetailRequest, ProductDetailResponse> {


    @Override
    public Call<ProductDetailResponse> onExecute(ProductDetail api, ProductDetailRequest request) {
        return api.productDetailResponseCall(request.getCategoryId());
    }

    @Override
    public Class<ProductDetail> getAPI() {
        return ProductDetail.class;
    }

    public interface ProductDetail {
        @GET("type-products")
        Call<ProductDetailResponse> productDetailResponseCall(@Query("categoryId") int categoryId);
    }
}
