package com.android.classcsdemo.two.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.android.classcsdemo.R;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.Objects;

/**
 * @author song
 */
public class TwoFirstProvider extends BaseNodeProvider {
    private final Context context;

    public TwoFirstProvider(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType() {
        return 1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_first_one;
    }

    @Override
    public void convert(@NonNull BaseViewHolder helper, BaseNode data) {
        TwoFirstNode entity = (TwoFirstNode) data;
        helper.setText(R.id.title, entity.getTitle());
        helper.setImageResource(R.id.iv, R.mipmap.arrow_r);
        helper.setGone(R.id.iv, entity.getChildNode() == null || entity.getChildNode().isEmpty());
        helper.setBackgroundColor(R.id.item_good_setting_layout, ContextCompat.getColor(context, entity.isSelected() ? R.color.white : R.color.fcebc2));
        if (entity.isExpanded()) {
            helper.setImageResource(R.id.iv, R.mipmap.arrow_b);
        } else {
            helper.setImageResource(R.id.iv, R.mipmap.arrow_r);
        }
    }

    @Override
    public void onClick(@NonNull BaseViewHolder helper, @NonNull View view, BaseNode data, int position) {
        TwoFirstNode entity = (TwoFirstNode) data;
        Log.e("TAG", "two onClick: " + entity.isExpanded());
        if (entity.isExpanded()) {
            Objects.requireNonNull(getAdapter()).collapse(position);
        } else {
            Objects.requireNonNull(getAdapter()).expandAndCollapseOther(position);
        }
    }
}
