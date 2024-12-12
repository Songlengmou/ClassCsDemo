package com.android.classcsdemo.one.bean;

/**
 * @author song
 */
public class OneRightSelectBean {
    private boolean isSelect;
    private OneRightBean.DataBean dataBean;
    private OneRightBean.DataBean.SizesBean sizeBean;

    public OneRightSelectBean(boolean isSelect, OneRightBean.DataBean dataBean, OneRightBean.DataBean.SizesBean sizeBean) {
        this.isSelect = isSelect;
        this.dataBean = dataBean;
        this.sizeBean = sizeBean;
    }

    public OneRightBean.DataBean getDataBean() {
        return dataBean;
    }

    public void setDataBean(OneRightBean.DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public OneRightBean.DataBean.SizesBean getSizeBean() {
        return sizeBean;
    }

    public void setSizeBean(OneRightBean.DataBean.SizesBean sizeBean) {
        this.sizeBean = sizeBean;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
