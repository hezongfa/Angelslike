package com.android.angelslike.utils.http;

public class HttpConstants {
    
    public static final String http = "http://";
    public static final String domain = http + "www.angelslike.com/";
    public static final String serverUrl = domain + "json/";
    public static final String imgurl1 = "http://img1.angelslike.com/";// 产品。主题图片
    public static final String imgurl2 = "http://img2.angelslike.com/";// 头像
    public static final String imgurl3 = "http://img3.angelslike.com/";// 用户上传
    /**
     * 产品
     */
    public static final String url_getList = serverUrl + "getList";
    /**
     * 广告
     */
    public static final String url_getslider = serverUrl + "getslider";
    /**
     * 登录
     */
//    public static final String url_login = serverUrl + "login";
    /**
     * 注册
     */
    // public static final String url_register = serverUrl + "register";
    /**
     * 凑份子详情
     */
    public static final String url_coufenzidetail = "http://www.angelslike.com/items.html?";
    
    // ---------------------------------
    public static final String new_serverUrl = "http://app.angelslike.com/";
    /**
     * 首页Banner
     */
    public static final String url_banner = new_serverUrl + "json/banner";
    
    /**
     * 主题列表
     */
    public static final String url_theme_lists = new_serverUrl + "theme/lists";
    /**
     * 主题明细
     */
    public static final String url_theme_detail = new_serverUrl + "theme/detail";
    /**
     * 注册
     */
    public static final String url_register = new_serverUrl + "index/register";
    /**
     * 登陆
     */
    public static final String url_login = new_serverUrl + "index/login";
    /**
     * 评论
     */
    public static final String url_review_lists = new_serverUrl + "review/lists";
  
    
}
