package com.android.classcsdemo.two.adapter;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.classcsdemo.R;
import com.android.classcsdemo.two.bean.TwoRightBean;
import com.android.classcsdemo.two.bean.TwoRightSelectBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

/**
 * @author song
 */
public class TwoRightAdapter extends BaseQuickAdapter<TwoRightSelectBean, BaseViewHolder> {
    private selectCallBack onSelectCallBack;

    public TwoRightAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, TwoRightSelectBean dataBean) {
        baseViewHolder.setText(R.id.tv_title, dataBean.getDataBean().getName());
        TwoRightBean.DataBean.SizesBean sizeBean = dataBean.getSizeBean();
        if (sizeBean == null) {
            baseViewHolder.setText(R.id.tv_price, "¥0.0").setText(R.id.tv_spec, "");
        } else {
            baseViewHolder.setText(R.id.tv_price, "¥" + sizeBean.getPrice()).setText(R.id.tv_spec, sizeBean.getType());
        }
        baseViewHolder.setImageResource(R.id.image, dataBean.isSelect() ? R.mipmap.select : R.mipmap.unselect);
        ConstraintLayout clAll = baseViewHolder.findView(R.id.cl_all);
        assert clAll != null;
        clAll.setOnClickListener(view -> {
            dataBean.setSelect(!dataBean.isSelect());
            notifyItemChanged(getItemPosition(dataBean));
            if (onSelectCallBack != null) {
                onSelectCallBack.selectCallBack(dataBean);
            }
        });

        //1.获取item的Position 两种方法
//        int itemPosition = getItemPosition(dataBean);
//        //2.
////        int itemPosition = getData().indexOf(dataBean);
//        notifyItemChanged(itemPosition);
    }

    public interface selectCallBack {
        void selectCallBack(TwoRightSelectBean twoRightSelectBean);
    }

    public void setOnSelectCallBack(selectCallBack onSelectCallBack) {
        this.onSelectCallBack = onSelectCallBack;
    }
}
