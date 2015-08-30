package com.android.angelslike.ui.piece;

import android.text.Html;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.angelslike.R;
import com.android.angelslike.bean.ClubBean;
import com.android.angelslike.bean.ClubDetailBean;
import com.android.angelslike.ui.ABaseActivity;
import com.android.angelslike.utils.http.ApiClient;
import com.android.angelslike.utils.http.ApiClient.HttpCallBack;
import com.android.angelslike.utils.http.HttpConstants;
import com.bumptech.glide.Glide;
import com.github.lzyzsd.circleprogress.DonutProgress;
import com.hzf.utils.JsonExplain;
import com.hzf.utils.StringUtil;
import com.hzf.widget.NoScrollWebView;
import com.hzf.widget.roundedimageview.RoundedImageView;

public class PieceDetailActivity extends ABaseActivity {
    ClubBean clubBean;
    NoScrollWebView wvPieceContent, wvCommodityContent;
    RoundedImageView ivHead;
    ImageView ivCommodity;
    TextView tvName, tvStartTime, tvEndTime, tvReaded, tvShare, tvSent, tvClubStates, tvGoal, tvEvery, tvAllCount,
        tvCountBackwords, tvTitle, tvComomdityName, tvPrice, tvGoalCount, tvCurCount;
    Button btnShowDetail, btnInviteFriend;
    DonutProgress donut_progress;
    
    @Override
    public void onCreateContentView() {
        // TODO Auto-generated method stub
        setMainContentView(R.layout.activity_piecedetail);
    }
    
    @Override
    public void onFindView() {
        // TODO Auto-generated method stub
        setTitle("凑份子");
        clubBean = (ClubBean)getIntent().getSerializableExtra("ClubBean");
        ivHead = (RoundedImageView)findViewById(R.id.ivHead);
        wvPieceContent = (NoScrollWebView)findViewById(R.id.wvPieceContent);
        wvCommodityContent = (NoScrollWebView)findViewById(R.id.wvCommodityContent);
        wvPieceContent.getSettings().setDefaultTextEncodingName("UTF-8");
        wvPieceContent.setSingleColumn();
        wvCommodityContent.getSettings().setDefaultTextEncodingName("UTF-8");
        wvCommodityContent.setSingleColumn();
        tvName = (TextView)findViewById(R.id.tvName);
        tvStartTime = (TextView)findViewById(R.id.tvStartTime);
        tvEndTime = (TextView)findViewById(R.id.tvEndTime);
        tvReaded = (TextView)findViewById(R.id.tvReaded);
        tvShare = (TextView)findViewById(R.id.tvShare);
        tvSent = (TextView)findViewById(R.id.tvSent);
        tvClubStates = (TextView)findViewById(R.id.tvClubStates);
        tvGoal = (TextView)findViewById(R.id.tvGoal);
        tvEvery = (TextView)findViewById(R.id.tvEvery);
        tvAllCount = (TextView)findViewById(R.id.tvAllCount);
        tvCountBackwords = (TextView)findViewById(R.id.tvCountBackwords);
        tvTitle = (TextView)findViewById(R.id.tvTitle);
        ivCommodity = (ImageView)findViewById(R.id.ivCommodity);
        tvComomdityName = (TextView)findViewById(R.id.tvComomdityName);
        tvPrice = (TextView)findViewById(R.id.tvPrice);
        tvGoalCount = (TextView)findViewById(R.id.tvGoalCount);
        tvCurCount = (TextView)findViewById(R.id.tvCurCount);
        btnShowDetail = (Button)findViewById(R.id.btnShowDetail);
        btnInviteFriend = (Button)findViewById(R.id.btnInviteFriend);
        donut_progress = (DonutProgress)findViewById(R.id.donut_progress);
    }
    
    @Override
    public void onPostLoad() {
        // TODO Auto-generated method stub
        getData();
    }
    
    private void getData() {
        ApiClient.getInstance(context).piecedetail(clubBean.getId() + "", clubBean.getType() + "", new HttpCallBack() {
            
            @Override
            public void onSuccess(String result) {
                // TODO Auto-generated method stub
                String items = JsonExplain.getStringValue(result, "items");
                ClubDetailBean clubDetailBean = (ClubDetailBean)JsonExplain.explainJson(items, ClubDetailBean.class);
                if (clubDetailBean == null) {
                    return;
                }
                if (!StringUtil.isEmpty(clubDetailBean.getUimg())) {
                    Glide.with(PieceDetailActivity.this).load(clubDetailBean.getUimg()).into(ivHead);
                }
                if (!StringUtil.isEmpty(clubDetailBean.getUname())) {
                    tvName.setText(clubDetailBean.getUname());
                }
                if (!StringUtil.isEmpty(clubDetailBean.getStarttime())) {
                    tvStartTime.setText(clubDetailBean.getStarttime());
                }
                if (!StringUtil.isEmpty(clubDetailBean.getEndtime())) {
                    tvEndTime.setText(clubDetailBean.getEndtime());
                }
                if (!StringUtil.isEmpty(clubDetailBean.getNowstatus())) {
                    tvClubStates.setText(clubDetailBean.getNowstatus());
                }
                tvReaded.setText(clubDetailBean.getViews() + "");
                tvShare.setText(clubDetailBean.getShare() + "");
                tvSent.setText(clubDetailBean.getForwarding() + "");//
                tvGoal.setText("￥" + clubDetailBean.getPprice());
                tvEvery.setText("￥" + clubDetailBean.getEveryprice());
                tvAllCount.setText("￥" + clubDetailBean.getCopies());
                if (!StringUtil.isEmpty(clubDetailBean.getOutday())) {
                    tvCountBackwords.setText(Html.fromHtml(clubDetailBean.getOutday()));
                }
                if (!StringUtil.isEmpty(clubDetailBean.getTitle())) {
                    tvTitle.setText(clubDetailBean.getTitle());
                }
                
                String content = clubDetailBean.getContent();
                content = content.replaceAll("<img src=\"", "<img src=\"" + HttpConstants.domain);
                wvPieceContent.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);
                
                if (!StringUtil.isEmpty(clubDetailBean.getPimg())) {
                    Glide.with(PieceDetailActivity.this).load(clubDetailBean.getPimg()).into(ivCommodity);
                }
                
                if (!StringUtil.isEmpty(clubDetailBean.getPname())) {
                    tvComomdityName.setText(clubDetailBean.getPname());
                }
                if (!StringUtil.isEmpty(clubDetailBean.getPprice())) {
                    tvPrice.setText(clubDetailBean.getPprice());
                }
                
                String pContent = clubDetailBean.getPcontent();
                pContent = pContent.replaceAll("<img src=\"", "<img src=\"" + HttpConstants.domain);
                wvCommodityContent.loadDataWithBaseURL(null, pContent, "text/html", "utf-8", null);
                
                tvGoalCount.setText("目标" + clubDetailBean.getCopies() + "份");
                tvCurCount.setText("已凑" + clubDetailBean.getCurrentcopies() + "份");
                
                int progress = 0;
                if (clubDetailBean.getCurrentcopies() != 0) {
                    progress = StringUtil.getPercent(clubDetailBean.getCurrentcopies(), clubDetailBean.getCopies());
                }
                donut_progress.setProgress(progress);
                donut_progress.setText(progress + "%");
            }
            
            @Override
            public void onStart() {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onLoading(long total, long current, boolean isUploading) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onFailure(String msg) {
                // TODO Auto-generated method stub
                
            }
        });
    }
}
