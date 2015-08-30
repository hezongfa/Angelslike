package com.android.angelslike.ui.piece.launchpiece;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.angelslike.R;
import com.android.angelslike.ui.ABaseActivity;

public class PieceStrategyActivity extends ABaseActivity {
    TextView tvName, tvTime;
    Button btnSelectPresent;
//    NoScrollGridView gridview;
//    QuickAdapter<StrategyItem> adapter;
//    ArrayList<StrategyItem> items;
    
    @Override
    public void onCreateContentView() {
        // TODO Auto-generated method stub
        setMainContentView(R.layout.activity_piecestrategy);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        
    }

    @Override
    public void onFindView() {
        // TODO Auto-generated method stub
        setTitle("发起凑份子");
        tvName = (TextView)findViewById(R.id.tvName);
        tvTime = (TextView)findViewById(R.id.tvTime);
        btnSelectPresent = (Button)findViewById(R.id.btnSelectPresent);
        btnSelectPresent.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                setResult(RESULT_OK);
                finish();
            }
        });
//        gridview = (NoScrollGridView)findViewById(R.id.gridview);
    }
    
    @Override
    public void onPostLoad() {
        // TODO Auto-generated method stub
//        items = new ArrayList<PieceStrategyActivity.StrategyItem>();
//        items.add(new StrategyItem("1.选份心仪的礼物", R.drawable.ic_launcher));
//        items.add(new StrategyItem("2.给TA个不得不凑的理由", R.drawable.ic_launcher));
//        items.add(new StrategyItem("4.自己先凑一份", R.drawable.ic_launcher));
//        items.add(new StrategyItem("3.确定凑份子份数", R.drawable.ic_launcher));
//        items.add(new StrategyItem("5.邀请朋友来凑", R.drawable.ic_launcher));
//        items.add(new StrategyItem("6.凑齐完成购买", R.drawable.ic_launcher));
//        adapter = new QuickAdapter<StrategyItem>(this, R.layout.griditem_trategy,items) {
//            
//            @Override
//            protected void convert(BaseAdapterHelper helper, StrategyItem item) {
//                // TODO Auto-generated method stub
//                TextView tvItem = helper.getView(R.id.tvItem);
//                tvItem.setText(item.getTitle());
//                tvItem.setCompoundDrawablesWithIntrinsicBounds(0, item.getImgresId(), 0, 0);
//            }
//        };
//        gridview.setAdapter(adapter);
    }
    
    class StrategyItem {
        String title;
        int imgresId;
        
        public String getTitle() {
            return title;
        }
        
        public void setTitle(String title) {
            this.title = title;
        }
        
        public int getImgresId() {
            return imgresId;
        }
        
        public void setImgresId(int imgresId) {
            this.imgresId = imgresId;
        }
        
        public StrategyItem() {
            super();
            // TODO Auto-generated constructor stub
        }
        
        public StrategyItem(String title, int imgresId) {
            super();
            this.title = title;
            this.imgresId = imgresId;
        }
        
    }
}
