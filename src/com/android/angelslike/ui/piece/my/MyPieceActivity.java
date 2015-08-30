package com.android.angelslike.ui.piece.my;

import com.android.angelslike.R;
import com.android.angelslike.ui.ABaseActivity;
import com.android.angelslike.ui.piece.MyPieceListFragment;
import com.hzf.fragment.BaseFragment;

public class MyPieceActivity extends ABaseActivity {
    
    @Override
    public void onCreateContentView() {
        // TODO Auto-generated method stub
        setMainContentView(R.layout.hzf_act_replace_fragment_lay);
        replaceContent(R.id.hzf_act_replace_fragment_lay,
            BaseFragment.newInstance(context, MyPieceListFragment.class, getIntent().getExtras()));
    }
    
    @Override
    public void onFindView() {
        // TODO Auto-generated method stub
        setTitle("我的凑份子");
    }
    
    @Override
    public void onPostLoad() {
        // TODO Auto-generated method stub
        
    }
    
}
