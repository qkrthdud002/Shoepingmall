package com.schoolproject.shoepingmall.board.service;


import com.schoolproject.shoepingmall.board.Board;
import com.schoolproject.shoepingmall.board.dto.*;
import com.schoolproject.shoepingmall.user.User;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BoardService {
    public Board insert(BoardInsertDTO boardInsertDTO, List<MultipartFile> files, User user) throws IOException;
    public Board update(BoardUpdateDTO boardUpdateDTO, User user);
    public Long delete(BoardDeleteDTO boardDeleteDTO);
    public List<BoardListDTO> getList(String search, Pageable pageable);
    public BoardViewDTO view(Long id);
}
