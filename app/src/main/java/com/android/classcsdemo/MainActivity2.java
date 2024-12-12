package com.android.classcsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.classcsdemo.two.adapter.TwoFirstNode;
import com.android.classcsdemo.two.adapter.TwoNodeTreeAdapter;
import com.android.classcsdemo.two.adapter.TwoRightAdapter;
import com.android.classcsdemo.two.adapter.TwoSecondNode;
import com.android.classcsdemo.two.adapter.TwoSelectAdapter;
import com.android.classcsdemo.two.bean.TwoLeftBean;
import com.android.classcsdemo.two.bean.TwoRightBean;
import com.android.classcsdemo.two.bean.TwoRightSelectBean;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.github.houbb.pinyin.constant.enums.PinyinStyleEnum;
import com.github.houbb.pinyin.util.PinyinHelper;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author song
 * desc:优先考虑
 */
public class MainActivity2 extends AppCompatActivity {
    private String leftJson = "{\"data\":[{\"subList\":[{\"deep\":1,\"imagePath\":\"\",\"name\":\"会员测试\",\"categoryDeep\":2,\"id\":244,\"sortCode\":1,\"is_discount\":1,\"thirdCategoryId\":\"\",\"isHide\":0}],\"imagePath\":\"\",\"name\":\"会员商品\",\"categoryDeep\":1,\"id\":44,\"sortCode\":7,\"thirdCategoryId\":\"\"},{\"subList\":[{\"deep\":1,\"imagePath\":\"\",\"name\":\"测试11111111\",\"categoryDeep\":2,\"id\":244,\"sortCode\":1,\"is_discount\":1,\"thirdCategoryId\":\"\",\"isHide\":0},{\"deep\":1,\"imagePath\":\"\",\"name\":\"炒菜规格\",\"categoryDeep\":2,\"id\":42,\"sortCode\":1,\"is_discount\":1,\"thirdCategoryId\":\"\",\"isHide\":0},{\"deep\":1,\"imagePath\":\"\",\"name\":\"炒菜无规格\",\"categoryDeep\":2,\"id\":43,\"sortCode\":3,\"is_discount\":1,\"thirdCategoryId\":\"\",\"isHide\":0}],\"imagePath\":\"\",\"name\":\"炒菜\",\"categoryDeep\":1,\"id\":35,\"sortCode\":3,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"面食\",\"categoryDeep\":1,\"id\":36,\"sortCode\":1,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"甜食\",\"categoryDeep\":1,\"id\":37,\"sortCode\":2,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"普通套餐\",\"categoryDeep\":1,\"id\":38,\"sortCode\":4,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"组合套餐\",\"categoryDeep\":1,\"id\":39,\"sortCode\":5,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"单品批量特价\",\"categoryDeep\":1,\"id\":170,\"sortCode\":9,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"单品批量折扣\",\"categoryDeep\":1,\"id\":171,\"sortCode\":10,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"第二件折扣\",\"categoryDeep\":1,\"id\":172,\"sortCode\":11,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"单品特价\",\"categoryDeep\":1,\"id\":169,\"sortCode\":8,\"thirdCategoryId\":\"\"},{\"subList\":[{\"deep\":1,\"imagePath\":\"\",\"name\":\"贼好吃\",\"categoryDeep\":2,\"id\":232,\"sortCode\":0,\"is_discount\":1,\"thirdCategoryId\":\"\",\"isHide\":0}],\"name\":\"好吃的\",\"categoryDeep\":1,\"id\":228,\"sortCode\":16,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"饮料\",\"categoryDeep\":1,\"id\":40,\"sortCode\":6,\"thirdCategoryId\":\"\"},{\"subList\":[],\"imagePath\":\"\",\"name\":\"小食\",\"categoryDeep\":1,\"id\":41,\"sortCode\":5,\"thirdCategoryId\":\"\"}]}\n";
    private String rightJson = "{\"data\":[{\"isRecommend\":\"\",\"isAttach\":true,\"start\":1,\"description\":\"\",\"inCode\":\"111111\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":0,\"isShelf\":1,\"barCode\":\"2409140941224\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":false,\"price\":10.0,\"isSellOut\":0,\"id\":104,\"type\":\"小份\"},{\"isLock\":0,\"isDefault\":false,\"price\":20.0,\"isSellOut\":0,\"id\":103,\"type\":\"中份\"},{\"isLock\":0,\"isDefault\":true,\"price\":30.0,\"isSellOut\":0,\"id\":102,\"type\":\"大份\"}],\"name\":\"成都素三样\",\"minImagePath\":\"upload/42/菜品/2023122216330480408-成都素三样.jpg\",\"janeSearch\":\"cdssy\",\"id\":224,\"status\":0},{\"isRecommend\":\"\",\"isAttach\":true,\"start\":1,\"description\":\"\",\"inCode\":\"\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":0,\"isShelf\":1,\"barCode\":\"\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":false,\"price\":10.0,\"isSellOut\":0,\"id\":107,\"type\":\"小份\"},{\"isLock\":0,\"isDefault\":false,\"price\":20.0,\"isSellOut\":0,\"id\":106,\"type\":\"中份\"},{\"isLock\":0,\"isDefault\":true,\"price\":40.0,\"isSellOut\":0,\"id\":105,\"type\":\"大份\"}],\"name\":\"剁椒鸦片鱼尾\",\"minImagePath\":\"upload/42/菜品/2023122216330440464-剁椒鸦片鱼尾.jpg\",\"janeSearch\":\"djypyw\",\"id\":95,\"status\":0},{\"isRecommend\":\"\",\"isAttach\":true,\"start\":1,\"description\":\"\",\"inCode\":\"\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":0,\"isShelf\":1,\"barCode\":\"\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":false,\"price\":10.0,\"isSellOut\":0,\"id\":110,\"type\":\"小份\"},{\"isLock\":0,\"isDefault\":false,\"price\":20.0,\"isSellOut\":0,\"id\":109,\"type\":\"中份\"},{\"isLock\":0,\"isDefault\":true,\"price\":30.0,\"isSellOut\":0,\"id\":108,\"type\":\"大份\"}],\"name\":\"干锅牛肉鹿茸菌\",\"minImagePath\":\"upload/42/菜品/2023122216330466616-干锅牛肉鹿茸菌.jpg\",\"janeSearch\":\"ggnrlrj\",\"id\":36,\"status\":0},{\"isRecommend\":\"\",\"isAttach\":true,\"start\":1,\"description\":\"\",\"inCode\":\"\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":0,\"isShelf\":1,\"barCode\":\"\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":false,\"price\":10.0,\"isSellOut\":0,\"id\":113,\"type\":\"小份\"},{\"isLock\":0,\"isDefault\":false,\"price\":10.0,\"isSellOut\":0,\"id\":112,\"type\":\"中份\"},{\"isLock\":0,\"isDefault\":true,\"price\":10.0,\"isSellOut\":0,\"id\":111,\"type\":\"大份\"}],\"name\":\"杭式酱爆腰花\",\"minImagePath\":\"upload/42/菜品/2023122216330482023-杭式酱爆腰花.jpg\",\"janeSearch\":\"hsjbyh\",\"id\":43,\"status\":0},{\"isRecommend\":\"\",\"isAttach\":true,\"start\":1,\"description\":\"\",\"inCode\":\"\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":0,\"isShelf\":1,\"barCode\":\"\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":false,\"price\":5.0,\"isSellOut\":0,\"id\":116,\"type\":\"小份\"},{\"isLock\":0,\"isDefault\":false,\"price\":10.0,\"isSellOut\":0,\"id\":115,\"type\":\"中份\"},{\"isLock\":0,\"isDefault\":true,\"price\":20.0,\"isSellOut\":0,\"id\":114,\"type\":\"大份\"}],\"name\":\"黄飞鸿蒜香排骨\",\"minImagePath\":\"upload/42/菜品/2023122216330429850-黄飞鸿蒜香排骨.jpg\",\"janeSearch\":\"hfhsxpg\",\"id\":98,\"status\":0},{\"isRecommend\":\"\",\"isAttach\":true,\"start\":1,\"description\":\"\",\"inCode\":\"\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":0,\"isShelf\":1,\"barCode\":\"\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":false,\"price\":10.0,\"isSellOut\":0,\"id\":119,\"type\":\"小份\"},{\"isLock\":0,\"isDefault\":false,\"price\":20.0,\"isSellOut\":0,\"id\":118,\"type\":\"中份\"},{\"isLock\":0,\"isDefault\":true,\"price\":30.0,\"isSellOut\":0,\"id\":117,\"type\":\"大份\"}],\"name\":\"火爆香辣本塘鳝\",\"minImagePath\":\"upload/42/菜品/2023122216330455091-火爆香辣本塘鳝.jpg\",\"janeSearch\":\"hbxlbts\",\"id\":99,\"status\":0},{\"isRecommend\":\"\",\"isAttach\":false,\"start\":1,\"description\":\"\",\"inCode\":\"\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":1,\"isShelf\":1,\"barCode\":\"\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":\"\",\"price\":32.0,\"isSellOut\":0,\"id\":1661,\"type\":\"大\"}],\"name\":\"西红柿炒鸡蛋\",\"minImagePath\":\"/res/img/2018070414263535016-default2.png\",\"janeSearch\":\"xhscjd\",\"id\":1622,\"status\":0}],\"success\":true}\n";
    private String rightChildJson = "{\"data\":[{\"isRecommend\":\"\",\"isAttach\":true,\"start\":1,\"description\":\"\",\"inCode\":\"111111\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":0,\"isShelf\":1,\"barCode\":\"2409140941224\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":false,\"price\":10,\"isSellOut\":0,\"id\":104,\"type\":\"小份\"},{\"isLock\":0,\"isDefault\":false,\"price\":20,\"isSellOut\":0,\"id\":103,\"type\":\"中份\"},{\"isLock\":0,\"isDefault\":true,\"price\":30,\"isSellOut\":0,\"id\":102,\"type\":\"大份\"}],\"name\":\"成都素三样\",\"minImagePath\":\"upload/42/菜品/2023122216330480408-成都素三样.jpg\",\"janeSearch\":\"cdssy\",\"id\":224,\"status\":0},{\"isRecommend\":\"\",\"isAttach\":true,\"start\":1,\"description\":\"\",\"inCode\":\"111111\",\"isSellOut\":0,\"isBlank\":false,\"isPackage\":false,\"sortCode\":0,\"isShelf\":1,\"barCode\":\"2409140941223\",\"isLock\":0,\"sizes\":[{\"isLock\":0,\"isDefault\":false,\"price\":10,\"isSellOut\":0,\"id\":104,\"type\":\"小份\"},{\"isLock\":0,\"isDefault\":false,\"price\":20,\"isSellOut\":0,\"id\":103,\"type\":\"中份\"},{\"isLock\":0,\"isDefault\":true,\"price\":30,\"isSellOut\":0,\"id\":102,\"type\":\"大份\"}],\"name\":\"牛肉\",\"minImagePath\":\"upload/42/菜品/2023122216330480409-牛肉.jpg\",\"janeSearch\":\"cdssy\",\"id\":42,\"status\":0}],\"success\":true}\n";
    private TwoLeftBean dataLeftBean;
    private TwoRightBean dataRightBean;
    private TwoSelectAdapter selectAdapter;
    private TwoRightAdapter rightAdapter, searchAdapter;
    private AppCompatTextView tcSelect;
    private AppCompatEditText etSearch;
    private AppCompatButton btnConfirm;
    private RecyclerView rvLeft, rvRight, rvSearch;
    private boolean isShow = false;
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    @SuppressLint({"SetTextI18n", "NotifyDataSetChanged"})
    private void initView() {
        tcSelect = findViewById(R.id.have_selected);
        rvLeft = findViewById(R.id.left_rv);
        rvRight = findViewById(R.id.right_rv);
        rvSearch = findViewById(R.id.search_re);
        etSearch = findViewById(R.id.et_search);
        btnConfirm = findViewById(R.id.btn_confirm);

        dataLeftBean = new Gson().fromJson(leftJson, TwoLeftBean.class);

        //左侧
        TwoNodeTreeAdapter nodeTreeAdapter = new TwoNodeTreeAdapter(this);
        rvLeft.setAdapter(nodeTreeAdapter);
        nodeTreeAdapter.setOnItemClickListener((adapter, view, position) -> {
            BaseNode item = (BaseNode) adapter.getItem(position);
            if (item instanceof TwoFirstNode) {
                TwoFirstNode firstNode = (TwoFirstNode) item;
                if (firstNode.getChildNode() == null) {
                    nodeTreeAdapter.expandAndCollapseOther(position);
                } else {
                    if (firstNode.isExpanded()) {
                        nodeTreeAdapter.collapse(position);
                    } else {
                        nodeTreeAdapter.expandAndCollapseOther(position);
                    }
                }
                for (BaseNode datum : nodeTreeAdapter.getData()) {
                    if (datum instanceof TwoFirstNode) {
                        TwoFirstNode node = (TwoFirstNode) datum;
                        node.setSelected(false);
                        if (node.getChildNode() != null) {
                            for (BaseNode baseNode : node.getChildNode()) {
                                if (baseNode instanceof TwoSecondNode) {
                                    ((TwoSecondNode) baseNode).setSelected(false);
                                }
                            }
                        }
                    }
                }
                firstNode.setSelected(true);
                nodeTreeAdapter.notifyDataSetChanged();
                if ("全部".equals(firstNode.getTitle())) {
                    //TODO: 全部
                    qrySortGoods(0, 0);
                } else {
                    // TODO: 一级右侧
                    qrySortGoods(1, firstNode.getData().getId());
                }
            }
            if (item instanceof TwoSecondNode) {
                int parentNode = nodeTreeAdapter.findParentNode(item);
                TwoSecondNode secondNode = (TwoSecondNode) item;
                if (parentNode != -1) {
                    BaseNode baseNode = nodeTreeAdapter.getItem(parentNode);
                    if (baseNode instanceof TwoFirstNode) {
                        TwoFirstNode firstNode = (TwoFirstNode) baseNode;
                        List<BaseNode> childNode = firstNode.getChildNode();
                        for (int i = 0; i < Objects.requireNonNull(childNode).size(); i++) {
                            if (childNode.get(i) instanceof TwoSecondNode) {
                                TwoSecondNode node = (TwoSecondNode) childNode.get(i);
                                if (node.isSelected()) {
                                    node.setSelected(false);
                                    break;
                                }
                            }
                        }
                        for (BaseNode datum : nodeTreeAdapter.getData()) {
                            if (datum instanceof TwoFirstNode) {
                                ((TwoFirstNode) datum).setSelected(false);
                            }
                        }
                        firstNode.setSelected(true);
                    }
                }
                TwoLeftBean.DataBean.SubListBean subListBean = secondNode.getSubListBean();
                secondNode.setSelected(true);
                nodeTreeAdapter.notifyDataSetChanged();
                //TODO: 二级右侧
                qrySortGoods(2, subListBean.getId());
            }
        });
        //左侧调用接口成功后把这行放入
        nodeTreeAdapter.setList(initLeftData());
        //右侧/选择
        rightAdapter = new TwoRightAdapter(R.layout.item_right_one);
        rvRight.setAdapter(rightAdapter);
        rvRight.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rightAdapter.setOnSelectCallBack(rightSelectBean -> {
            //选择列表
            if (rightSelectBean.isSelect()) {
                selectAdapter.addData(rightSelectBean);
            } else {
                int index = -1;
                for (int i = 0; i < selectAdapter.getData().size(); i++) {
                    if (selectAdapter.getData().get(i).getSizeBean().getId() == rightSelectBean.getSizeBean().getId()) {
                        index = i;
                        break;
                    }
                }
                if (index != -1) {
                    selectAdapter.removeAt(index);
                }
            }
            tcSelect.setText("已选商品" + (selectAdapter.getData().isEmpty() ? ":" : "(" + selectAdapter.getData().size() + "):"));
            setBgColor();
        });

        searchAdapter = new TwoRightAdapter(R.layout.item_right_one);
        rvSearch.setAdapter(searchAdapter);
        rvSearch.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        searchAdapter.setOnSelectCallBack(rightSelectBean -> {
            //搜索到的商品是已选中的
            if (!rightSelectBean.isSelect()) {
                int index = -1;
                //取消右侧选中的商品
                for (int i = 0; i < rightAdapter.getData().size(); i++) {
                    TwoRightSelectBean selectBean = rightAdapter.getData().get(i);
                    if (selectBean.getSizeBean().getId() == rightSelectBean.getSizeBean().getId()) {
                        selectBean.setSelect(false);
                        index = i;
                        break;
                    }
                }
                if (index != -1) {
                    rightAdapter.notifyItemChanged(index);
                }
                int selectedIndex = -1;
                for (int i = 0; i < selectAdapter.getData().size(); i++) {
                    TwoRightSelectBean selectBean = selectAdapter.getData().get(i);
                    if (selectBean.getSizeBean().getId() == rightSelectBean.getSizeBean().getId()) {
                        selectedIndex = i;
                        break;
                    }
                }
                Log.e("TAG", "onItemClick: " + selectedIndex);
                if (selectedIndex != -1) {
                    selectAdapter.removeAt(selectedIndex);
                }
            } else {
                //搜索的商品是未选中的，现在选中了
                int index = -1;
                //取消右侧选中的商品
                List<TwoRightSelectBean> data = rightAdapter.getData();
                for (int i = 0; i < data.size(); i++) {
                    TwoRightSelectBean selectBean = data.get(i);
                    if (selectBean.getSizeBean().getId() == rightSelectBean.getSizeBean().getId()) {
                        selectBean.setSelect(true);
                        index = 1;
                        break;
                    }
                }
                if (index != -1) {
                    rightAdapter.notifyItemChanged(index);
                }
                selectAdapter.addData(rightSelectBean);
            }
            setBgColor();
            tcSelect.setText("已选商品" + (selectAdapter.getData().isEmpty() ? ":" : "(" + selectAdapter.getData().size() + "):"));
        });
        initSelectedData();
        //默认展示全部
        for (BaseNode datum : nodeTreeAdapter.getData()) {
            if (datum instanceof TwoFirstNode) {
                TwoFirstNode firstNode = (TwoFirstNode) datum;
                if ("全部".equals(firstNode.getTitle())) {
                    firstNode.setSelected(true);
                    // TODO: 默认展示全部
                    qrySortGoods(0, 0);
                }
            }
        }
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
                List<TwoRightSelectBean> selectBeans = selectAdapter.getData();
                for (TwoRightSelectBean selectBean : selectBeans) {
                    Log.e("TAG", "name: " + selectBean.getDataBean().getName());
                    Log.e("TAG", "id: " + selectBean.getSizeBean().getId() + " type: " + selectBean.getSizeBean().getType());
                }
            } else {
                Toast.makeText(this, "未选择不可点击", Toast.LENGTH_SHORT).show();
            }
        });
        setBgColor();
    }

    //    private Runnable searchRunnable = new Runnable() {
