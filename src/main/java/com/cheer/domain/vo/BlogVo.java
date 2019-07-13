package com.cheer.domain.vo;

import com.cheer.domain.Blog;

public class BlogVo extends Blog {
    private  String replytime;
    private  String msg;

    public String getReplytime() {
        return replytime;
    }

    public void setReplytime(String replytime) {
        this.replytime = replytime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
