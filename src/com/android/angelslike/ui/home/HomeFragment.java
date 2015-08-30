package com.android.angelslike.ui.home;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.android.angelslike.R;
import com.android.angelslike.adapter.ADViewPagerAdapter;
import com.android.angelslike.bean.Advertisement;
import com.android.angelslike.bean.HomeClubBean;
import com.android.angelslike.bean.PageInfo;
import com.android.angelslike.ui.theme.ThemeDetailActivity;
import com.android.angelslike.utils.http.ApiClient;
import com.android.angelslike.utils.http.ApiClient.HttpCallBack;
import com.android.angelslike.utils.http.HttpConstants;
import com.android.angelslike.utils.http.JsonHelper;
import com.bumptech.glide.Glide;
import com.hzf.adapter.BaseAdapterHelper;
import com.hzf.adapter.QuickAdapter;
import com.hzf.fragment.BaseListFragment;
import com.hzf.utils.JsonExplain;
import com.hzf.utils.ViewUtil;
import com.hzf.widget.autoscrollviewpager.AutoScrollViewPager;
import com.hzf.widget.roundedimageview.RoundedImageView;

public class HomeFragment extends BaseListFragment {
    int imgheight = 0;
    AutoScrollViewPager ad_viewpager;
    ADViewPagerAdapter ad_adapter;
    ArrayList<Advertisement> ad_list;
    ArrayList<HomeClubBean> clubBeans;
    QuickAdapter<HomeClubBean> adapter;
    
    @Override
    public void initedView() {
        // TODO Auto-generated method stub
        listView.getRefreshableView().setDividerHeight(0);
        imgheight = (int)(ViewUtil.getScreenDM(baseActivity).widthPixels / 2.2);
        initHead();
    }
    
    @Override
    public void getData(int indexPage, int pageSize) {
        // TODO Auto-generated method stub
        getAdData();
        getListData(indexPage);
    }
    
    @Override
    public BaseAdapter getAdapter() {
        // TODO Auto-generated method stub
        clubBeans = new ArrayList<HomeClubBean>();
        adapter = new QuickAdapter<HomeClubBean>(baseActivity, R.layout.listitem_home, clubBeans) {
            
            @Override
            protected void convert(BaseAdapterHelper helper, HomeClubBean item) {
                // TODO Auto-generated method stub
                RoundedImageView imageView = helper.getView(R.id.imageView);
                imageView.getLayoutParams().height = imgheight;
                RoundedImageView ivCoverage = helper.getView(R.id.ivCoverage);
                ivCoverage.getLayoutParams().height = imgheight;
                Glide.with(context).load(HttpConstants.imgurl1 + item.getImg()).crossFade().into(imageView);
                ivCoverage.setImageResource(R.drawable.black_coverage);
                helper.setText(R.id.tvTitle, item.getTitle());
            }
        };
        
        return adapter;
    }
    
