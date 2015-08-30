package com.android.angelslike.ui.user;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.angelslike.R;
import com.android.angelslike.ui.piece.MyPieceListFragment;
import com.android.angelslike.ui.piece.my.MyPieceActivity;
import com.hzf.fragment.BaseFragment;
import com.hzf.utils.ViewUtil;
import com.hzf.widget.pulltozoomview.PullToZoomScrollViewEx;
import com.hzf.widget.roundedimageview.RoundedImageView;

public class UserFragment extends BaseFragment implements OnClickListener {
    PullToZoomScrollViewEx scrollView;
    RoundedImageView ivHead;
    TextView tvName, tvBlance, tvIntegral, tvMyPiece, tvMyOrder, tvCart, tvIntelligent, tvFriends, tvSetting;
    Button btnEdit;
    
    @Override
    protected int getLayout() {
        // TODO Auto-generated method stub
        return R.layout.fragment_my;
    }
    
    @Override
    protected void inited() {
        // TODO Auto-generated method stub
        scrollView = (PullToZoomScrollViewEx)findViewById(R.id.scrollView);
        View headView = LayoutInflater.from(baseActivity).inflate(R.layout.user_head_view, null);
        View zoomView = LayoutInflater.from(baseActivity).inflate(R.layout.user_zoom_view, null);
        View contentView = LayoutInflater.from(baseActivity).inflate(R.layout.user_content_view, null);
        scrollView.setHeaderView(headView);
        scrollView.setZoomView(zoomView);
        scrollView.setScrollContentView(contentView);
        
        LinearLayout.LayoutParams localObject =
            new LinearLayout.LayoutParams(ViewUtil.getScreenDM(baseActivity).widthPixels,
                (int)(4.0F * (ViewUtil.getScreenDM(baseActivity).widthPixels / 16.0F)));
        scrollView.setHeaderLayoutParams(localObject);
        
        btnEdit = (Button)headView.findViewById(R.id.btnEdit);
        ivHead = (RoundedImageView)contentView.findViewById(R.id.ivHead);
        tvName = (TextView)contentView.findViewById(R.id.tvName);
        tvBlance = (TextView)contentView.findViewById(R.id.tvBlance);
        tvIntegral = (TextView)contentView.findViewById(R.id.tvIntegral);
        tvMyPiece = (TextView)contentView.findViewById(R.id.tvMyPiece);
        tvMyOrder = (TextView)contentView.findViewById(R.id.tvMyOrder);
        tvCart = (TextView)contentView.findViewById(R.id.tvCart);
        tvIntelligent = (TextView)contentView.findViewById(R.id.tvIntelligent);
        tvFriends = (TextView)contentView.findViewById(R.id.tvFriends);
        tvSetting = (TextView)contentView.findViewById(R.id.tvSetting);
        btnEdit.setOnClickListener(this);
        ivHead.setOnClickListener(this);
        tvIntegral.setOnClickListener(this);
        tvMyPiece.setOnClickListener(this);
        tvMyOrder.setOnClickListener(this);
        tvCart.setOnClickListener(this);
        tvIntelligent.setOnClickListener(this);
        tvFriends.setOnClickListener(this);
        tvSetting.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnEdit:
                baseActivity.pushActivity(baseActivity.getIntent(EditInfoActivity.class));
                break;
            case R.id.ivHead:
                
                break;
            case R.id.tvIntegral:
                
                break;
            case R.id.tvMyPiece:
                baseActivity.pushActivity(baseActivity.getIntent(MyPieceActivity.class));
                break;
            case R.id.tvMyOrder:
                
                break;
            case R.id.tvCart:
                
                break;
            case R.id.tvIntelligent:
                
                break;
            case R.id.tvFriends:
                
                break;
            case R.id.tvSetting:
                
                break;
        }
    }
    
}
