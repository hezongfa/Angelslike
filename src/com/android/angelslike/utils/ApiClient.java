package com.android.angelslike.utils;

import java.io.IOException;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.android.angelslike.utils.http.HttpConstants;
import com.android.angelslike.utils.http.JsonHelper;
import com.android.angelslike.utils.http.ApiClient.HttpCallBack;
import com.hzf.utils.JsonExplain;
import com.hzf.utils.print.FQL;
import com.lidroid.xutils.http.RequestParams;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class ApiClient {
    public interface HttpCallBack {
        
        public void onStart();
        
        public void onFailure(String msg);
        
        public void onSuccess(String result);
    }
    
    protected Context context;
    private static final String tag = ApiClient.class.getSimpleName();
    private static ApiClient apiClient;
    
    public static ApiClient getInstance(Context context) {
        if (apiClient == null) {
            apiClient = new ApiClient(context);
        }
        return apiClient;
    }
    
    public ApiClient(Context context) {
        this.context = context;
    }
    
    private void send(final String url, RequestBody requestBody, final HttpCallBack callback) {
        Request request = new Request.Builder().url(url).post(requestBody).build();
        final Message message = new Message();
        message.obj = callback;
        final Bundle bundle = new Bundle();
        handler.sendEmptyMessage(0);
        HttpClient.enqueue(request, new Callback() {
            
            @Override
            public void onResponse(Response arg0)
                throws IOException {
                // TODO Auto-generated method stub
                String result = arg0.body().string();
                FQL.d(tag, "onSuccess()--" + url + "-----------\n---result----" + result);
                int status = JsonExplain.getIntValue(result, JsonHelper.KEY_status);
                FQL.d(tag, "---status----" + status);
                String info = JsonExplain.getStringValue(result, JsonHelper.KEY_info);
                FQL.d(tag, "---info----" + info);
                String data = JsonExplain.getStringValue(result, JsonHelper.KEY_data);
                FQL.d(tag, "---data----" + data);
                
                if (status == 1) {
                    bundle.putString(JsonHelper.KEY_data, data);
                    message.what = 1;
                } else {
                    bundle.putString(JsonHelper.KEY_info, info);
                    message.what = 2;
                }
                message.setData(bundle);
                handler.sendMessage(message);
            }
            
            @Override
            public void onFailure(Request arg0, IOException arg1) {
                // TODO Auto-generated method stub
                FQL.e(tag, "onFailure()--" + url + "-----------" + arg1.getMessage());
                message.what = 2;
                bundle.putString(JsonHelper.KEY_info, "网络请求失败");
                handler.sendMessage(message);
            }
        });
    }
    Handler handler = new Handler() {
        
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            HttpCallBack callBack = (HttpCallBack)msg.obj;
            if (callBack == null) {
                return;
            }
            switch (msg.what) {
                case 0:
                    callBack.onStart();
                    break;
                case 1:
                    callBack.onSuccess(msg.getData().getString(JsonHelper.KEY_data));
                    break;
                case 2:
                    callBack.onFailure(msg.getData().getString(JsonHelper.KEY_info));
                    break;
            }
        }
        
    };
    
    public void theme_lists(String object, String sence, String sort, String page, HttpCallBack callback) {
        FormEncodingBuilder builder = new FormEncodingBuilder();
        builder.add("page", page);
        builder.add("object", object);
        builder.add("sort", sort);
        builder.add("sence", sence);
        send(HttpConstants.url_theme_lists, builder.build(), callback);
    }
    
    public void banner(String page, HttpCallBack callback) {
        FormEncodingBuilder builder = new FormEncodingBuilder();
        builder.add("page", page);
        send(HttpConstants.url_banner, builder.build(), callback);
    }
    
    public void login(String user, String password, String phone, String unionid, HttpCallBack callBack) {
        FormEncodingBuilder builder = new FormEncodingBuilder();
        builder.add("password", password);
        if (user != null) {
            builder.add("user", user);
        }
        if (phone != null) {
            builder.add("phone", phone);
        }
        if (unionid != null) {
            builder.add("unionid", unionid);
        }
        send(HttpConstants.url_login, builder.build(), callBack);
    }
    
    /**
     * 评论
     * 
     * @param id
     * @param type
     * @param callback
     */
    public void review_lists(String id, String type, HttpCallBack callback) {
        FormEncodingBuilder builder = new FormEncodingBuilder();
        builder.add("id", id);
        builder.add("type", type);
        send(HttpConstants.url_review_lists, builder.build(), callback);
    }
    
}
