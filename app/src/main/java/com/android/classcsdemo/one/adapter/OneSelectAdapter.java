package com.android.classcsdemo.one.adapter;

import androidx.annotation.NonNull;

import com.android.classcsdemo.R;
import com.android.classcsdemo.one.bean.OneRightSelectBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

/**
 * @author song
 */
public class OneSelectAdapter extends BaseQuickAdapter<OneRightSelectBean, BaseViewHolder> {
    public OneSelectAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, OneRightSelectBean oneRightSelectBean) {
        if (oneRightSelectBean.getSizeBean() != null) {
            baseViewHolder.setText(R.id.tv_item, oneRightSelectBean.getDataBean().getName() + "(" + oneRightSelectBean.getSizeBean().getType() + ")");
        } else {
            baseViewHolder.setText(R.id.tv_item, oneRightSelectBean.getDataBean().getName());
        }
    }
}
