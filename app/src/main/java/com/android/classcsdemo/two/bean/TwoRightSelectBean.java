package com.android.classcsdemo.two.bean;

/**
 * @author song
 */
public class TwoRightSelectBean {
    private boolean isSelect;
    private TwoRightBean.DataBean dataBean;
    private TwoRightBean.DataBean.SizesBean sizeBean;

    public TwoRightSelectBean(boolean isSelect, TwoRightBean.DataBean dataBean, TwoRightBean.DataBean.SizesBean sizeBean) {
        this.isSelect = isSelect;
        this.dataBean = dataBean;
        this.sizeBean = sizeBean;
    }

    public TwoRightBean.DataBean getDataBean() {
        return dataBean;
    }

    public void setDataBean(TwoRightBean.DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public TwoRightBean.DataBean.SizesBean getSizeBean() {
        return sizeBean;
    }

    public void setSizeBean(TwoRightBean.DataBean.SizesBean sizeBean) {
        this.sizeBean = sizeBean;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
