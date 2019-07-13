package com.cheer.domain;




public class User {
    private  int userid;
    private  String username;
    private  String password;
    private  String avatar;
    private  String registtime;

    public User() {
    }

    public User(int userid, String username, String password, String avatar, String registtime) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.registtime = registtime;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRegisttime() {
        return registtime;
    }

    public void setRegisttime(String registtime) {
        this.registtime = registtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", registtime='" + registtime + '\'' +
                '}';
    }
}
