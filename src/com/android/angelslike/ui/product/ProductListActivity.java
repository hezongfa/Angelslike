package com.android.angelslike.ui.product;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.angelslike.R;
import com.android.angelslike.bean.ProductBean;
import com.android.angelslike.ui.ABaseActivity;
import com.android.angelslike.view.CategoryTopBarView;
import com.android.angelslike.view.SearchDialog;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.hzf.adapter.BaseAdapterHelper;
import com.hzf.adapter.QuickAdapter;
import com.hzf.utils.ViewUtil;

public class ProductListActivity extends ABaseActivity {
    PullToRefreshGridView gridView;
    CategoryTopBarView categoryTopBarView;
    QuickAdapter<ProductBean> adapter;
    int page = 1;
    int imgW = 0;
    int imgH = 0;
    
    @Override
    public void onCreateContentView() {
        // TODO Auto-generated method stub
        setMainContentView(R.layout.activity_productlist);
        setTitle("产品列表");
        setRightBtnImg(R.drawable.search_btn_bg);
        topBarView.hzf_rightBtn.setVisibility(View.VISIBLE);
        topBarView.hzf_rightBtn.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                SearchDialog searchDialog = new SearchDialog(context);
                searchDialog.show();
            }
        });
    }
    
    @Override
    public void onFindView() {
        // TODO Auto-generated method stub
        gridView = (PullToRefreshGridView)findViewById(R.id.gridView);
        categoryTopBarView = (CategoryTopBarView)findViewById(R.id.categoryTopBarView);
    }
    
    @Override
    public void onPostLoad() {
        // TODO Auto-generated method stub
        imgW = (ViewUtil.getScreenDM(this).widthPixels - ViewUtil.dip2px(context, 15)) / 2;
        imgH = (int)(imgW / 1.7);
        gridView.setMode(Mode.PULL_FROM_END);
        gridView.setOnRefreshListener(new OnRefreshListener2<GridView>() {
            
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                // TODO Auto-generated method stub
                page++;
                getData(page);
            }
        });
        adapter = new QuickAdapter<ProductBean>(this, R.layout.listitem_product) {
            
            @Override
            protected void convert(BaseAdapterHelper helper, ProductBean item) {
                // TODO Auto-generated method stub
                ImageView ivImg = helper.getView(R.id.ivImg);
                ivImg.setLayoutParams(new LinearLayout.LayoutParams(imgW, imgH));
            }
        };
        gridView.setAdapter(adapter);
        adapter.add(new ProductBean());
        adapter.add(new ProductBean());
        adapter.add(new ProductBean());
        adapter.add(new ProductBean());
        adapter.add(new ProductBean());
        adapter.add(new ProductBean());
        adapter.add(new ProductBean());
        adapter.add(new ProductBean());
        adapter.add(new ProductBean());
        adapter.add(new ProductBean());
        adapter.add(new ProductBean());
        adapter.add(new ProductBean());
    }
    
    private void getData(int page) {
        
    }
}
