package com.android.classcsdemo.two.adapter;

import android.content.Context;

import androidx.annotation.NonNull;

import com.android.classcsdemo.R;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

/**
 * @author song
 */
public class TwoSecondProvider extends BaseNodeProvider {
    private final Context context;

    public TwoSecondProvider(Context context) {
        this.context = context;
    }

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
        TwoSecondNode entity = (TwoSecondNode) baseNode;
        baseViewHolder.setText(R.id.title, entity.getTitle())
                .setBackgroundColor(R.id.item_second_good_setting_layout, entity.isSelected() ? context.getColor(R.color.white) : context.getColor(R.color.fcebc2));
    }
}
