package com.android.classcsdemo.one.adapter;

import androidx.annotation.Nullable;

import com.android.classcsdemo.one.bean.OneLeftBean;
import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;

import java.util.List;

/**
 * @author song
 */
public class OneFirstNode extends BaseExpandNode {
    private final List<BaseNode> childNode;
    private final String title;
    private final OneLeftBean.DataBean data;

    public OneFirstNode(List<BaseNode> childNode, String title, OneLeftBean.DataBean data) {
        this.childNode = childNode;
        this.title = title;
        this.data = data;
        setExpanded(false);
    }

    public String getTitle() {
        return title;
    }

    public OneLeftBean.DataBean getData() {
        return data;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return childNode;
    }

}
