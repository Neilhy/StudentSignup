package com.hy.domain;

/**
 * Created by NeilHY on 2016/9/1.
 */
public class Admin {
    String name;
    String pwd;

    public Admin() {
    }

    public Admin(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
