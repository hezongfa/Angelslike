package com.android.angelslike.ui.category;

import it.sephiroth.android.library.widget.AdapterView.OnItemClickListener;
import it.sephiroth.android.library.widget.HListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.angelslike.R;
import com.android.angelslike.bean.CategoryBean;
import com.android.angelslike.ui.product.ProductListActivity;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.hzf.adapter.BaseAdapterHelper;
import com.hzf.adapter.QuickAdapter;
import com.hzf.fragment.BaseListFragment;
import com.hzf.utils.ViewUtil;

public class PresentCategoryFragment extends BaseListFragment {
    
    QuickAdapter<String> adapter;
    ArrayList<String> arrayList;
    
    Map<String, ArrayList<CategoryBean>> map;
    
    @Override
    public void initedView() {
        // TODO Auto-generated method stub
        contentView.setBackgroundColor(getResources().getColor(R.color.lay_bg));
        listView.setMode(Mode.DISABLED);
        listView.getRefreshableView().setDivider(getResources().getDrawable(R.color.lay_bg));
        listView.getRefreshableView().setDividerHeight(ViewUtil.dip2px(baseActivity, 10));
    }
    
    @Override
    public void getData(int indexPage, int pageSize) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public BaseAdapter getAdapter() {
        // TODO Auto-generated method stub
        map = new HashMap<String, ArrayList<CategoryBean>>();
        ArrayList<CategoryBean> categoryBeans = new ArrayList<CategoryBean>();
        categoryBeans.add(new CategoryBean("送长辈", R.drawable.category_1));
        categoryBeans.add(new CategoryBean("送恋人", R.drawable.category_2));
        categoryBeans.add(new CategoryBean("送同事", R.drawable.category_3));
        categoryBeans.add(new CategoryBean("送朋友", R.drawable.category_4));
        categoryBeans.add(new CategoryBean("送老师", R.drawable.category_5));
        categoryBeans.add(new CategoryBean("送儿童", R.drawable.category_6));
        categoryBeans.add(new CategoryBean("送亲人", R.drawable.category_7));
        categoryBeans.add(new CategoryBean("送嘉宾", R.drawable.category_8));
        map.put("对象", categoryBeans);
        ArrayList<CategoryBean> categoryBeans1 = new ArrayList<CategoryBean>();
        categoryBeans1.add(new CategoryBean("亲情礼", R.drawable.category_7));
        categoryBeans1.add(new CategoryBean("爱情礼", R.drawable.category_2));
        categoryBeans1.add(new CategoryBean("人情礼", R.drawable.category_8));
        categoryBeans1.add(new CategoryBean("生日礼", R.drawable.category_9));
        categoryBeans1.add(new CategoryBean("婚庆礼", R.drawable.category_10));
        categoryBeans1.add(new CategoryBean("节日礼", R.drawable.category_11));
        map.put("场合", categoryBeans1);
        ArrayList<CategoryBean> categoryBeans2 = new ArrayList<CategoryBean>();
        categoryBeans2.add(new CategoryBean("￥50以下", R.drawable.p1));
        categoryBeans2.add(new CategoryBean("￥50-200", R.drawable.p2));
        categoryBeans2.add(new CategoryBean("￥200-500", R.drawable.p3));
        categoryBeans2.add(new CategoryBean("￥500-1000", R.drawable.p4));
        categoryBeans2.add(new CategoryBean("￥1000以上", R.drawable.p5));
        map.put("价格", categoryBeans2);
        ArrayList<CategoryBean> categoryBeans3 = new ArrayList<CategoryBean>();
        categoryBeans3.add(new CategoryBean("高逼格", R.drawable.category_12));
        categoryBeans3.add(new CategoryBean("清新美物", R.drawable.category_2));
        categoryBeans3.add(new CategoryBean("整蛊搞笑", R.drawable.category_4));
        categoryBeans3.add(new CategoryBean("科技范", R.drawable.category_13));
        categoryBeans3.add(new CategoryBean("低调宅", R.drawable.category_7));
        categoryBeans3.add(new CategoryBean("中国风", R.drawable.category_14));
        categoryBeans3.add(new CategoryBean("文化范", R.drawable.category_3));
        map.put("个性", categoryBeans3);
        ArrayList<CategoryBean> categoryBeans4 = new ArrayList<CategoryBean>();
        categoryBeans4.add(new CategoryBean("生活用品", R.drawable.category_15));
        categoryBeans4.add(new CategoryBean("创意家居", R.drawable.category_7));
        categoryBeans4.add(new CategoryBean("数码电器", R.drawable.category_12));
        categoryBeans4.add(new CategoryBean("时装穿搭", R.drawable.category_16));
        categoryBeans4.add(new CategoryBean("美妆护理", R.drawable.category_17));
        categoryBeans4.add(new CategoryBean("潮流饰物", R.drawable.category_18));
        categoryBeans4.add(new CategoryBean("文体娱乐", R.drawable.category_19));
        categoryBeans4.add(new CategoryBean("健康食品", R.drawable.category_20));
        categoryBeans4.add(new CategoryBean("汽车用品", R.drawable.category_21));
        map.put("品类", categoryBeans4);
        arrayList = new ArrayList<String>();
        arrayList.add("对象");
        arrayList.add("场合");
        arrayList.add("价格");
        arrayList.add("个性");
        arrayList.add("品类");
        adapter = new QuickAdapter<String>(baseActivity, R.layout.listitem_category, arrayList) {
            
            @Override
            protected void convert(BaseAdapterHelper helper, String item) {
                // TODO Auto-generated method stub
                helper.setText(R.id.tvTitle, item);
                final HListView hlistview = helper.getView(R.id.hListview);
                hlistview.setAdapter(new QuickAdapter<CategoryBean>(baseActivity, R.layout.griditem_category,
                    map.get(item)) {
                    
                    @Override
                    protected void convert(BaseAdapterHelper helper, CategoryBean item) {
                        // TODO Auto-generated method stub
                        TextView tvItem = helper.getView(R.id.tvItem);
                        tvItem.setText(item.getTitle());
                        tvItem.setCompoundDrawablesWithIntrinsicBounds(0, item.getImgResId(), 0, 0);
                        hlistview.setOnItemClickListener(new OnItemClickListener() {
                            
                            @Override
                            public void onItemClick(it.sephiroth.android.library.widget.AdapterView<?> parent,
                                View view, int position, long id) {
                                // TODO Auto-generated method stub
                                baseActivity.pushActivity(baseActivity.getIntent(ProductListActivity.class));
                            }
                        });
                    }
                });
            }
        };
        return adapter;
    }
    
    @Override
    public void onListItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        
    }
    
    // QuickAdapter<CategoryBean> listadapter = new QuickAdapter<CategoryBean>(baseActivity, R.layout.griditem_trategy,
    // categoryBeans) {
    //
    // @Override
    // protected void convert(BaseAdapterHelper helper, CategoryBean item) {
    // // TODO Auto-generated method stub
    // TextView tvItem = helper.getView(R.id.tvItem);
    // tvItem.setText(item.getTitle());
    // tvItem.setText("sdfsdf");
    // tvItem.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_launcher, 0, 0);
    // }
    // };
}
