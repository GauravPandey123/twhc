package com.twhc.resources.VisualDetail;

import com.twhc.web.BaseRequest;

/**
 * Created by Gaurav on 14/10/17.
 */

public class VisualDetailRequest extends BaseRequest{
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    private int categoryId;
}
