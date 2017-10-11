package com.twhc.resources.ProductDetail;

import com.twhc.web.BaseResponse;

import java.util.List;

/**
 * Created by Gaurav on 11/10/17.
 */

public class ProductDetailResponse extends BaseResponse<ProductDetailResponse> {


    /**
     * data : [{"id":1,"name":"Tablet","created_at":null,"updated_at":null,"products":[{"id":4,"name":"P4","description":null,"created_at":null,"updated_at":null,"pivot":{"type_id":1,"product_id":4}},{"id":6,"name":"P6","description":null,"created_at":null,"updated_at":null,"pivot":{"type_id":1,"product_id":6}}]}]
     * paginator : {"totalCount":1,"totalPages":1,"currentPage":1,"limit":10}
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
         * totalCount : 1
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
         * name : Tablet
         * created_at : null
         * updated_at : null
         * products : [{"id":4,"name":"P4","description":null,"created_at":null,"updated_at":null,"pivot":{"type_id":1,"product_id":4}},{"id":6,"name":"P6","description":null,"created_at":null,"updated_at":null,"pivot":{"type_id":1,"product_id":6}}]
         */

        private int id;
        private String name;
        private Object created_at;
        private Object updated_at;
        private List<ProductsBean> products;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class ProductsBean {
            /**
             * id : 4
             * name : P4
             * description : null
             * created_at : null
             * updated_at : null
             * pivot : {"type_id":1,"product_id":4}
             */

            private int id;
            private String name;
            private Object description;
            private Object created_at;
            private Object updated_at;
            private PivotBean pivot;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
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

            public PivotBean getPivot() {
                return pivot;
            }

            public void setPivot(PivotBean pivot) {
                this.pivot = pivot;
            }

            public static class PivotBean {
                /**
                 * type_id : 1
                 * product_id : 4
                 */

                private int type_id;
                private int product_id;

                public int getType_id() {
                    return type_id;
                }

                public void setType_id(int type_id) {
                    this.type_id = type_id;
                }

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
                }
            }
        }
    }
}
