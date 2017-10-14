package com.twhc.resources.EnquiryDetail;

import com.twhc.web.BaseResponse;

/**
 * Created by Gaurav on 14/10/17.
 */

public class EnquiryResponse extends BaseResponse<EnquiryResponse> {
    /**
     * data : success
     */

    private String data;


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