    @Override
    public void onListItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        baseActivity.pushActivity(baseActivity.getIntent(ThemeDetailActivity.class).putExtra("id",
            adapter.getItem(position).getId() + ""));
    }
    
    // 广告栏
    LinearLayout pointsLayout;
    ArrayList<ImageView> points;
    private int adIndex = 0;
    
    private void initHead() {
        LinearLayout headlay = (LinearLayout)LayoutInflater.from(baseActivity).inflate(R.layout.ad_head, null);
        RelativeLayout layAd = (RelativeLayout)headlay.findViewById(R.id.layAd);
        listView.getRefreshableView().addHeaderView(headlay);
        ad_viewpager = (AutoScrollViewPager)findViewById(R.id.ad_head_viewpager);
        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                (int)(ViewUtil.getScreenDM(baseActivity).widthPixels / 16 * 9));
        layAd.setLayoutParams(params);
        pointsLayout = (LinearLayout)findViewById(R.id.points);
        points = new ArrayList<ImageView>();
        
        ad_list = new ArrayList<Advertisement>();
        ad_adapter = new ADViewPagerAdapter(ad_list, getActivity());
        ad_viewpager.setAdapter(ad_adapter);
        ad_viewpager.setInterval(4000);// 设置自动滚动的间隔时间，单位为毫秒
        ad_viewpager.setOnPageChangeListener(new PosterPageChange());
        // ad_viewpager.setDirection(AutoScrollViewPager.RIGHT);//
        // 设置自动滚动的方向，默认向右
        // ad_viewpager.setCycle(true);// 是否自动循环轮播，默认为true
        ad_viewpager.setScrollDurationFactor(4);//
        // 设置ViewPager滑动动画间隔时间的倍率，达到减慢动画或改变动画速度的效果
        ad_viewpager.setStopScrollWhenTouch(true);
        // 当手指碰到ViewPager时是否停止自动滚动，默认为true
        ad_viewpager.setSlideBorderMode(AutoScrollViewPager.SLIDE_BORDER_MODE_CYCLE);//
        // 滑动到第一个或最后一个Item的处理方式，支持没有任何操作、轮播以及传递到父View三种模式
        // ad_viewpager.setBorderAnimation(true);//
        // 设置循环滚动时滑动到从边缘滚动到下一个是否需要动画，默认为true
        ad_viewpager.setOnTouchListener(new OnTouchListener() {
            
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ad_viewpager.stopAutoScroll();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        ad_viewpager.stopAutoScroll();
                        break;
                    case MotionEvent.ACTION_UP:
                        ad_viewpager.startAutoScroll();
                        break;
                    
                    default:
                        break;
                }
                return false;
            }
        });
        ad_viewpager.startAutoScroll(4000);
    }
    
    private void initPoints() {
        points.clear();
        pointsLayout.removeAllViews();
        LinearLayout.LayoutParams lp =
            new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(ViewUtil.dip2px(baseActivity, 3),
            0,
            ViewUtil.dip2px(baseActivity, 3),
            ViewUtil.dip2px(baseActivity, 6));
        for (int i = 0; i < ad_list.size(); i++) {
            // 添加标记点
            ImageView point = new ImageView(getActivity());
            if (i == adIndex % ad_list.size()) {
                point.setBackgroundResource(R.drawable.in);
            } else {
                point.setBackgroundResource(R.drawable.out);
            }
            point.setLayoutParams(lp);
            points.add(point);
            pointsLayout.addView(point);
        }
    }
    
    class PosterPageChange implements OnPageChangeListener {
        
        @Override
        public void onPageScrollStateChanged(int arg0) {
            
        }
        
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            
        }
        
        @Override
        public void onPageSelected(int position) {
            adIndex = position;
            for (int i = 0; i < ad_list.size(); i++) {
                points.get(i).setBackgroundResource(R.drawable.out);
            }
            
            points.get(position % ad_list.size()).setBackgroundResource(R.drawable.in);
        }
        
    }
    
    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        if (ad_viewpager != null) {
            ad_viewpager.stopAutoScroll();
        }
        super.onDestroy();
    }
    
    private void getAdData() {
        
        ApiClient.getInstance(baseActivity).getslider(new HttpCallBack() {
            
            @Override
            public void onSuccess(String result) {
                // TODO Auto-generated method stub
                List<Advertisement> advertisements = JsonExplain.explainListJson(result, Advertisement[].class);
                ad_list.clear();
                if (advertisements.size() > 0) {
                    ad_list.addAll(advertisements);
                }
                ad_adapter.notifyDataSetChanged();
                initPoints();
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
        // com.android.angelslike.utils.ApiClient.getInstance(baseActivity).banner("1",
        // new com.android.angelslike.utils.ApiClient.HttpCallBack() {
        //
        // @Override
        // public void onSuccess(String result) {
        // // TODO Auto-generated method stub
        //
        // }
        //
        // @Override
        // public void onStart() {
        // // TODO Auto-generated method stub
        //
        // }
        //
        // @Override
        // public void onFailure(String msg) {
        // // TODO Auto-generated method stub
        //
        // }
        // });
    }
    
    private void getListData(final int indexPage) {
        com.android.angelslike.utils.ApiClient.getInstance(baseActivity).theme_lists("",
            "",
            "new",
            indexPage + "",
            new com.android.angelslike.utils.ApiClient.HttpCallBack() {
                
                @Override
                public void onSuccess(String result) {
                    // TODO Auto-generated method stub
                    stopRefresh();
                    String pageinfo = JsonExplain.getStringValue(result, JsonHelper.KEY_pageinfo);
                    PageInfo info = (PageInfo)JsonExplain.explainJson(pageinfo, PageInfo.class);
                    if (info.getMaxpage() == indexPage) {
                        canLoadMore = false;
                    }
                    String list = JsonExplain.getStringValue(result, JsonHelper.KEY_list);
                    List<HomeClubBean> beans = JsonExplain.explainListJson(list, HomeClubBean[].class);
                    if (indexPage == 1) {
                        adapter.clear();
                    }
                    if (beans.size() > 0) {
                        adapter.addAll(beans);
                    }
                }
                
                @Override
                public void onStart() {
                    // TODO Auto-generated method stub
                    // if (indexPage == 1) {
                    // startRefresh();
                    // }
                }
                
                @Override
                public void onFailure(String msg) {
                    // TODO Auto-generated method stub
                    stopRefresh();
                }
            });
        
        // ApiClient.getInstance(baseActivity).getList("list_theme",
        // indexPage + "", "", "", "new", "", "", "", new HttpCallBack() {
        //
        // @Override
        // public void onStart() {
        // // TODO Auto-generated method stub
        // // if (indexPage==1) {
        // // startRefresh();
        // // }
        //
        // }
        //
        // @Override
        // public void onLoading(long total, long current,
        // boolean isUploading) {
        // // TODO Auto-generated method stub
        //
        // }
        //
        // @Override
        // public void onFailure(String msg) {
        // // TODO Auto-generated method stub
        // stopRefresh();
        // }
        //
        // @Override
        // public void onSuccess(String result) {
        // // TODO Auto-generated method stub
        // stopRefresh();
        // String pageinfo = JsonExplain.getStringValue(result,
        // JsonHelper.KEY_pageinfo);
        // PageInfo info = (PageInfo) JsonExplain.explainJson(
        // pageinfo, PageInfo.class);
        // if (info.getMaxpage() == indexPage) {
        // canLoadMore = false;
        // }
        // String list = JsonExplain.getStringValue(result,
        // JsonHelper.KEY_list);
        // List<HomeClubBean> beans = JsonExplain.explainListJson(
        // list, HomeClubBean[].class);
        // if (indexPage == 1) {
        // adapter.clear();
        // }
        // if (beans.size() > 0) {
        // adapter.addAll(beans);
        // }
        // }
        //
        // });
    }
    
}
