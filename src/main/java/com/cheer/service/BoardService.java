package com.cheer.service;

import com.cheer.domain.Board;

import java.util.List;

public interface BoardService {
     void  insertBoard(Board board);

     List<Board> getBoard();

     List<Board> findBoard(Integer blogid);

     List<Board>  searchBoard(String username);

     void delBoard(Integer blogid);
}
