package com.android.classcsdemo.one.bean;

import java.util.List;

/**
 * @author song
 */
public class OneRightBean {

    /**
     * data : [{"isRecommend":"","isAttach":true,"start":1,"description":"","inCode":"111111","isSellOut":0,"isBlank":false,"isPackage":false,"sortCode":0,"isShelf":1,"barCode":"2409140941224","isLock":0,"sizes":[{"isLock":0,"isDefault":false,"price":10,"isSellOut":0,"id":104,"type":"小份"},{"isLock":0,"isDefault":false,"price":20,"isSellOut":0,"id":103,"type":"中份"},{"isLock":0,"isDefault":true,"price":30,"isSellOut":0,"id":102,"type":"大份"}],"name":"成都素三样","minImagePath":"upload/42/菜品/2023122216330480408-成都素三样.jpg","janeSearch":"cdssy","id":94,"status":0},{"isRecommend":"","isAttach":true,"start":1,"description":"","inCode":"","isSellOut":0,"isBlank":false,"isPackage":false,"sortCode":0,"isShelf":1,"barCode":"","isLock":0,"sizes":[{"isLock":0,"isDefault":false,"price":10,"isSellOut":0,"id":107,"type":"小份"},{"isLock":0,"isDefault":false,"price":20,"isSellOut":0,"id":106,"type":"中份"},{"isLock":0,"isDefault":true,"price":40,"isSellOut":0,"id":105,"type":"大份"}],"name":"剁椒鸦片鱼尾","minImagePath":"upload/42/菜品/2023122216330440464-剁椒鸦片鱼尾.jpg","janeSearch":"djypyw","id":95,"status":0},{"isRecommend":"","isAttach":true,"start":1,"description":"","inCode":"","isSellOut":0,"isBlank":false,"isPackage":false,"sortCode":0,"isShelf":1,"barCode":"","isLock":0,"sizes":[{"isLock":0,"isDefault":false,"price":10,"isSellOut":0,"id":110,"type":"小份"},{"isLock":0,"isDefault":false,"price":20,"isSellOut":0,"id":109,"type":"中份"},{"isLock":0,"isDefault":true,"price":30,"isSellOut":0,"id":108,"type":"大份"}],"name":"干锅牛肉鹿茸菌","minImagePath":"upload/42/菜品/2023122216330466616-干锅牛肉鹿茸菌.jpg","janeSearch":"ggnrlrj","id":96,"status":0},{"isRecommend":"","isAttach":true,"start":1,"description":"","inCode":"","isSellOut":0,"isBlank":false,"isPackage":false,"sortCode":0,"isShelf":1,"barCode":"","isLock":0,"sizes":[{"isLock":0,"isDefault":false,"price":10,"isSellOut":0,"id":113,"type":"小份"},{"isLock":0,"isDefault":false,"price":10,"isSellOut":0,"id":112,"type":"中份"},{"isLock":0,"isDefault":true,"price":10,"isSellOut":0,"id":111,"type":"大份"}],"name":"杭式酱爆腰花","minImagePath":"upload/42/菜品/2023122216330482023-杭式酱爆腰花.jpg","janeSearch":"hsjbyh","id":97,"status":0},{"isRecommend":"","isAttach":true,"start":1,"description":"","inCode":"","isSellOut":0,"isBlank":false,"isPackage":false,"sortCode":0,"isShelf":1,"barCode":"","isLock":0,"sizes":[{"isLock":0,"isDefault":false,"price":5,"isSellOut":0,"id":116,"type":"小份"},{"isLock":0,"isDefault":false,"price":10,"isSellOut":0,"id":115,"type":"中份"},{"isLock":0,"isDefault":true,"price":20,"isSellOut":0,"id":114,"type":"大份"}],"name":"黄飞鸿蒜香排骨","minImagePath":"upload/42/菜品/2023122216330429850-黄飞鸿蒜香排骨.jpg","janeSearch":"hfhsxpg","id":98,"status":0},{"isRecommend":"","isAttach":true,"start":1,"description":"","inCode":"","isSellOut":0,"isBlank":false,"isPackage":false,"sortCode":0,"isShelf":1,"barCode":"","isLock":0,"sizes":[{"isLock":0,"isDefault":false,"price":10,"isSellOut":0,"id":119,"type":"小份"},{"isLock":0,"isDefault":false,"price":20,"isSellOut":0,"id":118,"type":"中份"},{"isLock":0,"isDefault":true,"price":30,"isSellOut":0,"id":117,"type":"大份"}],"name":"火爆香辣本塘鳝","minImagePath":"upload/42/菜品/2023122216330455091-火爆香辣本塘鳝.jpg","janeSearch":"hbxlbts","id":99,"status":0},{"isRecommend":"","isAttach":false,"start":1,"description":"","inCode":"","isSellOut":0,"isBlank":false,"isPackage":false,"sortCode":1,"isShelf":1,"barCode":"","isLock":0,"sizes":[{"isLock":0,"isDefault":"","price":32,"isSellOut":0,"id":1661,"type":"大"}],"name":"西红柿炒鸡蛋","minImagePath":"/res/img/2018070414263535016-default2.png","janeSearch":"xhscjd","id":1622,"status":0}]
     * success : true
     */

