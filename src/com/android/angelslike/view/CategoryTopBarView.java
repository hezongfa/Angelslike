package com.android.angelslike.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.android.angelslike.R;

public class CategoryTopBarView extends LinearLayout implements OnClickListener {
    CategoryPopupWindow categoryPopupWindow;
    Context context;
    Button btnSelect1, btnSelect2, btnSelect3;
    int curIndex = 0;
    PopItem popItem1, popItem2, popItem3;
    ArrayList<PopItem> popItems1;
    ArrayList<PopItem> popItems2;
    ArrayList<PopItem> popItems3;
    
    public CategoryTopBarView(Context context) {
        super(context);
        init(context);
    }
    
    public CategoryTopBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    
    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.category_topbar_view, this);
        btnSelect1 = (Button)findViewById(R.id.btnSelect1);
        btnSelect2 = (Button)findViewById(R.id.btnSelect2);
        btnSelect3 = (Button)findViewById(R.id.btnSelect3);
        btnSelect1.setOnClickListener(this);
        btnSelect2.setOnClickListener(this);
        btnSelect3.setOnClickListener(this);
        popItem1 = new PopItem();
        popItem2 = new PopItem();
        popItem3 = new PopItem();
        popItems1 = new ArrayList<PopItem>();
        popItems2 = new ArrayList<PopItem>();
        popItems3 = new ArrayList<PopItem>();
        categoryPopupWindow = new CategoryPopupWindow(context, popItems1);
    }
    
    public void showCategoryPopup(ArrayList<PopItem> items) {
        categoryPopupWindow.setItems(items);
        categoryPopupWindow.setOnItemClick(new OnItemClickListener() {
            
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                categoryPopupWindow.dismiss();
                PopItem item = null;
                switch (curIndex) {
                    case 0:
                        item = popItems1.get(position);
                        setPopItem(popItem1, item);
                        btnSelect1.setText(popItem1.getText());
                        break;
                    case 1:
                        item = popItems2.get(position);
                        setPopItem(popItem2, item);
                        btnSelect2.setText(popItem2.getText());
                        break;
                    case 2:
                        item = popItems3.get(position);
                        setPopItem(popItem3, item);
                        btnSelect3.setText(popItem3.getText());
                        break;
                }
                
                if (tobBarListener != null) {
                    tobBarListener.onPostitonCLick(popItem1, popItem2, popItem3);
                }
            }
        });
        categoryPopupWindow.showAsDropDown(this);
    }
    
    private void setPopItem(PopItem popItem, PopItem tempPopItem) {
        popItem.setId(tempPopItem.getId());
        popItem.setText(tempPopItem.getText());
    }
    
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        
        switch (v.getId()) {
            case R.id.btnSelect1:
                onClick(0);
                break;
            case R.id.btnSelect2:
                onClick(1);
                break;
            case R.id.btnSelect3:
                onClick(2);
                break;
            default:
                break;
        }
    }
    
    private void onClick(int position) {
        curIndex = position;
        switch (position) {
            case 0:
                showCategoryPopup(popItems1);
                break;
            case 1:
                showCategoryPopup(popItems2);
                break;
            case 2:
                showCategoryPopup(popItems3);
                break;
        }
        
    }
    
    public void setSelectData(String title1, String title2, String title3, ArrayList<PopItem> popItems1,
        ArrayList<PopItem> popItems2, ArrayList<PopItem> popItems3) {
        this.popItems1.clear();
        this.popItems1.addAll(popItems1);
        this.popItems2.clear();
        this.popItems2.addAll(popItems2);
        this.popItems3.clear();
        this.popItems3.addAll(popItems3);
        btnSelect1.setText(title1);
        btnSelect2.setText(title2);
        btnSelect3.setText(title3);
        
    }
    
    CategoryBarListener tobBarListener;
    
    public void setCategoryBarListener(CategoryBarListener tobBarListener) {
        this.tobBarListener = tobBarListener;
    }
    
    public interface CategoryBarListener {
        public void onPostitonCLick(PopItem popItem1, PopItem popItem2, PopItem popItem3);
    }
}
