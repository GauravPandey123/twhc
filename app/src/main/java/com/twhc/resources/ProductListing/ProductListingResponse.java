package com.twhc.resources.ProductListing;

import android.os.Parcel;
import android.os.Parcelable;

import com.twhc.web.BaseResponse;

import java.util.List;

/**
 * Created by Gaurav on 9/10/17.
 */

public class ProductListingResponse extends BaseResponse<ProductListingResponse>
{


    /**
     * data : [{"id":1,"parentId":null,"name":"asdf","created_at":null,"updated_at":null,"category":[{"id":2,"parentId":1,"name":"asdf2","created_at":null,"updated_at":null},{"id":3,"parentId":1,"name":"asdf3","created_at":null,"updated_at":null}]},{"id":4,"parentId":null,"name":"cat2","created_at":null,"updated_at":null,"category":[]},{"id":5,"parentId":null,"name":"cat3","created_at":null,"updated_at":null,"category":[]}]
     * paginator : {"totalCount":3,"totalPages":1,"currentPage":1,"limit":10}
     */

    private PaginatorBean paginator;
    private List<DataBean> data;

    public PaginatorBean getPaginator() {
        return paginator;
    }

    public void setPaginator(PaginatorBean paginator) {
        this.paginator = paginator;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class PaginatorBean {
        /**
         * totalCount : 3
         * totalPages : 1
         * currentPage : 1
         * limit : 10
         */

        private int totalCount;
        private int totalPages;
        private int currentPage;
        private int limit;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }
    }

    public static class DataBean {
        /**
         * id : 1
         * parentId : null
         * name : asdf
         * created_at : null
         * updated_at : null
         * category : [{"id":2,"parentId":1,"name":"asdf2","created_at":null,"updated_at":null},{"id":3,"parentId":1,"name":"asdf3","created_at":null,"updated_at":null}]
         */

        private int id;
        private Object parentId;
        private String name;
        private Object created_at;
        private Object updated_at;
        private List<CategoryBean> category;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getParentId() {
            return parentId;
        }

        public void setParentId(Object parentId) {
            this.parentId = parentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getCreated_at() {
            return created_at;
        }

        public void setCreated_at(Object created_at) {
            this.created_at = created_at;
        }

        public Object getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(Object updated_at) {
            this.updated_at = updated_at;
        }

        public List<CategoryBean> getCategory() {
            return category;
        }

        public void setCategory(List<CategoryBean> category) {
            this.category = category;
        }

        public static class CategoryBean implements Parcelable {
            /**
             * id : 2
             * parentId : 1
             * name : asdf2
             * created_at : null
             * updated_at : null
             */

            private int id;
            private int parentId;
            private String name;
            private Object created_at;
            private Object updated_at;

            protected CategoryBean(Parcel in) {
                id = in.readInt();
                parentId = in.readInt();
                name = in.readString();
            }

            public static final Creator<CategoryBean> CREATOR = new Creator<CategoryBean>() {
                @Override
                public CategoryBean createFromParcel(Parcel in) {
                    return new CategoryBean(in);
                }

                @Override
                public CategoryBean[] newArray(int size) {
                    return new CategoryBean[size];
                }
            };

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getCreated_at() {
                return created_at;
            }

            public void setCreated_at(Object created_at) {
                this.created_at = created_at;
            }

            public Object getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(Object updated_at) {
                this.updated_at = updated_at;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(id);
                parcel.writeInt(parentId);
                parcel.writeString(name);
            }
        }
    }
}
