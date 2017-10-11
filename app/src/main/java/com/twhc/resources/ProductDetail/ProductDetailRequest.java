package com.twhc.resources.ProductDetail;

import com.twhc.web.BaseRequest;

/**
 * Created by Gaurav on 11/10/17.
 */

public class ProductDetailRequest extends BaseRequest {

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    private int categoryId;
}
