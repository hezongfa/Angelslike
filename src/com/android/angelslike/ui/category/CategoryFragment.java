package com.android.angelslike.ui.category;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.android.angelslike.R;
import com.hzf.fragment.BaseFragment;

public class CategoryFragment extends BaseFragment {
    public boolean isLeft = true;
    PresentCategoryFragment presentCategoryFragment;
    ThemeCategoryFragment themeCategoryFragment;
    private final String PresentCategoryFragmentTag = PresentCategoryFragment.class.getSimpleName();
    private final String ThemeCategoryFragmentTag = ThemeCategoryFragment.class.getSimpleName();
    
    @Override
    public void onViewCreated(View view, @Nullable
    Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            presentCategoryFragment =
                (PresentCategoryFragment)getChildFragmentManager().getFragment(savedInstanceState,
                    PresentCategoryFragmentTag);
            themeCategoryFragment =
                (ThemeCategoryFragment)getChildFragmentManager().getFragment(savedInstanceState,
                    ThemeCategoryFragmentTag);
        }
    }
    
    @Override
    protected int getLayout() {
        // TODO Auto-generated method stub
        return R.layout.fragment_category;
    }
    
    @Override
    protected void inited() {
        // TODO Auto-generated method stub
        switchFragment(true);
    }
    
    public void switchFragment(boolean isLeft) {
        this.isLeft = isLeft;
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (isLeft) {
            if (themeCategoryFragment != null) {
                transaction.hide(themeCategoryFragment);
            }
            if (presentCategoryFragment == null) {
                presentCategoryFragment = BaseFragment.newInstance(baseActivity, PresentCategoryFragment.class);
                transaction.add(R.id.layCategoryContent, presentCategoryFragment, PresentCategoryFragmentTag);
            }
            transaction.show(presentCategoryFragment);
        } else {
            if (presentCategoryFragment != null) {
                transaction.hide(presentCategoryFragment);
            }
            if (themeCategoryFragment == null) {
                themeCategoryFragment = BaseFragment.newInstance(baseActivity, ThemeCategoryFragment.class);
                transaction.add(R.id.layCategoryContent, themeCategoryFragment, ThemeCategoryFragmentTag);
            }
            transaction.show(themeCategoryFragment);
        }
        transaction.commit();
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
        if (presentCategoryFragment != null) {
            if (getChildFragmentManager().findFragmentByTag(PresentCategoryFragmentTag) == null) {
                getChildFragmentManager().putFragment(outState, PresentCategoryFragmentTag, presentCategoryFragment);
            }
        }
        if (themeCategoryFragment != null) {
            if (getChildFragmentManager().findFragmentByTag(ThemeCategoryFragmentTag) == null) {
                getChildFragmentManager().putFragment(outState, ThemeCategoryFragmentTag, themeCategoryFragment);
            }
        }
    }
    
}
