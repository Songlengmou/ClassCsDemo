package com.android.classcsdemo.two.adapter;

import androidx.annotation.Nullable;

import com.android.classcsdemo.two.bean.TwoLeftBean;
import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;

import java.util.List;

/**
 * @author song
 */
public class TwoFirstNode extends BaseExpandNode {
    private final List<BaseNode> childNode;
    private final String title;
    private final TwoLeftBean.DataBean data;
    private boolean isSelected;

    public TwoFirstNode(List<BaseNode> childNode, String title, TwoLeftBean.DataBean data, boolean isSelected) {
        this.childNode = childNode;
        this.title = title;
        this.data = data;
        this.isSelected = isSelected;
        setExpanded(false);
    }

    public String getTitle() {
        return title;
    }

    public TwoLeftBean.DataBean getData() {
        return data;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return childNode;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
