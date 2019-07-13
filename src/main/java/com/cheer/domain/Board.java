package com.cheer.domain;

public class Board {
    private  int boardid;
    private  String username;
    private  int blogid;
    private  String msg;
    private  String boardtime;
    private  String useravatar;

    public Board() {
    }

    public Board(int boardid, String username, int blogid, String msg, String boardtime, String useravatar) {
        this.boardid = boardid;
        this.username = username;
        this.blogid = blogid;
        this.msg = msg;
        this.boardtime = boardtime;
        this.useravatar = useravatar;
    }

    public int getBoardid() {
        return boardid;
    }

    public void setBoardid(int boardid) {
        this.boardid = boardid;
    }


    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getBoardtime() {
        return boardtime;
    }

    public void setBoardtime(String boardtime) {
        this.boardtime = boardtime;
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

    @Override
    public String toString() {
        return "Board{" +
                "boardid=" + boardid +
                ", username='" + username + '\'' +
                ", blogid=" + blogid +
                ", msg='" + msg + '\'' +
                ", boardtime='" + boardtime + '\'' +
                ", useravatar='" + useravatar + '\'' +
                '}';
    }
}
