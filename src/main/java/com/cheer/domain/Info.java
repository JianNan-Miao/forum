package com.cheer.domain;

public class Info {
    private  int usernum;
    private  int blognum;
    private  int boardnum;

    public Info() {
    }

    public Info(int usernum, int blognum, int boardnum) {
        this.usernum = usernum;
        this.blognum = blognum;
        this.boardnum = boardnum;
    }

    public int getUsernum() {
        return usernum;
    }

    public void setUsernum(int usernum) {
        this.usernum = usernum;
    }

    public int getBlognum() {
        return blognum;
    }

    public void setBlognum(int blognum) {
        this.blognum = blognum;
    }

    public int getBoardnum() {
        return boardnum;
    }

    public void setBoardnum(int boardnum) {
        this.boardnum = boardnum;
    }

    @Override
    public String toString() {
        return "Info{" +
                "usernum=" + usernum +
                ", blognum=" + blognum +
                ", boardnum=" + boardnum +
                '}';
    }
}
