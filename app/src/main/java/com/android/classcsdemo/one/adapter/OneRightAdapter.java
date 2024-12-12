package com.android.classcsdemo.one.adapter;

import androidx.annotation.NonNull;

import com.android.classcsdemo.R;
import com.android.classcsdemo.one.bean.OneRightBean;
import com.android.classcsdemo.one.bean.OneRightSelectBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

/**
 * @author song
 */
public class OneRightAdapter extends BaseQuickAdapter<OneRightSelectBean, BaseViewHolder> {
    public OneRightAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, OneRightSelectBean dataBean) {
        baseViewHolder.setText(R.id.tv_title, dataBean.getDataBean().getName());
        OneRightBean.DataBean.SizesBean sizeBean = dataBean.getSizeBean();
        if (sizeBean == null) {
            baseViewHolder.setText(R.id.tv_price, "¥0.0")
                    .setText(R.id.tv_spec, "暂无规格");
        } else {
            baseViewHolder.setText(R.id.tv_price, "¥" + sizeBean.getPrice()).setText(R.id.tv_spec, sizeBean.getType());
        }
        baseViewHolder.setImageResource(R.id.image, dataBean.isSelect() ? R.mipmap.select : R.mipmap.unselect);

        //1.获取item的Position 两种方法
//        int itemPosition = getItemPosition(dataBean);
//        //2.
////        int itemPosition = getData().indexOf(dataBean);
//        notifyItemChanged(itemPosition);

    }
}
