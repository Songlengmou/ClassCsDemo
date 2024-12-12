package com.android.classcsdemo.two.adapter;

import androidx.annotation.NonNull;

import com.android.classcsdemo.R;
import com.android.classcsdemo.two.bean.TwoRightSelectBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

/**
 * @author song
 */
public class TwoSelectAdapter extends BaseQuickAdapter<TwoRightSelectBean, BaseViewHolder> {
    public TwoSelectAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, TwoRightSelectBean oneRightSelectBean) {
        if (oneRightSelectBean.getSizeBean() != null) {
            baseViewHolder.setText(R.id.tv_item, oneRightSelectBean.getDataBean().getName() + "(" + oneRightSelectBean.getSizeBean().getType() + ")");
        } else {
            baseViewHolder.setText(R.id.tv_item, oneRightSelectBean.getDataBean().getName());
        }
    }
}
