package com.android.classcsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.classcsdemo.one.adapter.OneFirstNode;
import com.android.classcsdemo.one.adapter.OneNodeTreeAdapter;
import com.android.classcsdemo.one.adapter.OneRightAdapter;
import com.android.classcsdemo.one.adapter.OneSecondNode;
import com.android.classcsdemo.one.adapter.OneSelectAdapter;
import com.android.classcsdemo.one.bean.OneLeftBean;
import com.android.classcsdemo.one.bean.OneRightBean;
import com.android.classcsdemo.one.bean.OneRightSelectBean;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.github.houbb.pinyin.constant.enums.PinyinStyleEnum;
import com.github.houbb.pinyin.util.PinyinHelper;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author song
 * desc:有些部分不完整，可考虑MainActivity2
 */
public class MainActivity extends AppCompatActivity {
    private String leftJson = "{\"data\":[{\"subList\":[],\"imagePath\":\"\",\"name\":\"会员商品\",\"categoryDeep\":1,\"id\":44,\"sortCode\":7,\"thirdCategoryId\":\"\"},{\"subList\":[{\"deep\":1,\"imagePath\":\"\",\"name\":\"测试11111111\",\"categoryDeep\":2,\"id\":244,\"sortCode\":1,\"is_discount\":1,\"thirdCategoryId\":\"\",\"isHide\":0},{\"deep\":1,\"imagePath\":\"\",\"name\":\"炒菜规格\",\"categoryDeep\":2,\"id\":42,\"sortCode\":1,\"is_discount\":1,\"thirdCategoryId\":\"\",\"isHide\":0},{\"deep\":1,\"imagePath\":\"\",\"name\":\"炒菜无规格\",\"categoryDeep\":2,\"id\":43,\"sortCode\":3,\"is_discount\":1,\"thirdCategoryId\":\"\",\"isHide\":0}],\"imagePath\":\"\",\"name\":\"炒菜\",\"categoryDeep\":1,\"id\":35,\"sortCode\":3,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"面食\",\"categoryDeep\":1,\"id\":36,\"sortCode\":1,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"甜食\",\"categoryDeep\":1,\"id\":37,\"sortCode\":2,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"普通套餐\",\"categoryDeep\":1,\"id\":38,\"sortCode\":4,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"组合套餐\",\"categoryDeep\":1,\"id\":39,\"sortCode\":5,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"单品批量特价\",\"categoryDeep\":1,\"id\":170,\"sortCode\":9,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"单品批量折扣\",\"categoryDeep\":1,\"id\":171,\"sortCode\":10,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"第二件折扣\",\"categoryDeep\":1,\"id\":172,\"sortCode\":11,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"单品特价\",\"categoryDeep\":1,\"id\":169,\"sortCode\":8,\"thirdCategoryId\":\"\"},{\"subList\":[{\"deep\":1,\"imagePath\":\"\",\"name\":\"贼好吃\",\"categoryDeep\":2,\"id\":232,\"sortCode\":0,\"is_discount\":1,\"thirdCategoryId\":\"\",\"isHide\":0}],\"name\":\"好吃的\",\"categoryDeep\":1,\"id\":228,\"sortCode\":16,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"饮料\",\"categoryDeep\":1,\"id\":40,\"sortCode\":6,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"小食\",\"categoryDeep\":1,\"id\":41,\"sortCode\":5,\"thirdCategoryId\":\"\"}]}\n" +
            "\n";
    private String rightJson = "{\"data\":[{\"isRecommend\":\"\",\"isAttach\":true,\"start\":1,\"description\":\"\",\"inCode\":\"111111\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":0,\"isShelf\":1,\"barCode\":\"2409140941224\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":false,\"price\":10.0,\"isSellOut\":0,\"id\":104,\"type\":\"小份\"},{\"isLock\":0,\"isDefault\":false,\"price\":20.0,\"isSellOut\":0,\"id\":103,\"type\":\"中份\"},{\"isLock\":0,\"isDefault\":true,\"price\":30.0,\"isSellOut\":0,\"id\":102,\"type\":\"大份\"}],\"name\":\"成都素三样\",\"minImagePath\":\"upload/42/菜品/2023122216330480408-成都素三样.jpg\",\"janeSearch\":\"cdssy\",\"id\":94,\"status\":0},{\"isRecommend\":\"\",\"isAttach\":true,\"start\":1,\"description\":\"\",\"inCode\":\"\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":0,\"isShelf\":1,\"barCode\":\"\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":false,\"price\":10.0,\"isSellOut\":0,\"id\":107,\"type\":\"小份\"},{\"isLock\":0,\"isDefault\":false,\"price\":20.0,\"isSellOut\":0,\"id\":106,\"type\":\"中份\"},{\"isLock\":0,\"isDefault\":true,\"price\":40.0,\"isSellOut\":0,\"id\":105,\"type\":\"大份\"}],\"name\":\"剁椒鸦片鱼尾\",\"minImagePath\":\"upload/42/菜品/2023122216330440464-剁椒鸦片鱼尾.jpg\",\"janeSearch\":\"djypyw\",\"id\":95,\"status\":0},{\"isRecommend\":\"\",\"isAttach\":true,\"start\":1,\"description\":\"\",\"inCode\":\"\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":0,\"isShelf\":1,\"barCode\":\"\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":false,\"price\":10.0,\"isSellOut\":0,\"id\":110,\"type\":\"小份\"},{\"isLock\":0,\"isDefault\":false,\"price\":20.0,\"isSellOut\":0,\"id\":109,\"type\":\"中份\"},{\"isLock\":0,\"isDefault\":true,\"price\":30.0,\"isSellOut\":0,\"id\":108,\"type\":\"大份\"}],\"name\":\"干锅牛肉鹿茸菌\",\"minImagePath\":\"upload/42/菜品/2023122216330466616-干锅牛肉鹿茸菌.jpg\",\"janeSearch\":\"ggnrlrj\",\"id\":96,\"status\":0},{\"isRecommend\":\"\",\"isAttach\":true,\"start\":1,\"description\":\"\",\"inCode\":\"\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":0,\"isShelf\":1,\"barCode\":\"\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":false,\"price\":10.0,\"isSellOut\":0,\"id\":113,\"type\":\"小份\"},{\"isLock\":0,\"isDefault\":false,\"price\":10.0,\"isSellOut\":0,\"id\":112,\"type\":\"中份\"},{\"isLock\":0,\"isDefault\":true,\"price\":10.0,\"isSellOut\":0,\"id\":111,\"type\":\"大份\"}],\"name\":\"杭式酱爆腰花\",\"minImagePath\":\"upload/42/菜品/2023122216330482023-杭式酱爆腰花.jpg\",\"janeSearch\":\"hsjbyh\",\"id\":97,\"status\":0},{\"isRecommend\":\"\",\"isAttach\":true,\"start\":1,\"description\":\"\",\"inCode\":\"\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":0,\"isShelf\":1,\"barCode\":\"\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":false,\"price\":5.0,\"isSellOut\":0,\"id\":116,\"type\":\"小份\"},{\"isLock\":0,\"isDefault\":false,\"price\":10.0,\"isSellOut\":0,\"id\":115,\"type\":\"中份\"},{\"isLock\":0,\"isDefault\":true,\"price\":20.0,\"isSellOut\":0,\"id\":114,\"type\":\"大份\"}],\"name\":\"黄飞鸿蒜香排骨\",\"minImagePath\":\"upload/42/菜品/2023122216330429850-黄飞鸿蒜香排骨.jpg\",\"janeSearch\":\"hfhsxpg\",\"id\":98,\"status\":0},{\"isRecommend\":\"\",\"isAttach\":true,\"start\":1,\"description\":\"\",\"inCode\":\"\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":0,\"isShelf\":1,\"barCode\":\"\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":false,\"price\":10.0,\"isSellOut\":0,\"id\":119,\"type\":\"小份\"},{\"isLock\":0,\"isDefault\":false,\"price\":20.0,\"isSellOut\":0,\"id\":118,\"type\":\"中份\"},{\"isLock\":0,\"isDefault\":true,\"price\":30.0,\"isSellOut\":0,\"id\":117,\"type\":\"大份\"}],\"name\":\"火爆香辣本塘鳝\",\"minImagePath\":\"upload/42/菜品/2023122216330455091-火爆香辣本塘鳝.jpg\",\"janeSearch\":\"hbxlbts\",\"id\":99,\"status\":0},{\"isRecommend\":\"\",\"isAttach\":false,\"start\":1,\"description\":\"\",\"inCode\":\"\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":1,\"isShelf\":1,\"barCode\":\"\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":\"\",\"price\":32.0,\"isSellOut\":0,\"id\":1661,\"type\":\"大\"}],\"name\":\"西红柿炒鸡蛋\",\"minImagePath\":\"/res/img/2018070414263535016-default2.png\",\"janeSearch\":\"xhscjd\",\"id\":1622,\"status\":0}],\"success\":true}\n";

