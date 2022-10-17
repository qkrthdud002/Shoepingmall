package com.schoolproject.shoepingmall.board.service;

import com.schoolproject.shoepingmall.board.Board;
import com.schoolproject.shoepingmall.board.dto.BoardDeleteDTO;
import com.schoolproject.shoepingmall.board.dto.BoardInsertDTO;
import com.schoolproject.shoepingmall.board.dto.BoardUpdateDTO;
import com.schoolproject.shoepingmall.board.repo.BoardRepository;
import com.schoolproject.shoepingmall.exception.NotSameIdException;
import com.schoolproject.shoepingmall.exception.WrongIdException;
import com.schoolproject.shoepingmall.user.User;
import com.schoolproject.shoepingmall.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BoardServiceImpl implements BoardService{

    // 순환참조 문제 원인, 4주차 - 순환참조 문제 해결(setter 사용)
//    private BoardService boardService;

    private final BoardRepository boardRepository;

    private final UserRepository userRepository;

//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

//    @Autowired
//    public void setBoardService(BoardService boardService) {
//        this.boardService = boardService;
//    }

//    @Autowired
//    public void setBoardRepository(BoardRepository boardRepository) {
//        this.boardRepository = boardRepository;
//    }

    @Override
    public Board insert(BoardInsertDTO boardInsertDTO) {

        User user = userRepository.findById(boardInsertDTO.getUserId()).orElseThrow(()-> new WrongIdException("board", boardInsertDTO.getUserId()));

        Board board = Board.builder()
                .prizeName(boardInsertDTO.getPrizeName())
                .content(boardInsertDTO.getContent())
                .user(user)
                .build();

        return boardRepository.save(board);
    }

    @Override
    public Board update(BoardUpdateDTO boardUpdateDTO) {

        Board board = boardRepository.findById(boardUpdateDTO.getId()).orElseThrow(() -> new WrongIdException("board", boardUpdateDTO.getId()));

        if(boardUpdateDTO.getUserId() != board.getUser().getId()) {
            throw new NotSameIdException(board.getId());
        }

        board.modify(boardUpdateDTO.getPrizeName(), boardUpdateDTO.getContent());

        return board;
    }

    @Override
    public void delete(BoardDeleteDTO boardDeleteDTO) {

        Board board = boardRepository.findById(boardDeleteDTO.getId()).orElseThrow(() -> new WrongIdException("board", boardDeleteDTO.getId()));

        boardRepository.delete(board);

    }
}
