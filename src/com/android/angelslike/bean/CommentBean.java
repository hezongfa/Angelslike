package com.android.angelslike.bean;

import com.hzf.bean.BaseBean;

public class CommentBean extends BaseBean {
    
    // 字段 说明
    // uid 用户id
    // uname 用户名称
    // uimg 用户头像
    // pid 当前评论的唯一id
    // status 状态
    // type 类型
    // comment 评论
    // time 时间
    
    private long uid;
    private String uname;
    private String uimg;
    private long pid;
    private long status;
    private long type;
    private String comment;
    private String time;
    
    public long getUid() {
        return uid;
    }
    
    public void setUid(long uid) {
        this.uid = uid;
    }
    
    public String getUname() {
        return uname;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }
    
    public String getUimg() {
        return uimg;
    }
    
    public void setUimg(String uimg) {
        this.uimg = uimg;
    }
    
    public long getPid() {
        return pid;
    }
    
    public void setPid(long pid) {
        this.pid = pid;
    }
    
    public long getStatus() {
        return status;
    }
    
    public void setStatus(long status) {
        this.status = status;
    }
    
    public long getType() {
        return type;
    }
    
    public void setType(long type) {
        this.type = type;
    }
    
    public String getComment() {
        return comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public String getTime() {
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    @Override
    public String toString() {
        return "CommentBean [uid=" + uid + ", uname=" + uname + ", uimg=" + uimg + ", pid=" + pid + ", status="
            + status + ", type=" + type + ", comment=" + comment + ", time=" + time + "]";
    }
    
}
