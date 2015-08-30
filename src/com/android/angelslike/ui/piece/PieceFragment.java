package com.android.angelslike.ui.piece;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.android.angelslike.R;
import com.hzf.fragment.BaseFragment;

public class PieceFragment extends BaseFragment {
    PieceListFragment pieceListFragment;
    MyPieceListFragment myPieceListFragment;
    private final String PieceListFragmentTag = PieceListFragment.class.getSimpleName();
    private final String MyPieceListFragmentTag = MyPieceListFragment.class.getSimpleName();
    public boolean isLeft = true;
    
    @Override
    public void onViewCreated(View view, @Nullable
    Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            pieceListFragment =
                (PieceListFragment)getChildFragmentManager().getFragment(savedInstanceState, PieceListFragmentTag);
            myPieceListFragment =
                (MyPieceListFragment)getChildFragmentManager().getFragment(savedInstanceState, MyPieceListFragmentTag);
        }
    }
    
    @Override
    protected int getLayout() {
        // TODO Auto-generated method stub
        return R.layout.fragment_piece;
    }
    
    @Override
    protected void inited() {
        switchFragment(true);
    }
    
    public void switchFragment(boolean isLeft) {
        this.isLeft = isLeft;
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (isLeft) {
            if (myPieceListFragment != null) {
                transaction.hide(myPieceListFragment);
            }
            if (pieceListFragment == null) {
                pieceListFragment = BaseFragment.newInstance(baseActivity, PieceListFragment.class);
                transaction.add(R.id.layPieceContent, pieceListFragment, PieceListFragmentTag);
            }
            transaction.show(pieceListFragment);
        } else {
            if (pieceListFragment != null) {
                transaction.hide(pieceListFragment);
            }
            if (myPieceListFragment == null) {
                myPieceListFragment = BaseFragment.newInstance(baseActivity, MyPieceListFragment.class);
                transaction.add(R.id.layPieceContent, myPieceListFragment, MyPieceListFragmentTag);
            }
            transaction.show(myPieceListFragment);
        }
        transaction.commit();
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
        if (pieceListFragment != null) {
            if (getChildFragmentManager().findFragmentByTag(PieceListFragmentTag) == null) {
                getChildFragmentManager().putFragment(outState, PieceListFragmentTag, pieceListFragment);
            }
        }
        if (myPieceListFragment != null) {
            if (getChildFragmentManager().findFragmentByTag(MyPieceListFragmentTag) == null) {
                getChildFragmentManager().putFragment(outState, MyPieceListFragmentTag, myPieceListFragment);
            }
        }
    }
    
}
