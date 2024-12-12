package com.android.classcsdemo.one.adapter;

import androidx.annotation.Nullable;

import com.android.classcsdemo.one.bean.OneLeftBean;
import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;

import java.util.List;

/**
 * @author song
 */
public class OneSecondNode extends BaseExpandNode {
    private final String title;
    private final OneLeftBean.DataBean.SubListBean subListBean;

    public OneSecondNode(String title, OneLeftBean.DataBean.SubListBean subListBean) {
        this.title = title;
        this.subListBean = subListBean;
        setExpanded(false);
    }

    public String getTitle() {
        return title;
    }

    public OneLeftBean.DataBean.SubListBean getSubListBean() {
        return subListBean;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return null;
    }
}
