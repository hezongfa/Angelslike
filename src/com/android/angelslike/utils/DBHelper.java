package com.android.angelslike.utils;

import android.content.Context;

import com.android.angelslike.bean.dbbean.UserBean;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.DbUtils.DbUpgradeListener;
import com.lidroid.xutils.exception.DbException;

public class DBHelper {
    static DBHelper dbHelper;
    Context context;
    
    public static DBHelper getInstance(Context context) {
        if (dbHelper == null) {
            dbHelper = new DBHelper(context);
        }
        return dbHelper;
    }
    
    DbUtils dbUtils;
    
    public DBHelper(final Context context) {
        this.context = context;
        dbUtils = DbUtils.create(context, "angelslike_db", 1, new DbUpgradeListener() {
            
            @Override
            public void onUpgrade(DbUtils arg0, int arg1, int arg2) {
                // TODO Auto-generated method stub
                try {
                    if (dbUtils == null) {
                        dbUtils = DbUtils.create(context, "angelslike_db");
                    }
                    dbUtils.dropTable(UserBean.class);
                    dbUtils.createTableIfNotExist(UserBean.class);
                } catch (DbException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        try {
            dbUtils.createTableIfNotExist(UserBean.class);
        } catch (DbException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
}
