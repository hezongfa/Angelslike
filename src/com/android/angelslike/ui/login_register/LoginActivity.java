package com.android.angelslike.ui.login_register;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.angelslike.R;
import com.android.angelslike.bean.dbbean.UserBean;
import com.android.angelslike.ui.ABaseActivity;
import com.hzf.utils.JsonExplain;
import com.hzf.utils.print.FQT;

public class LoginActivity extends ABaseActivity implements OnClickListener {
    EditText etAccount, etPwd;
    Button btnSubmit, btnWCLogin;
    TextView tvRegister, tvFindPwd;
    
    @Override
    public void onCreateContentView() {
        // TODO Auto-generated method stub
        setMainContentView(R.layout.activity_login);
    }
    
    @Override
    public void onFindView() {
        // TODO Auto-generated method stub
        setTitle("用户登录");
        etAccount = (EditText)findViewById(R.id.etAccount);
        etPwd = (EditText)findViewById(R.id.etPwd);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnWCLogin = (Button)findViewById(R.id.btnWCLogin);
        tvRegister = (TextView)findViewById(R.id.tvRegister);
        tvFindPwd = (TextView)findViewById(R.id.tvFindPwd);
        btnSubmit.setOnClickListener(this);
        btnWCLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        tvFindPwd.setOnClickListener(this);
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
                if (etAccount.getText().length() == 0) {
                    FQT.showShort(context, getString(R.string.accountnull));
                    return;
                }
                if (etPwd.getText().length() == 0) {
                    FQT.showShort(context, getString(R.string.pwdnull));
                    return;
                }
                com.android.angelslike.utils.ApiClient.getInstance(context).login(etAccount.getText().toString(),
                    etPwd.getText().toString(),
                    null,
                    null,
                    new com.android.angelslike.utils.ApiClient.HttpCallBack() {
                        
                        @Override
                        public void onSuccess(String result) {
                            // TODO Auto-generated method stub
                            UserBean userBean = (UserBean)JsonExplain.explainJson(result, UserBean.class);
                        }
                        
                        @Override
                        public void onStart() {
                            // TODO Auto-generated method stub
                            
                        }
                        
                        @Override
                        public void onFailure(String msg) {
                            // TODO Auto-generated method stub
                            
                        }
                    });
                
                // ApiClient.getInstance(context).login(etAccount.getText().toString(),
                // etPwd.getText().toString(),
                // null,
                // null,
                // new HttpCallBack() {
                //
                // @Override
                // public void onSuccess(String result) {
                // // TODO Auto-generated method stub
                // UserBean userBean = (UserBean)JsonExplain.explainJson(result, UserBean.class);
                // }
                //
                // @Override
                // public void onStart() {
                // // TODO Auto-generated method stub
                //
                // }
                //
                // @Override
                // public void onLoading(long total, long current, boolean isUploading) {
                // // TODO Auto-generated method stub
                //
                // }
                //
                // @Override
                // public void onFailure(String msg) {
                // // TODO Auto-generated method stub
                //
                // }
                // });
                break;
            case R.id.btnWCLogin:
                
                break;
            case R.id.tvRegister:
                Intent intent = new Intent(context, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.tvFindPwd:
                
                break;
            default:
                break;
        }
    }
}
