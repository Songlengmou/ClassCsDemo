package com.android.classcsdemo.one.bean;

import java.util.List;

/**
 * @author song
 */
public class OneLeftBean {

    /**
     * subList : [{"deep":1,"imagePath":"","name":"测试11111111","categoryDeep":2,"id":244,"sortCode":1,"is_discount":1,"thirdCategoryId":"","isHide":0},{"deep":1,"imagePath":"","name":"炒菜规格","categoryDeep":2,"id":42,"sortCode":1,"is_discount":1,"thirdCategoryId":"","isHide":0},{"deep":1,"imagePath":"","name":"炒菜无规格","categoryDeep":2,"id":43,"sortCode":3,"is_discount":1,"thirdCategoryId":"","isHide":0}]
     * imagePath :
     * name : 炒菜
     * categoryDeep : 1
     * id : 35
     * sortCode : 3
     * thirdCategoryId :
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String imagePath;
        private String name;
        private int categoryDeep;
        private int id;
        private int sortCode;
        private String thirdCategoryId;
        /**
         * deep : 1
         * imagePath :
         * name : 测试11111111
         * categoryDeep : 2
         * id : 244
         * sortCode : 1
         * is_discount : 1
         * thirdCategoryId :
         * isHide : 0
         */

        private List<SubListBean> subList;

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCategoryDeep() {
            return categoryDeep;
        }

        public void setCategoryDeep(int categoryDeep) {
            this.categoryDeep = categoryDeep;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSortCode() {
            return sortCode;
        }

        public void setSortCode(int sortCode) {
            this.sortCode = sortCode;
        }

        public String getThirdCategoryId() {
            return thirdCategoryId;
        }

        public void setThirdCategoryId(String thirdCategoryId) {
            this.thirdCategoryId = thirdCategoryId;
        }

        public List<SubListBean> getSubList() {
            return subList;
        }

        public void setSubList(List<SubListBean> subList) {
            this.subList = subList;
        }

        public static class SubListBean {
            private int deep;
            private String imagePath;
            private String name;
            private int categoryDeep;
            private int id;
            private int sortCode;
            private int is_discount;
            private String thirdCategoryId;
            private int isHide;

            public int getDeep() {
                return deep;
            }

            public void setDeep(int deep) {
                this.deep = deep;
            }

            public String getImagePath() {
                return imagePath;
            }

            public void setImagePath(String imagePath) {
                this.imagePath = imagePath;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getCategoryDeep() {
                return categoryDeep;
            }

            public void setCategoryDeep(int categoryDeep) {
                this.categoryDeep = categoryDeep;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSortCode() {
                return sortCode;
            }

            public void setSortCode(int sortCode) {
                this.sortCode = sortCode;
            }

            public int getIs_discount() {
                return is_discount;
            }

            public void setIs_discount(int is_discount) {
                this.is_discount = is_discount;
            }

            public String getThirdCategoryId() {
                return thirdCategoryId;
            }

            public void setThirdCategoryId(String thirdCategoryId) {
                this.thirdCategoryId = thirdCategoryId;
            }

            public int getIsHide() {
                return isHide;
            }

            public void setIsHide(int isHide) {
                this.isHide = isHide;
            }
        }
    }
}
