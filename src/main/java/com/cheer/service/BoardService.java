package com.cheer.service;

import com.cheer.domain.Board;

import java.util.List;

public interface BoardService {
    public void  insertBoard(Board board);

    public List<Board> getBoard();

    public List<Board> findBoard(Integer blogid);

    public List<Board>  searchBoard(String username);
}
