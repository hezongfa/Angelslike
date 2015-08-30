package com.android.angelslike.bean;

import com.hzf.bean.BaseBean;

public class HomeClubBean extends BaseBean {
    private String title;
    private String img;
    
    public HomeClubBean() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getImg() {
        return img;
    }
    
    public void setImg(String img) {
        this.img = img;
    }
    
    public HomeClubBean(String title, String img) {
        super();
        this.title = title;
        this.img = img;
    }
    
    @Override
    public String toString() {
        return "HomeClubBean [title=" + title + ", img=" + img + "]";
    }
    
}