//        @Override
//        public void run() {
//            Log.e("TAG", "run: " + Thread.currentThread().getName());
//            String searchContent = etSearch.getText().toString().trim();
//            Log.e("TAG", "run: " + searchContent);
//            Log.e("TAG", "run: " + (!TextUtils.isEmpty(searchContent)));
//            if (!TextUtils.isEmpty(searchContent)) {
//                rvSearch.setVisibility(View.VISIBLE);
//                rvRight.setVisibility(View.GONE);
//                List<TwoRightSelectBean> searchList = new ArrayList();
//                for (TwoRightSelectBean datum : rightAdapter.getData()) {
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
//                rvRight.setVisibility(View.VISIBLE);
//                rvSearch.setVisibility(View.GONE);
//            }
//        }
//    };
    private final Runnable searchRunnable = new Runnable() {
        @Override
        public void run() {
            Log.e("TAG", "run: " + Thread.currentThread().getName());
            String searchContent = Objects.requireNonNull(etSearch.getText()).toString().trim();
            Log.e("TAG", "run: " + (!TextUtils.isEmpty(searchContent)));
            if (!TextUtils.isEmpty(searchContent)) {
                rvSearch.setVisibility(View.VISIBLE);
                rvRight.setVisibility(View.GONE);
                List<TwoRightSelectBean> searchList = new ArrayList<>();
                for (TwoRightSelectBean datum : rightAdapter.getData()) {
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
                rvRight.setVisibility(View.VISIBLE);
                rvSearch.setVisibility(View.GONE);
            }
        }
    };

    /**
     * 初始化选择列表
     */
    @SuppressLint("SetTextI18n")
    private void initSelectedData() {
        selectAdapter = new TwoSelectAdapter(R.layout.item_select_one);
        RecyclerView rightSelectRv = findViewById(R.id.have_selected_rv);
        rightSelectRv.setLayoutManager(new GridLayoutManager(this, 2));
        rightSelectRv.setAdapter(selectAdapter);
        selectAdapter.addChildClickViewIds(R.id.delete);
        selectAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            TwoRightSelectBean oneRightSelectBean = selectAdapter.getData().get(position);
            int index = -1;
            int selectIndex = -1;
            if (oneRightSelectBean.getSizeBean() != null) {
                for (int i = 0; i < rightAdapter.getData().size(); i++) {
                    TwoRightBean.DataBean.SizesBean sizeBean = rightAdapter.getData().get(i).getSizeBean();
                    if (sizeBean != null) {
                        if (sizeBean.getId() == oneRightSelectBean.getSizeBean().getId()) {
                            index = i;
                            rightAdapter.getData().get(i).setSelect(false);
                            break;
                        }
                    }
                }
                //搜索列表也删除
                List<TwoRightSelectBean> data = searchAdapter.getData();
                if (!data.isEmpty()) {
                    for (int j = 0; j < data.size(); j++) {
                        TwoRightBean.DataBean.SizesBean sizeBean = data.get(j).getSizeBean();
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
                rightAdapter.notifyItemChanged(index);
            }
            if (selectIndex != -1) {
                searchAdapter.notifyItemChanged(selectIndex);
            }
            selectAdapter.removeAt(position);
            setBgColor();
            tcSelect.setText("已选商品" + (selectAdapter.getData().size() == 0 ? "(0):" : "(" + selectAdapter.getData().size() + "):"));
        });
    }

    /**
     * 左侧列表
     */
    private List<BaseNode> initLeftData() {
        List<BaseNode> list = new ArrayList<>();
        list.add(new TwoFirstNode(null, "全部", null, false));
        for (TwoLeftBean.DataBean leftBeanDatum : dataLeftBean.getData()) {
            List<BaseNode> secondNodeList = new ArrayList<>();
            for (TwoLeftBean.DataBean.SubListBean subListBean : leftBeanDatum.getSubList()) {
                secondNodeList.add(new TwoSecondNode(subListBean.getName(), subListBean, false));
            }
            TwoFirstNode oneFirstNode = new TwoFirstNode(secondNodeList, leftBeanDatum.getName(), leftBeanDatum, false);
            list.add(oneFirstNode);
        }
        return list;
    }

    /**
     * 根据左侧选择右侧
     */
    private void qrySortGoods(int type, int id) {
        if (type == 0) {
            dataRightBean = new Gson().fromJson(rightJson, TwoRightBean.class);
        } else {
            dataRightBean = new Gson().fromJson(rightChildJson, TwoRightBean.class);
        }
        if (dataRightBean != null) {
            initRight(dataRightBean, rightAdapter);
        }
    }

    /**
     * 右侧列表
     */
    private void initRight(TwoRightBean oneRightBean, TwoRightAdapter oneRightAdapter) {
        List<TwoRightSelectBean> rightSelectBeans = new ArrayList<>();
        for (TwoRightBean.DataBean datum : oneRightBean.getData()) {
            List<TwoRightBean.DataBean.SizesBean> sizes = datum.getSizes();
            if (sizes.isEmpty()) {
                TwoRightSelectBean oneRightSelectBean = new TwoRightSelectBean(false, datum, null);
                rightSelectBeans.add(oneRightSelectBean);
            } else {
                for (TwoRightBean.DataBean.SizesBean size : sizes) {
                    TwoRightSelectBean oneRightSelectBean = new TwoRightSelectBean(false, datum, size);
                    rightSelectBeans.add(oneRightSelectBean);
                }
            }
        }
        oneRightAdapter.setList(rightSelectBeans);
    }

    /**
     * 设置按钮的背景颜色
     */
    private void setBgColor() {
        List<TwoRightSelectBean> data = selectAdapter.getData();
        if (data.isEmpty()) {
            btnConfirm.setBackgroundColor(getColor(R.color.cac8c8));
            isShow = false;
        } else {
            btnConfirm.setBackgroundColor(getColor(R.color.red));
            isShow = true;
        }
    }
}