package com.android.angelslike.ui.comment;

import com.android.angelslike.R;
import com.android.angelslike.bean.CommentBean;
import com.android.angelslike.ui.ABaseActivity;
import com.hzf.adapter.QuickAdapter;
import com.hzf.fragment.BaseFragment;

public class CommodityActivity extends ABaseActivity {
    
    @Override
    public void onCreateContentView() {
        // TODO Auto-generated method stub
        setMainContentView(R.layout.hzf_act_replace_fragment_lay);
        replaceContent(R.id.hzf_act_replace_fragment_lay,
            BaseFragment.newInstance(context, CommentFragment.class, getIntent().getExtras()));
    }
    
    @Override
    public void onFindView() {
        // TODO Auto-generated method stub
        setTitle("评论");
    }
    
    @Override
    public void onPostLoad() {
        // TODO Auto-generated method stub
        
    }
    
}