    private OneSelectAdapter oneSelectAdapter;
    private OneRightAdapter oneRightAdapter;
    private OneRightAdapter searchAdapter;
    private AppCompatTextView selectTextView;
    private AppCompatEditText etSearch;
    private AppCompatButton btnConfirm;
    private RecyclerView leftRv;
    private RecyclerView rightRv;
    private RecyclerView searchRv;
    private boolean isShow = false;
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        selectTextView = findViewById(R.id.have_selected);
        leftRv = findViewById(R.id.left_rv);
        rightRv = findViewById(R.id.right_rv);
        searchRv = findViewById(R.id.search_re);
        btnConfirm = findViewById(R.id.btn_confirm);

        OneLeftBean oneLeftBean = new Gson().fromJson(leftJson, OneLeftBean.class);
        OneRightBean oneRightBean = new Gson().fromJson(rightJson, OneRightBean.class);

        OneNodeTreeAdapter oneNodeTreeAdapter = new OneNodeTreeAdapter();
        //左侧
        leftRv.setAdapter(oneNodeTreeAdapter);
        leftRv.setLayoutManager(new LinearLayoutManager(this));
        //左侧调用接口成功后把这行放入
        oneNodeTreeAdapter.setList(initLeftData(oneLeftBean));

        //右侧/选择
        oneRightAdapter = new OneRightAdapter(R.layout.item_right_one);
        rightRv.setAdapter(oneRightAdapter);
        rightRv.setLayoutManager(new LinearLayoutManager(this));
        rightRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        //搜索
        searchAdapter = new OneRightAdapter(R.layout.item_right_one);
        searchRv.setAdapter(searchAdapter);
        searchRv.setLayoutManager(new LinearLayoutManager(this));
        searchRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        oneNodeTreeAdapter.setOnItemClickListener((adapter, view, position) -> {
            BaseNode item = (BaseNode) adapter.getItem(position);
            if (item instanceof OneFirstNode) {
                OneFirstNode oneFirstNode = (OneFirstNode) item;
                if (oneFirstNode.isExpanded()) {
                    oneNodeTreeAdapter.collapse(position);
                } else {
                    oneNodeTreeAdapter.expandAndCollapseOther(position);
                }
            }
            if (item instanceof OneSecondNode) {
                OneSecondNode oneSecondNode = (OneSecondNode) item;
                OneLeftBean.DataBean.SubListBean subListBean = oneSecondNode.getSubListBean();
                int subListBeanId = subListBean.getId();
                // TODO: 调用接口查询右侧

            }
        });
        searchAdapter.setOnItemClickListener((adapter, view, position) -> {
            OneRightSelectBean oneRightSelectBean = searchAdapter.getData().get(position);
            oneRightSelectBean.setSelect(!oneRightSelectBean.isSelect());
            adapter.notifyItemChanged(position);
            //搜索到的商品是已选中的
            if (!oneRightSelectBean.isSelect()) {
                int index = -1;
                //取消右侧选中的商品
                for (int i = 0; i < oneRightAdapter.getData().size(); i++) {
                    OneRightSelectBean selectBean = oneRightAdapter.getData().get(i);
                    if (selectBean.getSizeBean().getId() == oneRightSelectBean.getSizeBean().getId()) {
                        selectBean.setSelect(false);
                        index = i;
                        break;
                    }
                }
                if (index != -1) {
                    oneRightAdapter.notifyItemChanged(index);
                }
                int selectedIndex = -1;
                for (int i = 0; i < oneSelectAdapter.getData().size(); i++) {
                    OneRightSelectBean selectBean = oneSelectAdapter.getData().get(i);
                    if (selectBean.getSizeBean().getId() == oneRightSelectBean.getSizeBean().getId()) {
                        selectedIndex = i;
                        break;
                    }
                }
                Log.e("TAG", "onItemClick: " + selectedIndex);
                if (selectedIndex != -1) {
                    oneSelectAdapter.removeAt(selectedIndex);
                }
            } else {
                //搜索的商品是未选中的，现在选中了
                int index = -1;
                //取消右侧选中的商品
                List<OneRightSelectBean> data = oneRightAdapter.getData();
                for (int i = 0; i < data.size(); i++) {
                    OneRightSelectBean selectBean = data.get(i);
                    if (selectBean.getSizeBean().getId() == oneRightSelectBean.getSizeBean().getId()) {
                        selectBean.setSelect(true);
                        index = i;
                        break;
                    }
                }
                Log.e("TAG", "onItemClick-index: " + index);
                if (index != -1) {
                    oneRightAdapter.notifyItemChanged(index);
                }
                oneSelectAdapter.addData(oneRightSelectBean);
            }
            setBgColor();
            selectTextView.setText("已选商品" + (oneSelectAdapter.getData().size() == 0 ? ":" : "(" + oneSelectAdapter.getData().size() + "):"));
        });
        oneRightAdapter.setOnItemClickListener((adapter, view, position) -> {
            OneRightSelectBean oneRightSelectBean = oneRightAdapter.getData().get(position);
            oneRightSelectBean.setSelect(!oneRightSelectBean.isSelect());
            adapter.notifyItemChanged(position);
            List<OneRightSelectBean> selectList = new ArrayList<>();
            for (OneRightSelectBean selectBean : oneRightAdapter.getData()) {
                if (selectBean.isSelect()) {
                    selectList.add(selectBean);
                }
            }
            selectTextView.setText("已选商品" + (selectList.size() == 0 ? ":" : "(" + selectList.size() + "):"));
            oneSelectAdapter.setList(selectList);
            setBgColor();
        });
        initSelectedData();
        initRight(oneRightBean, oneRightAdapter);
        Log.e("TAG", "onCreate:1 " + PinyinHelper.toPinyin("测试", PinyinStyleEnum.NORMAL).replace(" ", ""));

