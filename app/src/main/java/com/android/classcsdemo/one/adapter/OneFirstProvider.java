package com.android.classcsdemo.one.adapter;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.android.classcsdemo.R;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.Objects;

/**
 * @author song
 */
public class OneFirstProvider extends BaseNodeProvider {

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
        OneFirstNode entity = (OneFirstNode) data;
        helper.setText(R.id.title, entity.getTitle());
        helper.setImageResource(R.id.iv, R.mipmap.arrow_r);
        assert entity.getChildNode() != null;
        helper.setGone(R.id.iv, entity.getChildNode().isEmpty());
        if (entity.isExpanded()) {
            helper.setImageResource(R.id.iv, R.mipmap.arrow_b);
        } else {
            helper.setImageResource(R.id.iv, R.mipmap.arrow_r);
        }
    }

    @Override
    public void onClick(@NonNull BaseViewHolder helper, @NonNull View view, BaseNode data, int position) {
        OneFirstNode entity = (OneFirstNode) data;
        Log.e("TAG", "onClick: " + entity.isExpanded());
        if (entity.isExpanded()) {
            Objects.requireNonNull(getAdapter()).collapse(position);
        } else {
            Objects.requireNonNull(getAdapter()).expandAndCollapseOther(position);
        }
    }
}
