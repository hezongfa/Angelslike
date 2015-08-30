package com.android.angelslike.bean;

public class CommodityBean {
    
    private String name;
    private String img;
    private String price;
    private String content;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getImg() {
        return img;
    }
    
    public void setImg(String img) {
        this.img = img;
    }
    
    public String getPrice() {
        return price;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
    
    public CommodityBean() {
        super();
        // TODO Auto-generated constructor stub
    }
    
}
