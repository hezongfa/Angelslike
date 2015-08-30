package com.android.angelslike.ui.comment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.android.angelslike.R;
import com.android.angelslike.bean.CommentBean;
import com.android.angelslike.utils.http.HttpConstants;
import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.hzf.adapter.BaseAdapterHelper;
import com.hzf.adapter.QuickAdapter;
import com.hzf.fragment.BaseListFragment;

public class CommentFragment extends BaseListFragment {
    QuickAdapter<CommentBean> adapter;
    
    @Override
    public void initedView() {
        // TODO Auto-generated method stub
        listView.setMode(Mode.DISABLED);
    }
    
    @Override
    public BaseAdapter getAdapter() {
        // TODO Auto-generated method stub
        adapter = new QuickAdapter<CommentBean>(baseActivity, R.layout.listitem_comment) {
            
            @Override
            protected void convert(BaseAdapterHelper helper, CommentBean item) {
                // TODO Auto-generated method stub
                helper.setText(R.id.tvName, item.getUname());
                helper.setText(R.id.tvContent, item.getComment());
                helper.setText(R.id.tvTime, item.getTime());
                Glide.with(baseActivity).load(HttpConstants.imgurl2 + item.getUimg());
            }
        };
        return null;
    }
    
    @Override
    public void onListItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void getData(int indexPage, int pageSize) {
        // TODO Auto-generated method stub
        
    }
}