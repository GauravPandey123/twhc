package com.twhc.resources.VisualDetail;

import com.twhc.web.BaseResponse;

import java.util.List;

/**
 * Created by Gaurav on 14/10/17.
 */

public class VisualDetailResponse extends BaseResponse<VisualDetailResponse> {


    /**
     * data : [{"id":2,"name":"Cream","created_at":null,"updated_at":null,"products":[{"id":2,"name":"Clin-n-gel","Composition":"Clin Damyacil gel","packing":"20 GM","price":"140","created_at":null,"updated_at":null,"pivot":{"type_id":2,"product_id":2},"images":[{"id":4,"type":"PRODUCT","name":"4.png","key":"4.png","imageUrl":"http://localhost","pivot":{"product_id":2,"file_id":4}}]},{"id":5,"name":"Clin-n-gel","Composition":"Clin Damyacil gel","packing":"10*10","price":"20 GM","created_at":null,"updated_at":null,"pivot":{"type_id":2,"product_id":5},"images":[{"id":1,"type":"PRODUCT","name":"1.png","key":"1.png","imageUrl":"http://localhost","pivot":{"product_id":5,"file_id":1}}]},{"id":6,"name":"Acibo Tab","Composition":"Aciclobir tablets","packing":"10*10","price":"20 GM","created_at":null,"updated_at":null,"pivot":{"type_id":2,"product_id":6},"images":[]}]}]
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
         * id : 2
         * name : Cream
         * created_at : null
         * updated_at : null
         * products : [{"id":2,"name":"Clin-n-gel","Composition":"Clin Damyacil gel","packing":"20 GM","price":"140","created_at":null,"updated_at":null,"pivot":{"type_id":2,"product_id":2},"images":[{"id":4,"type":"PRODUCT","name":"4.png","key":"4.png","imageUrl":"http://localhost","pivot":{"product_id":2,"file_id":4}}]},{"id":5,"name":"Clin-n-gel","Composition":"Clin Damyacil gel","packing":"10*10","price":"20 GM","created_at":null,"updated_at":null,"pivot":{"type_id":2,"product_id":5},"images":[{"id":1,"type":"PRODUCT","name":"1.png","key":"1.png","imageUrl":"http://localhost","pivot":{"product_id":5,"file_id":1}}]},{"id":6,"name":"Acibo Tab","Composition":"Aciclobir tablets","packing":"10*10","price":"20 GM","created_at":null,"updated_at":null,"pivot":{"type_id":2,"product_id":6},"images":[]}]
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
             * id : 2
             * name : Clin-n-gel
             * Composition : Clin Damyacil gel
             * packing : 20 GM
             * price : 140
             * created_at : null
             * updated_at : null
             * pivot : {"type_id":2,"product_id":2}
             * images : [{"id":4,"type":"PRODUCT","name":"4.png","key":"4.png","imageUrl":"http://localhost","pivot":{"product_id":2,"file_id":4}}]
             */

            private int id;
            private String name;
            private String Composition;
            private String packing;
            private String price;
            private Object created_at;
            private Object updated_at;
            private PivotBean pivot;
            private List<ImagesBean> images;

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

            public String getComposition() {
                return Composition;
            }

            public void setComposition(String Composition) {
                this.Composition = Composition;
            }

            public String getPacking() {
                return packing;
            }

            public void setPacking(String packing) {
                this.packing = packing;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
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

            public List<ImagesBean> getImages() {
                return images;
            }

            public void setImages(List<ImagesBean> images) {
                this.images = images;
            }

            public static class PivotBean {
                /**
                 * type_id : 2
                 * product_id : 2
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

            public static class ImagesBean {
                /**
                 * id : 4
                 * type : PRODUCT
                 * name : 4.png
                 * key : 4.png
                 * imageUrl : http://localhost
                 * pivot : {"product_id":2,"file_id":4}
                 */

                private int id;
                private String type;
                private String name;
                private String key;
                private String imageUrl;
                private PivotBeanX pivot;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public String getImageUrl() {
                    return imageUrl;
                }

                public void setImageUrl(String imageUrl) {
                    this.imageUrl = imageUrl;
                }

                public PivotBeanX getPivot() {
                    return pivot;
                }

                public void setPivot(PivotBeanX pivot) {
                    this.pivot = pivot;
                }

                public static class PivotBeanX {
                    /**
                     * product_id : 2
                     * file_id : 4
                     */

                    private int product_id;
                    private int file_id;

                    public int getProduct_id() {
                        return product_id;
                    }

                    public void setProduct_id(int product_id) {
                        this.product_id = product_id;
                    }

                    public int getFile_id() {
                        return file_id;
                    }

                    public void setFile_id(int file_id) {
                        this.file_id = file_id;
                    }
                }
            }
        }
    }
}
