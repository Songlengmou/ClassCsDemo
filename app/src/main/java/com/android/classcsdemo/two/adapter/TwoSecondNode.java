package com.android.classcsdemo.two.adapter;

import androidx.annotation.Nullable;

import com.android.classcsdemo.two.bean.TwoLeftBean;
import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;

import java.util.List;

/**
 * @author song
 */
public class TwoSecondNode extends BaseExpandNode {
    private final String title;
    private final TwoLeftBean.DataBean.SubListBean subListBean;
    private boolean isSelected;

    public TwoSecondNode(String title, TwoLeftBean.DataBean.SubListBean subListBean, boolean isSelected) {
        this.title = title;
        this.subListBean = subListBean;
        this.isSelected = isSelected;
        setExpanded(false);
    }

    public String getTitle() {
        return title;
    }

    public TwoLeftBean.DataBean.SubListBean getSubListBean() {
        return subListBean;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return null;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
