package com.android.angelslike.bean;

import java.util.ArrayList;

public class ThemeDetailBean {
    
    private String code;
    private String img;
    private String content;
    private long praise;
    private long review;
    private long share;
    private long status;
    private ArrayList<CommodityBean> details;
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getImg() {
        return img;
    }
    
    public void setImg(String img) {
        this.img = img;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public long getPraise() {
        return praise;
    }
    
    public void setPraise(long praise) {
        this.praise = praise;
    }
    
    public long getReview() {
        return review;
    }
    
    public void setReview(long review) {
        this.review = review;
    }
    
    public long getShare() {
        return share;
    }
    
    public void setShare(long share) {
        this.share = share;
    }
    
    public long getStatus() {
        return status;
    }
    
    public void setStatus(long status) {
        this.status = status;
    }
    
    public ArrayList<CommodityBean> getDetails() {
        return details;
    }
    
    public void setDetails(ArrayList<CommodityBean> details) {
        this.details = details;
    }
    
    public ThemeDetailBean(String code, String img, String content, long praise, long review, long share, long status,
        ArrayList<CommodityBean> details) {
        super();
        this.code = code;
        this.img = img;
        this.content = content;
        this.praise = praise;
        this.review = review;
        this.share = share;
        this.status = status;
        this.details = details;
    }
    
    public ThemeDetailBean() {
        super();
        // TODO Auto-generated constructor stub
    }
    
}
