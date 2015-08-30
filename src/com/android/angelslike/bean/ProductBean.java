package com.android.angelslike.bean;

import com.hzf.bean.BaseBean;

public class ProductBean extends BaseBean {
    private String name;
    private double price;
    private String img;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getImg() {
        return img;
    }
    
    public void setImg(String img) {
        this.img = img;
    }
    
    public ProductBean(String name, double price, String img) {
        super();
        this.name = name;
        this.price = price;
        this.img = img;
    }
    
    @Override
    public String toString() {
        return "ProductBean [name=" + name + ", price=" + price + ", img=" + img + "]";
    }
    
    public ProductBean() {
        super();
        // TODO Auto-generated constructor stub
    }
    
}
