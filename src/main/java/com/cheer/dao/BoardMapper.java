package com.cheer.dao;

import com.cheer.domain.Board;

import java.util.List;

public interface BoardMapper {
    public void  insertBoard(Board board);

    public List<Board> getBoard();

    public List<Board> findBoard(Integer blogid);

    public List<Board>  searchBoard(String username);
}
