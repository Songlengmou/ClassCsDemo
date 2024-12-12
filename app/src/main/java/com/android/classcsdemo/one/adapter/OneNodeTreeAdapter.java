package com.android.classcsdemo.one.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;

import java.util.List;

/**
 * @author song
 */
public class OneNodeTreeAdapter extends BaseNodeAdapter {

    public OneNodeTreeAdapter() {
        addNodeProvider(new OneFirstProvider());
        addNodeProvider(new OneSecondProvider());
    }

    @Override
    protected int getItemType(@NonNull List<? extends BaseNode> list, int i) {
        BaseNode baseNode = list.get(i);
        if (baseNode instanceof OneFirstNode) {
            return 1;
        } else if (baseNode instanceof OneSecondNode) {
            return 2;
        }
        return -1;
    }
}