    private boolean success;
    /**
     * isRecommend :
     * isAttach : true
     * start : 1
     * description :
     * inCode : 111111
     * isSellOut : 0
     * isBlank : false
     * isPackage : false
     * sortCode : 0
     * isShelf : 1
     * barCode : 2409140941224
     * isLock : 0
     * sizes : [{"isLock":0,"isDefault":false,"price":10,"isSellOut":0,"id":104,"type":"小份"},{"isLock":0,"isDefault":false,"price":20,"isSellOut":0,"id":103,"type":"中份"},{"isLock":0,"isDefault":true,"price":30,"isSellOut":0,"id":102,"type":"大份"}]
     * name : 成都素三样
     * minImagePath : upload/42/菜品/2023122216330480408-成都素三样.jpg
     * janeSearch : cdssy
     * id : 94
     * status : 0
     */

    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String isRecommend;
        private boolean isAttach;
        private int start;
        private String description;
        private String inCode;
        private int isSellOut;
        private boolean isBlank;
        private boolean isPackage;
        private int sortCode;
        private int isShelf;
        private String barCode;
        private int isLock;
        private String name;
        private String minImagePath;
        private String janeSearch;
        private int id;
        private int status;
        /**
         * isLock : 0
         * isDefault : false
         * price : 10.0
         * isSellOut : 0
         * id : 104
         * type : 小份
         */

        private List<SizesBean> sizes;

        public String getIsRecommend() {
            return isRecommend;
        }

        public void setIsRecommend(String isRecommend) {
            this.isRecommend = isRecommend;
        }

        public boolean isIsAttach() {
            return isAttach;
        }

        public void setIsAttach(boolean isAttach) {
            this.isAttach = isAttach;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getInCode() {
            return inCode;
        }

        public void setInCode(String inCode) {
            this.inCode = inCode;
        }

        public int getIsSellOut() {
            return isSellOut;
        }

        public void setIsSellOut(int isSellOut) {
            this.isSellOut = isSellOut;
        }

        public boolean isIsBlank() {
            return isBlank;
        }

        public void setIsBlank(boolean isBlank) {
            this.isBlank = isBlank;
        }

        public boolean isIsPackage() {
            return isPackage;
        }

        public void setIsPackage(boolean isPackage) {
            this.isPackage = isPackage;
        }

        public int getSortCode() {
            return sortCode;
        }

        public void setSortCode(int sortCode) {
            this.sortCode = sortCode;
        }

        public int getIsShelf() {
            return isShelf;
        }

        public void setIsShelf(int isShelf) {
            this.isShelf = isShelf;
        }

        public String getBarCode() {
            return barCode;
        }

        public void setBarCode(String barCode) {
            this.barCode = barCode;
        }

        public int getIsLock() {
            return isLock;
        }

        public void setIsLock(int isLock) {
            this.isLock = isLock;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMinImagePath() {
            return minImagePath;
        }

        public void setMinImagePath(String minImagePath) {
            this.minImagePath = minImagePath;
        }

        public String getJaneSearch() {
            return janeSearch;
        }

        public void setJaneSearch(String janeSearch) {
            this.janeSearch = janeSearch;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public List<SizesBean> getSizes() {
            return sizes;
        }

        public void setSizes(List<SizesBean> sizes) {
            this.sizes = sizes;
        }

        public static class SizesBean {
            private int isLock;
            private boolean isDefault;
            private double price;
            private int isSellOut;
            private int id;
            private String type;

            public int getIsLock() {
                return isLock;
            }

            public void setIsLock(int isLock) {
                this.isLock = isLock;
            }

            public boolean isIsDefault() {
                return isDefault;
            }

            public void setIsDefault(boolean isDefault) {
                this.isDefault = isDefault;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getIsSellOut() {
                return isSellOut;
            }

            public void setIsSellOut(int isSellOut) {
                this.isSellOut = isSellOut;
            }

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
        }
    }
}