        etSearch = findViewById(R.id.et_search);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                handler.removeCallbacks(searchRunnable);
                handler.postDelayed(searchRunnable, 500);
            }
        });

        btnConfirm.setOnClickListener(view -> {
            if (isShow) {
                List<OneRightSelectBean> selectBeans = oneSelectAdapter.getData();
                for (OneRightSelectBean selectBean : selectBeans) {
                    Log.e("TAG", "name: " + selectBean.getDataBean().getName());
                    Log.e("TAG", "id: " + selectBean.getSizeBean().getId() + " type: " + selectBean.getSizeBean().getType());
                }
            } else {
                Toast.makeText(this, "未选择不可点击", Toast.LENGTH_SHORT).show();
            }
        });
        setBgColor();
    }

    private final Runnable searchRunnable = new Runnable() {
        @Override
        public void run() {
            Log.e("TAG", "run: " + Thread.currentThread().getName());
            String searchContent = etSearch.getText().toString().trim();
            Log.e("TAG", "run: " + searchContent);
            Log.e("TAG", "run: " + (!TextUtils.isEmpty(searchContent)));
            if (!TextUtils.isEmpty(searchContent)) {
                searchRv.setVisibility(View.VISIBLE);
                rightRv.setVisibility(View.GONE);
                List searchList = new ArrayList();
                for (OneRightSelectBean datum : oneRightAdapter.getData()) {
                    String pinyin = PinyinHelper.toPinyin(datum.getDataBean().getName(), PinyinStyleEnum.NORMAL).replace(" ", "");
                    if (searchContent.length() == 1) {
                        if (pinyin.startsWith(searchContent)) {
                            searchList.add(datum);
                        }
                    } else {
                        if (pinyin.contains(searchContent)) {
                            searchList.add(datum);
                        }
                    }
                }
                Log.e("TAG1", "run: " + searchList.size());
                searchAdapter.setList(searchList);
            } else {
                rightRv.setVisibility(View.VISIBLE);
                searchRv.setVisibility(View.GONE);
            }
        }
    };

