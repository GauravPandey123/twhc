package com.twhc.resources.VisualDetail;

import com.twhc.web.BaseService;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Gaurav on 14/10/17.
 */

public class VisualDetailService extends BaseService<VisualDetailService.VisualDetail, VisualDetailRequest, VisualDetailResponse> {


    @Override
    public Call<VisualDetailResponse> onExecute(VisualDetail api, VisualDetailRequest request) {
        return api.visualDetail(request.getCategoryId());
    }

    @Override
    public Class<VisualDetail> getAPI() {
        return VisualDetail.class;
    }

    public interface VisualDetail {
        @GET("type-products-images")
        Call<VisualDetailResponse> visualDetail(@Query("categoryId") int categoryId);
    }
}
