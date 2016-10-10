package com.mercacortex.loginrelative.model;

public class User {
    private String usr, pwd;

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User(String usr, String pwd) {
        this.usr = usr;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "usr='" + usr + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
