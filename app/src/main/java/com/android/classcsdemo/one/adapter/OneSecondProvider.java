package com.android.classcsdemo.one.adapter;

import androidx.annotation.NonNull;

import com.android.classcsdemo.R;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

/**
 * @author song
 */
public class OneSecondProvider extends BaseNodeProvider {
    @Override
    public int getItemViewType() {
        return 2;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_second_one;
    }

    @Override
    public void convert(@NonNull BaseViewHolder baseViewHolder, BaseNode baseNode) {
        OneSecondNode entity = (OneSecondNode) baseNode;
        baseViewHolder.setText(R.id.title, entity.getTitle());
    }
}
