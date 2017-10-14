package com.twhc.resources.EnquiryDetail;

import com.twhc.web.BaseService;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Gaurav on 14/10/17.
 */

public class EnquiryService extends BaseService<EnquiryService.Enquiry, EnquiryRequest, EnquiryResponse> {


    @Override
    public Call<EnquiryResponse> onExecute(Enquiry api, EnquiryRequest request) {
        return api.enquiryResponseCall(request);
    }

    @Override
    public Class<Enquiry> getAPI() {
        return Enquiry.class;
    }

    public interface Enquiry {
        @POST("enquiry")
        Call<EnquiryResponse> enquiryResponseCall(@Body EnquiryRequest enquiryRequest);
    }
}
