package com.twhc.resources;

import com.twhc.web.BaseService;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Gaurav on 9/10/17.
 */

public class ProductListingService extends BaseService<>{






    public interface productListingService
    {
        @GET("category")
        Call<ProductListingResponse>
    }
}
