package com.android.angelslike.ui.theme;

import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.angelslike.R;
import com.android.angelslike.bean.CommodityBean;
import com.android.angelslike.bean.ThemeDetailBean;
import com.android.angelslike.utils.http.ApiClient;
import com.android.angelslike.utils.http.ApiClient.HttpCallBack;
import com.android.angelslike.utils.http.HttpConstants;
import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.hzf.adapter.BaseAdapterHelper;
import com.hzf.adapter.QuickAdapter;
import com.hzf.fragment.BaseListFragment;
import com.hzf.utils.JsonExplain;
import com.hzf.utils.ViewUtil;
import com.hzf.utils.print.FQL;

public class ThemeDetailFragment extends BaseListFragment implements OnClickListener {
    QuickAdapter<CommodityBean> adapter;
    ImageView ivDc;
    int screenW = 0;
    TextView tvContent, tvFavou, tvComment, tvShare;
    
    @Override
    public void initedView() {
        // TODO Auto-generated method stub
        listView.setMode(Mode.DISABLED);
        listView.getRefreshableView().addHeaderView(layoutInflater.inflate(R.layout.themedetail_head_lay, null));
        tvContent = (TextView)findViewById(R.id.tvContent);
        ivDc = (ImageView)findViewById(R.id.ivDc);
        screenW = ViewUtil.getScreenDM(baseActivity).widthPixels;
        ViewUtil.setViewWH(ivDc, screenW, (int)(screenW / 1.7));
        // listBottomLay
        layoutInflater.inflate(R.layout.themedetail_bottom_lay, listBottomLay);
        tvFavou = (TextView)findViewById(R.id.tvFavou);
        tvComment = (TextView)findViewById(R.id.tvComment);
        tvShare = (TextView)findViewById(R.id.tvShare);
        tvFavou.setOnClickListener(this);
        tvComment.setOnClickListener(this);
        tvShare.setOnClickListener(this);
    }
    
    @Override
    public void getData(int indexPage, int pageSize) {
        // TODO Auto-generated method stub
        ApiClient.getInstance(baseActivity).theme_detail(getArguments().getString("id"), new HttpCallBack() {
            
            @Override
            public void onSuccess(String result) {
                // TODO Auto-generated method stub
                ThemeDetailBean themeDetailBean =
                    (ThemeDetailBean)JsonExplain.explainJson(result, ThemeDetailBean.class);
                if (themeDetailBean.getDetails() != null) {
                    adapter.addAll(themeDetailBean.getDetails());
                }
                tvContent.setText("\t\t" + themeDetailBean.getContent());
                Glide.with(baseActivity).load(HttpConstants.imgurl1 + themeDetailBean.getImg()).into(ivDc);
                tvFavou.setText(themeDetailBean.getPraise() + "");
                tvComment.setText(themeDetailBean.getReview() + "");
                tvShare.setText(themeDetailBean.getShare() + "");
            }
            
            @Override
            public void onStart() {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onLoading(long total, long current, boolean isUploading) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onFailure(String msg) {
                // TODO Auto-generated method stub
                
            }
        });
    }
    
    @Override
    public BaseAdapter getAdapter() {
        // TODO Auto-generated method stub
        adapter = new QuickAdapter<CommodityBean>(baseActivity, R.layout.listitem_themedetail) {
            
            @Override
            protected void convert(BaseAdapterHelper helper, CommodityBean item) {
                // TODO Auto-generated method stub
                helper.setText(R.id.tvTitle, item.getName());
                helper.setText(R.id.tvPrice, "￥" + item.getPrice());
                helper.setText(R.id.tvDes, Html.fromHtml(item.getContent()).toString());
                ViewUtil.setViewWH(helper.getView(R.id.ivCommodity), screenW, (int)(screenW / 1.7));
                Glide.with(baseActivity)
                    .load(HttpConstants.imgurl1 + item.getImg())
                    .into((ImageView)helper.getView(R.id.ivCommodity));
                helper.getView(R.id.btnShowDetail).setOnClickListener(new OnClickListener() {
                    
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        
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
    
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.tvFavou:
                
                break;
            case R.id.tvComment:
                
                break;
            case R.id.tvShare:
                
                break;
        }
    }
    
}
