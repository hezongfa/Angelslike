package com.android.angelslike.ui;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.angelslike.R;
import com.android.angelslike.R.anim;
import com.android.angelslike.R.color;
import com.android.angelslike.R.drawable;
import com.android.angelslike.R.id;
import com.android.angelslike.R.layout;
import com.android.angelslike.R.string;
import com.android.angelslike.ui.category.CategoryFragment;
import com.android.angelslike.ui.home.HomeFragment;
import com.android.angelslike.ui.login_register.LoginActivity;
import com.android.angelslike.ui.piece.PieceFragment;
import com.android.angelslike.ui.piece.launchpiece.PieceStrategyActivity;
import com.android.angelslike.ui.user.UserFragment;
import com.android.angelslike.view.SearchTopBarView;
import com.hzf.activity.BaseTabActivity;
import com.hzf.fragment.BaseFragment;
import com.hzf.utils.ViewUtil;

public class MainActivity extends BaseTabActivity {
    TextView tvLeft, tvRight;
    LinearLayout pieceCategoryView;
    // boolean isLefted = true;
    PieceFragment pieceFragment;
    CategoryFragment categoryFragment;
    // RelativeLayout topSearchBar;
    
    SearchTopBarView topSearchBar;
    
    @SuppressLint("ResourceAsColor")
    @Override
    public void inited() {
        // TODO Auto-generated method stub
        isexit = true;
        setBottomTabBgColor(R.color.white);
        setBottomTabTextColor(R.color.theme_gray, R.color.theme);
        topBarView.hzf_tvTitle.setVisibility(View.VISIBLE);
        topBarView.hzf_tvTitle.setTextSize(18f);
        topBarView.hzf_tvTitle.setTextColor(resources.getColor(R.color.white));
        topBarView.hzf_topbarLay.setBackgroundResource(R.color.theme);
        
        // 底部中间+按钮
        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(ViewUtil.dip2px(context, 60), LayoutParams.MATCH_PARENT);
        getBottomCenterExtraLay().setLayoutParams(params);
        getBottomCenterExtraLay().setBackgroundResource(R.color.theme);
        ImageView textView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams =
            new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        textView.setLayoutParams(layoutParams);
        getBottomCenterExtraLay().addView(textView);
        textView.setImageResource(R.drawable.bottom_add);
        getBottomCenterExtraLay().setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                popActivity(getIntent(LoginActivity.class));
                // Intent intent = getIntent(PieceStrategyActivity.class);
                // popActivityForResult(intent, 880);
            }
        });
        hzf_contentlay.setBackgroundColor(resources.getColor(R.color.lay_bg));
        topBarView.hzf_tvTitle.setText(getString(R.string.app_name));
        addPieceCategoryView();
        
        setRightBtnImg(R.drawable.search_btn_bg);
        topBarView.hzf_rightBtn.setVisibility(View.GONE);
        topBarView.hzf_rightBtn.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                topSearchBar.show();
            }
        });
        // topSearchBar = (RelativeLayout)LayoutInflater.from(context).inflate(R.layout.top_search_bar, null);
        // topSearchBar.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(
        // android.widget.RelativeLayout.LayoutParams.MATCH_PARENT, ViewUtil.dip2px(context, 52)));
        // topSearchBar.setVisibility(View.GONE);
        
        topSearchBar = new SearchTopBarView(context);
        topBarView.addView(topSearchBar);
    }
    
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }
    
    private void addPieceCategoryView() {
        pieceCategoryView =
            (LinearLayout)LayoutInflater.from(context)
                .inflate(R.layout.view_top_selecttab, topBarView.hzf_centerCusLay);
        tvLeft = (TextView)pieceCategoryView.findViewById(R.id.tvLeft);
        tvRight = (TextView)pieceCategoryView.findViewById(R.id.tvRight);
        tvLeft.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // isLefted = true;
                onSelectClick(true);
                if (getCurIndex() == 1) {
                    if (pieceFragment != null) {
                        pieceFragment.switchFragment(true);
                    }
                } else if (getCurIndex() == 2) {
                    if (categoryFragment != null) {
                        categoryFragment.switchFragment(true);
                    }
                }
                
            }
        });
        tvRight.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // isLefted = false;
                onSelectClick(false);
                if (getCurIndex() == 1) {
                    if (pieceFragment != null) {
                        pieceFragment.switchFragment(false);
                    }
                } else if (getCurIndex() == 2) {
                    if (categoryFragment != null) {
                        categoryFragment.switchFragment(false);
                    }
                }
            }
        });
        onSelectClick(true);
    }
    
    private void onSelectClick(boolean isLefted) {
        if (isLefted) {
            tvLeft.setTextColor(getResources().getColor(R.color.theme));
            tvLeft.setBackgroundResource(R.drawable.tab_select_bg_left_white);
            tvRight.setTextColor(getResources().getColor(R.color.white));
            tvRight.setBackgroundResource(R.drawable.tab_select_bg_right_theme);
        } else {
            tvRight.setTextColor(getResources().getColor(R.color.theme));
            tvRight.setBackgroundResource(R.drawable.tab_select_bg_right_white);
            tvLeft.setTextColor(getResources().getColor(R.color.white));
            tvLeft.setBackgroundResource(R.drawable.tab_select_bg_left_theme);
        }
        
    }
    
    @Override
    public ArrayList<TabItem> getTabItems() {
        // TODO Auto-generated method stub
        // pieceFragment = new PieceFragment();
        // categoryFragment = new CategoryFragment();
        pieceFragment = BaseFragment.newInstance(context, PieceFragment.class);
        categoryFragment = BaseFragment.newInstance(context, CategoryFragment.class);
        
        ArrayList<TabItem> arrayList = new ArrayList<BaseTabActivity.TabItem>();
        arrayList.add(new TabItem(R.drawable.bottom_main_def, R.drawable.bottom_main_press, "首页",
            BaseFragment.newInstance(context, HomeFragment.class)));
        arrayList.add(new TabItem(R.drawable.bottom_collection_def, R.drawable.bottom_collection_press, "凑份子",
            pieceFragment));
        arrayList.add(new TabItem(R.drawable.bottom_category_def, R.drawable.bottom_category_press, "分类",
            categoryFragment));
        arrayList.add(new TabItem(R.drawable.bottom_user_def, R.drawable.bottom_user_press, "我的",
            BaseFragment.newInstance(context, UserFragment.class)));
        return arrayList;
    }
    
    @Override
    public void onTabClick(int onclickIndex) {
        // TODO Auto-generated method stub
        if (topSearchBar != null) {
            topSearchBar.close();
        }
        if (onclickIndex == 1 || onclickIndex == 2) {
            topBarView.hzf_rightBtn.setVisibility(View.VISIBLE);
            pieceCategoryView.setVisibility(View.VISIBLE);
            topBarView.hzf_tvTitle.setVisibility(View.GONE);
            if (onclickIndex == 1) {
                tvLeft.setText("谁在凑份子");
                tvRight.setText("我的凑份子");
                if (pieceFragment != null) {
                    onSelectClick(pieceFragment.isLeft);
                }
            } else if (onclickIndex == 2) {
                tvLeft.setText("礼物分类");
                tvRight.setText("主题分类");
                if (categoryFragment != null) {
                    onSelectClick(categoryFragment.isLeft);
                }
            }
        } else {
            topBarView.hzf_rightBtn.setVisibility(View.GONE);
            pieceCategoryView.setVisibility(View.GONE);
            topBarView.hzf_tvTitle.setVisibility(View.VISIBLE);
        }
        if (onclickIndex == 3) {
            topBarView.setVisibility(View.GONE);
        } else {
            topBarView.setVisibility(View.VISIBLE);
        }
    }
    
    @Override
    protected void onActivityResult(int arg0, int arg1, Intent arg2) {
        // TODO Auto-generated method stub
        super.onActivityResult(arg0, arg1, arg2);
        if (arg0 == 880) {
            if (arg1 == RESULT_OK) {
                witchContent(2);
            }
        }
    }
    
}
