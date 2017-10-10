package com.twhc.resources;

import com.twhc.web.BaseService;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Gaurav on 9/10/17.
 */

public class ProductListingService extends BaseService<ProductListingService.productListingService, ProductListingRequest, ProductListingResponse> {


    @Override
    public Call<ProductListingResponse> onExecute(productListingService api, ProductListingRequest request) {
        return api.productlistingCall();
    }

    @Override
    public Class<productListingService> getAPI() {
        return productListingService.class;
    }

    public interface productListingService {
        @GET("category")
        Call<ProductListingResponse> productlistingCall();
    }
}