//    private Runnable searchRunnable = new Runnable() {
//        @Override
//        public void run() {
//            Log.e("TAG", "run: " + Thread.currentThread().getName());
//            String searchContent = etSearch.getText().toString().trim();
//            Log.e("TAG", "run: " + searchContent);
//            Log.e("TAG", "run: " + (!TextUtils.isEmpty(searchContent)));
//            if (!TextUtils.isEmpty(searchContent)) {
//                searchRv.setVisibility(View.VISIBLE);
//                rightRv.setVisibility(View.GONE);
//                List searchList = new ArrayList();
//                for (RightSelectBean datum : rightAdapter.getData()) {
//                    String pinyin = datum.getDataBean().getJaneSearch();
//                    if (searchContent.length() == 1) {
//                        if (pinyin.startsWith(searchContent)) {
//                            searchList.add(datum);
//                        }
//                    } else {
//                        if (pinyin.contains(searchContent)) {
//                            searchList.add(datum);
//                        }
//                    }
//                }
//                Log.e("TAG1", "run: " + searchList.size());
//                searchAdapter.setList(searchList);
//            } else {
//                rightRv.setVisibility(View.VISIBLE);
//                searchRv.setVisibility(View.GONE);
//            }
//        }
//    };

    /**
     * 初始化选择列表
     */
    @SuppressLint("SetTextI18n")
    private void initSelectedData() {
        oneSelectAdapter = new OneSelectAdapter(R.layout.item_select_one);
        RecyclerView rightSelectRv = findViewById(R.id.have_selected_rv);
        rightSelectRv.setLayoutManager(new GridLayoutManager(this, 2));
        rightSelectRv.setAdapter(oneSelectAdapter);
        oneSelectAdapter.addChildClickViewIds(R.id.delete);
        oneSelectAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            OneRightSelectBean oneRightSelectBean = oneSelectAdapter.getData().get(position);
            int index = -1;
            int selectIndex = -1;
            if (oneRightSelectBean.getSizeBean() != null) {
                for (int i = 0; i < oneRightAdapter.getData().size(); i++) {
                    OneRightBean.DataBean.SizesBean sizeBean = oneRightAdapter.getData().get(i).getSizeBean();
                    if (sizeBean != null) {
                        if (sizeBean.getId() == oneRightSelectBean.getSizeBean().getId()) {
                            index = i;
                            oneRightAdapter.getData().get(i).setSelect(false);
                            break;
                        }
                    }
                }
                //搜索列表也删除
                List<OneRightSelectBean> data = searchAdapter.getData();
                if (data != null && !data.isEmpty()) {
                    for (int j = 0; j < data.size(); j++) {
                        OneRightBean.DataBean.SizesBean sizeBean = data.get(j).getSizeBean();
                        if (sizeBean != null) {
                            if (sizeBean.getId() == oneRightSelectBean.getSizeBean().getId()) {
                                selectIndex = j;
                                searchAdapter.getData().get(j).setSelect(false);
                                break;
                            }
                        }
                    }
                }
            }
            Log.e("TAG", "onItemChildClick: " + index);
            if (index != -1) {
                oneRightAdapter.notifyItemChanged(index);
            }
            if (selectIndex != -1) {
                searchAdapter.notifyItemChanged(selectIndex);
            }
            oneSelectAdapter.removeAt(position);
            setBgColor();
            selectTextView.setText("已选商品" + (oneSelectAdapter.getData().size() == 0 ? "(0):" : "(" + oneSelectAdapter.getData().size() + "):"));
        });
    }

    private void initRight(OneRightBean oneRightBean, OneRightAdapter oneRightAdapter) {
        List<OneRightSelectBean> oneRightSelectBeanList = new ArrayList<>();
        for (OneRightBean.DataBean datum : oneRightBean.getData()) {
            List<OneRightBean.DataBean.SizesBean> sizes = datum.getSizes();
            Log.e("TAG", "initRight: " + sizes.size());
            if (sizes.isEmpty()) {
                OneRightSelectBean oneRightSelectBean = new OneRightSelectBean(false, datum, null);
                oneRightSelectBeanList.add(oneRightSelectBean);
            } else {
                for (OneRightBean.DataBean.SizesBean size : sizes) {
                    OneRightSelectBean oneRightSelectBean = new OneRightSelectBean(false, datum, size);
                    oneRightSelectBeanList.add(oneRightSelectBean);
                }
            }
        }
        oneRightAdapter.setList(oneRightSelectBeanList);
    }

    private List<BaseNode> initLeftData(OneLeftBean oneLeftBean) {
        List<BaseNode> list = new ArrayList<>();
        for (OneLeftBean.DataBean leftBeanDatum : oneLeftBean.getData()) {
            List<BaseNode> secondNodeList = new ArrayList<>();
            for (OneLeftBean.DataBean.SubListBean subListBean : leftBeanDatum.getSubList()) {
                secondNodeList.add(new OneSecondNode(subListBean.getName(), subListBean));
            }
            OneFirstNode oneFirstNode = new OneFirstNode(secondNodeList, leftBeanDatum.getName(), leftBeanDatum);
            list.add(oneFirstNode);
        }
        return list;
    }

    /**
     * 设置按钮的背景颜色
     */
    private void setBgColor() {
        List<OneRightSelectBean> data = oneSelectAdapter.getData();
        if (data.isEmpty()) {
            btnConfirm.setBackgroundColor(Color.parseColor("#ff0000"));
            isShow = false;
        } else {
            btnConfirm.setBackgroundColor(Color.parseColor("#ff00ff"));
            isShow = true;
        }
    }
}