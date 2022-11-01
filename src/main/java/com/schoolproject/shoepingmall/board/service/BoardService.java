package com.schoolproject.shoepingmall.board.service;


import com.schoolproject.shoepingmall.board.Board;
import com.schoolproject.shoepingmall.board.dto.*;

import java.awt.print.Pageable;
import java.util.List;

public interface BoardService {
    public Board insert(BoardInsertDTO boardInsertDTO);
    public Board update(BoardUpdateDTO boardUpdateDTO);
    public Long delete(BoardDeleteDTO boardDeleteDTO);
    public List<BoardListDTO> getList(String search);
    public BoardViewDTO view(BoardViewDTO boardViewDTO);
}
