package com.cheer.service.impl;

import com.cheer.dao.BoardMapper;
import com.cheer.domain.Board;
import com.cheer.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;
    @Override
    public void insertBoard(Board board) {
        boardMapper.insertBoard(board);
    }

    @Override
    public List<Board> getBoard() {
        return boardMapper.getBoard();

    }

    @Override
    public List<Board> findBoard(Integer blogid) {
        return boardMapper.findBoard(blogid);
    }

    @Override
    public List<Board> searchBoard(String username) {
         List<Board> boardList=boardMapper.searchBoard(username);
         return boardList;
    }

    @Override
    public void delBoard(Integer blogid) {
        boardMapper.delBoard(blogid);
    }
}
