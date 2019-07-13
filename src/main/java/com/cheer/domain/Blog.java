package com.cheer.domain;

public class Blog {
    private  int blogid;
    private  String theme;
    private  String text;
    private  String blogtime;
    private  String username;
    private  String useravatar;
    private  int sumbd;


    public Blog() {
    }

    public Blog(int blogid, String theme, String text, String blogtime, String username, String useravatar, int sumbd) {
        this.blogid = blogid;
        this.theme = theme;
        this.text = text;
        this.blogtime = blogtime;
        this.username = username;
        this.useravatar = useravatar;
        this.sumbd = sumbd;
    }

    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBlogtime() {
        return blogtime;
    }

    public void setBlogtime(String blogtime) {
        this.blogtime = blogtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseravatar() {
        return useravatar;
    }

    public void setUseravatar(String useravatar) {
        this.useravatar = useravatar;
    }

    public int getSumbd() {
        return sumbd;
    }

    public void setSumbd(int sumbd) {
        this.sumbd = sumbd;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogid=" + blogid +
                ", theme='" + theme + '\'' +
                ", text='" + text + '\'' +
                ", blogtime='" + blogtime + '\'' +
                ", username='" + username + '\'' +
                ", useravatar='" + useravatar + '\'' +
                ", sumbd=" + sumbd +
                '}';
    }
}
