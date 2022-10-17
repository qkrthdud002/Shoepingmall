package com.schoolproject.shoepingmall.board.service;


import com.schoolproject.shoepingmall.board.Board;
import com.schoolproject.shoepingmall.board.dto.BoardDeleteDTO;
import com.schoolproject.shoepingmall.board.dto.BoardInsertDTO;
import com.schoolproject.shoepingmall.board.dto.BoardUpdateDTO;

public interface BoardService {
    public Board insert(BoardInsertDTO boardInsertDTO);
    public Board update(BoardUpdateDTO boardUpdateDTO);
    public void delete(BoardDeleteDTO boardDeleteDTO);
}
