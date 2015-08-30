package com.android.angelslike.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;

import com.android.angelslike.R;
import com.android.angelslike.R.color;
import com.android.angelslike.R.drawable;
import com.hzf.activity.BaseTopBarActivity;

public abstract class ABaseActivity extends BaseTopBarActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        
    }
    
    @Override
    public void onPreLoad() {
        // TODO Auto-generated method stub
        topBarView.hzf_tvTitle.setVisibility(View.VISIBLE);
        topBarView.hzf_tvTitle.setTextSize(18f);
        topBarView.hzf_tvTitle.setTextColor(resources.getColor(R.color.white));
        topBarView.hzf_topbarLay.setBackgroundResource(R.color.theme);
        
        setLeftBtnImg(R.drawable.backbtn);
        topBarView.hzf_leftBtn.setVisibility(View.VISIBLE);
        topBarView.hzf_leftBtn.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    
}
