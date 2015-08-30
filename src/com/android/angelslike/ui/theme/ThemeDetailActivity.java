package com.android.angelslike.ui.theme;

import com.android.angelslike.R;
import com.android.angelslike.ui.ABaseActivity;
import com.hzf.fragment.BaseFragment;

public class ThemeDetailActivity extends ABaseActivity {
    
    @Override
    public void onCreateContentView() {
        // TODO Auto-generated method stub
        setMainContentView(R.layout.hzf_act_replace_fragment_lay);
        replaceContent(R.id.hzf_act_replace_fragment_lay,
            BaseFragment.newInstance(context, ThemeDetailFragment.class, getIntent().getExtras()));
    }
    
    @Override
    public void onFindView() {
        // TODO Auto-generated method stub
        setTitle("攻略详情");
    }
    
    @Override
    public void onPostLoad() {
        // TODO Auto-generated method stub
    }
    
}
