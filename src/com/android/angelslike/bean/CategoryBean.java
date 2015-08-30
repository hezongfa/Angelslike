package com.android.angelslike.bean;

import com.hzf.bean.BaseBean;

public class CategoryBean extends BaseBean {
    private String title;
    private int imgResId;
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getImgResId() {
        return imgResId;
    }
    
    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }
    
    public CategoryBean(String title, int imgResId) {
        super();
        this.title = title;
        this.imgResId = imgResId;
    }
    
    public CategoryBean() {
        super();
        // TODO Auto-generated constructor stub
    }
    
}
