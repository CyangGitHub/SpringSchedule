package com.example.moudel.entity;

/**
 * Created by admin on 2016/11/18.
 */
public class WebLog {

    private String url;
    private String args;

    public WebLog(String url, String args) {
        this.url = url;
        this.args = args;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }
}
