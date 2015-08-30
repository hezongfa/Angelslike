package com.android.angelslike.ui.user;

import android.widget.Button;
import android.widget.EditText;

import com.android.angelslike.R;
import com.android.angelslike.ui.ABaseActivity;

public class EditInfoActivity extends ABaseActivity {
    EditText etName, etAddress, etPhone, etPwd, etPwd_c;
    Button btnSubmit;
    @Override
    public void onCreateContentView() {
        // TODO Auto-generated method stub
        setMainContentView(R.layout.activity_edituserinfo);
        setTitle("编辑资料");
    }
    
    @Override
    public void onFindView() {
        // TODO Auto-generated method stub
        etName = (EditText)findViewById(R.id.etName);
        etAddress = (EditText)findViewById(R.id.etAddress);
        etPhone = (EditText)findViewById(R.id.etPhone);
        etPwd = (EditText)findViewById(R.id.etPwd);
        etPwd_c = (EditText)findViewById(R.id.etPwd_c);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
    }
    
    @Override
    public void onPostLoad() {
        // TODO Auto-generated method stub
        
    }
    
}
