package com.android.angelslike.utils.http;

import android.content.Context;

import com.hzf.utils.JsonExplain;
import com.hzf.utils.print.FQL;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class ApiClient {
    
    /**
     * 主题明细
     * 
     * @param id
     * @param callBack
     */
    public void theme_detail(String id, HttpCallBack callBack) {
        RequestParams params = getReQuestParams();
        params.addBodyParameter("id", id);
        sendHttp(HttpConstants.url_theme_detail, params, callBack);
    }
    
    /**
     * 首页banner
     * 
     * @param page
     * @param callBack
     */
    public void banner(String page, HttpCallBack callBack) {
        RequestParams params = getReQuestParams();
        params.addBodyParameter("page", page);
        sendHttp(HttpConstants.url_banner, params, callBack);
    }
    
    /**
     * 主题列表
     * 
     * @param object
     * @param sence
     * @param sort
     * @param page
     * @param callBack
     */
    public void theme_lists(String object, String sence, String sort, String page, HttpCallBack callBack) {
        RequestParams params = getReQuestParams();
        params.addBodyParameter("page", page);
        params.addBodyParameter("sort", sort);
        params.addBodyParameter("object", object);
        params.addBodyParameter("sence", sence);
        sendHttp(HttpConstants.url_theme_lists, params, callBack);
    }
    
    public interface HttpCallBack {
        
        public void onStart();
        
        public void onLoading(long total, long current, boolean isUploading);
        
        public void onFailure(String msg);
        
        public void onSuccess(String result);
    }
    
    protected Context context;
    private static final String tag = ApiClient.class.getSimpleName();
    private HttpUtils httpUtils;
    private HttpMethod method = HttpMethod.POST;
    private static ApiClient apiClient;
    
    public static ApiClient getInstance(Context context) {
        if (apiClient == null) {
            apiClient = new ApiClient(context);
        }
        return apiClient;
    }
    
    public ApiClient(Context context) {
        this.context = context;
        httpUtils = new HttpUtils(20000, "Angelslike");
    }
    
    public void sendHttp(final String url, final RequestParams params, final HttpCallBack callBack) {
        // httpUtils.configCookieStore(cookieStore);
        httpUtils.send(method, url, params, new RequestCallBack<String>() {
            
            @Override
            public void onCancelled() {
                // TODO Auto-generated method stub
                super.onCancelled();
                FQL.d(tag, "onCancelled()--" + url);
            }
            
            @Override
            public void onLoading(long total, long current, boolean isUploading) {
                // TODO Auto-generated method stub
                super.onLoading(total, current, isUploading);
                // FQL.d(tag, "onLoading()--" + url);
                callBack.onLoading(total, current, isUploading);
            }
            
            @Override
            public void onStart() {
                // TODO Auto-generated method stub
                super.onStart();
                FQL.d(tag, "onStart()--" + url);
                callBack.onStart();
            }
            
            @Override
            public void onFailure(HttpException arg0, String arg1) {
                // TODO Auto-generated method stub
                FQL.e(tag, "onFailure()--" + url + "---ex----" + arg1);
                callBack.onFailure("网络请求失败");
            }
            
            @Override
            public void onSuccess(ResponseInfo<String> arg0) {
                // TODO Auto-generated method stub
                
                FQL.d(tag, "onSuccess()--" + url + "---result----" + arg0.result);
                int status = JsonExplain.getIntValue(arg0.result, JsonHelper.KEY_status);
                FQL.d(tag, "onSuccess()--" + url + "---status----" + status);
                String info = JsonExplain.getStringValue(arg0.result, JsonHelper.KEY_info);
                FQL.d(tag, "onSuccess()--" + url + "---info----" + info);
                String data = JsonExplain.getStringValue(arg0.result, JsonHelper.KEY_data);
                FQL.d(tag, "onSuccess()--" + url + "---data----" + data);
                if (status == 1) {
                    callBack.onSuccess(data);
                } else {
                    callBack.onFailure(info);
                }
            }
        });
    }
    
    private RequestParams getReQuestParams() {
        RequestParams params = new RequestParams();
        return params;
    }
    
    /**
     * 获取广告
     * 
     * @param callBack
     */
    public void getslider(HttpCallBack callBack) {
        RequestParams params = getReQuestParams();
        sendHttp(HttpConstants.url_getslider, params, callBack);
    }
    
    /**
     * 首页： type=list_theme 凑份子：type=list_cou
     * 
     * @param type
     * @param page
     * @param coutype
     * @param status
     * @param sort
     * @param key
     * @param callBack
     */
    public void getList(String type, String page, String coutype, String status, String sort, String key,
        String object, String scenes, HttpCallBack callBack) {
        RequestParams params = getReQuestParams();
        params.addBodyParameter("type", type);
        params.addBodyParameter("page", page);
        params.addBodyParameter("coutype", coutype);
        params.addBodyParameter("status", status);
        params.addBodyParameter("sort", sort);
        params.addBodyParameter("key", key);
        params.addBodyParameter("object", object);
        params.addBodyParameter("scenes", scenes);
        sendHttp(HttpConstants.url_getList, params, callBack);
    }
    
    /**
     * 登录（账号）
     * 
     * @param use
     * @param password
     * @param callBack
     */
    public void login(String user, String password, String phone, String unionid, HttpCallBack callBack) {
        RequestParams params = getReQuestParams();
        params.addBodyParameter("password", password);
        if (user != null) {
            params.addBodyParameter("user", user);
        }
        if (phone != null) {
            params.addBodyParameter("phone", phone);
        }
        if (unionid != null) {
            params.addBodyParameter("unionid", unionid);
        }
        sendHttp(HttpConstants.url_login, params, callBack);
    }
    
    /**
     * 注册
     * 
     * @param user
     * @param password
     * @param password2
     * @param phone
     * @param name
     * @param callBack
     */
    public void register(String user, String password, String password2, String phone, String name,
        HttpCallBack callBack) {
        RequestParams params = getReQuestParams();
        params.addBodyParameter("name", name);
        params.addBodyParameter("phone", phone);
        params.addBodyParameter("password2", password2);
        params.addBodyParameter("password", password);
        params.addBodyParameter("user", user);
        sendHttp(HttpConstants.url_register, params, callBack);
    }
    
    /**
     * 获取凑份子详情
     * 
     * @param id
     * @param type
     * @param callBack
     */
    public void piecedetail(String id, String type, HttpCallBack callBack) {
        RequestParams params = getReQuestParams();
        params.addBodyParameter("id", id);
        params.addBodyParameter("type", type);
        params.addBodyParameter("json", "1");
        sendHttp(HttpConstants.url_coufenzidetail, params, callBack);
    }
}
