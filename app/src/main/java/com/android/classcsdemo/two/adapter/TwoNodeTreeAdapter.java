package com.android.classcsdemo.two.adapter;

import android.content.Context;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;

import java.util.List;

/**
 * @author song
 */
public class TwoNodeTreeAdapter extends BaseNodeAdapter {

    public TwoNodeTreeAdapter(Context context) {
        addNodeProvider(new TwoFirstProvider(context));
        addNodeProvider(new TwoSecondProvider(context));
    }

    @Override
    protected int getItemType(@NonNull List<? extends BaseNode> list, int i) {
        BaseNode baseNode = list.get(i);
        if (baseNode instanceof TwoFirstNode) {
            return 1;
        } else if (baseNode instanceof TwoSecondNode) {
            return 2;
        }
        return -1;
    }
}
