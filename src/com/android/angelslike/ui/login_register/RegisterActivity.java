package com.android.angelslike.ui.login_register;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.android.angelslike.R;
import com.android.angelslike.ui.ABaseActivity;
import com.android.angelslike.utils.http.ApiClient;
import com.android.angelslike.utils.http.ApiClient.HttpCallBack;
import com.hzf.utils.print.FQT;

public class RegisterActivity extends ABaseActivity implements OnClickListener {
    EditText etAccount, etPwd, etPwd_c, etPhone, etName;
    Button btnSubmit;
    
    @Override
    public void onCreateContentView() {
        // TODO Auto-generated method stub
        setTitle("用户注册");
        setMainContentView(R.layout.activity_register);
    }
    
    @Override
    public void onFindView() {
        // TODO Auto-generated method stub
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        etAccount = (EditText)findViewById(R.id.etAccount);
        etPwd = (EditText)findViewById(R.id.etPwd);
        etPwd_c = (EditText)findViewById(R.id.etPwd_c);
        etPhone = (EditText)findViewById(R.id.etPhone);
        etName = (EditText)findViewById(R.id.etName);
        btnSubmit.setOnClickListener(this);
    }
    
    @Override
    public void onPostLoad() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnSubmit:
                postData();
                break;
            
            default:
                break;
        }
    }
    
    private void postData() {
        if (etAccount.getText().length() == 0) {
            FQT.showShort(context, getString(R.string.accountnull));
            return;
        }
        if (etPwd.getText().length() == 0) {
            FQT.showShort(context, getString(R.string.pwdnull));
            return;
        }
        if (etPwd_c.getText().length() == 0) {
            FQT.showShort(context, "请确认密码");
            return;
        }
        if (!etPwd.getText().toString().equals(etPwd_c.getText().toString())) {
            FQT.showShort(context, "确认密码与密码不一致");
            return;
        }
        if (etPhone.getText().length() == 0) {
            FQT.showShort(context, "请输入手机号码");
            return;
        }
        if (etName.getText().length() == 0) {
            FQT.showShort(context, "请输入昵称");
            return;
        }
        ApiClient.getInstance(context).register(etAccount.getText().toString(),
            etPwd.getText().toString(),
            etPwd_c.getText().toString(),
            etPhone.getText().toString(),
            etName.getText().toString(),
            new HttpCallBack() {
                
                @Override
                public void onSuccess(String result) {
                    // TODO Auto-generated method stub
                    closeLoading();
                    FQT.showShort(context, "注册成功");
                }
                
                @Override
                public void onStart() {
                    // TODO Auto-generated method stub
                    showLoading();
                }
                
                @Override
                public void onLoading(long total, long current, boolean isUploading) {
                    // TODO Auto-generated method stub
                    
                }
                
                @Override
                public void onFailure(String msg) {
                    // TODO Auto-generated method stub
                    closeLoading();
                    FQT.showShort(context, msg);
                }
            });
        
    }
}
