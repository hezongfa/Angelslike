package com.android.angelslike.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

import com.android.angelslike.R;

public class SearchDialog extends Dialog {
    Context context;
    View view;
    
    public SearchDialog(Context context) {
        super(context, R.style.searchDialog);
        init(context);
    }
    
    private void init(Context context) {
        this.context = context;
        
        this.setCanceledOnTouchOutside(true);
        this.setCancelable(true);
        view = LayoutInflater.from(context).inflate(R.layout.dialog_search, null);
        this.setContentView(view);
        getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }
    
    @Override
    public void show() {
        // TODO Auto-generated method stub
        super.show();
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.in_from_right);
        view.startAnimation(anim);
    }
    
    @Override
    public void dismiss() {
        // TODO Auto-generated method stub
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.out_to_right);
        anim.setAnimationListener(new AnimationListener() {
            
            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub
                SearchDialog.super.dismiss();
            }
        });
        view.startAnimation(anim);
        
    }
    
}
