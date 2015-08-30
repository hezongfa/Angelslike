package com.android.angelslike.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.android.angelslike.R;

public class SearchTopBarView extends RelativeLayout {
    Button btnSearch, btnSearchback;
    EditText etSearchContent;
    Context context;
//    ShawPopup shawPopup;
    
    public SearchTopBarView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        
        init(context);
    }
    
    private void init(Context context) {
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.top_search_bar, this);
        btnSearch = (Button)findViewById(R.id.btnSearch);
        btnSearchback = (Button)findViewById(R.id.btnSearchback);
        etSearchContent = (EditText)findViewById(R.id.etSearchContent);
        btnSearch.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
//                shawPopup.dismiss();
            }
        });
        btnSearchback.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                close();
            }
        });
//        shawPopup = new ShawPopup(context);
//        shawPopup.setOnDismissListener(new OnDismissListener() {
//            
//            @Override
//            public void onDismiss() {
//                // TODO Auto-generated method stub
//                
//            }
//        });
        setVisibility(View.GONE);
        
    }
    
    public void show() {
        if (getVisibility() == View.VISIBLE) {
            return;
        }
        setVisibility(View.VISIBLE);
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.in_from_right);
        startAnimation(anim);
//        shawPopup.showAsDropDown(this);
    }
    
    public void close() {
        if (getVisibility() == View.GONE) {
            return;
        }
        setVisibility(View.GONE);
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.out_to_right);
        startAnimation(anim);
//        shawPopup.dismiss();
    }
    
    class ShawPopup extends PopupWindow {
        
        public ShawPopup(Context context) {
            super(LayoutInflater.from(context).inflate(R.layout.popup_shaw, null), LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT, true);
            // TODO Auto-generated constructor stub
            View contentView = getContentView();
            // setAnimationStyle(R.style.PopupAnimation);
            setOutsideTouchable(true);
            setTouchable(true);
            ColorDrawable dw = new ColorDrawable(-00000);
            setBackgroundDrawable(dw);
            update();
            // 点击其他地方消失
            contentView.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // TODO Auto-generated method stub
                    dismiss();
                    close();
                    return true;
                }
            });
        }
        
    }
}
