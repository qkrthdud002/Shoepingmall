package com.schoolproject.shoepingmall.board.service;

import com.schoolproject.shoepingmall.board.Board;
import com.schoolproject.shoepingmall.board.dto.*;
import com.schoolproject.shoepingmall.board.repo.BoardRepository;
import com.schoolproject.shoepingmall.exception.NotSameIdException;
import com.schoolproject.shoepingmall.exception.WrongIdException;
import com.schoolproject.shoepingmall.item.service.ItemService;
import com.schoolproject.shoepingmall.photo.Photo;
import com.schoolproject.shoepingmall.photo.repo.PhotoRepository;
import com.schoolproject.shoepingmall.photo.service.FileHandler;
import com.schoolproject.shoepingmall.user.User;
import com.schoolproject.shoepingmall.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BoardServiceImpl implements BoardService{

    // 순환참조 문제 원인, 4주차 - 순환참조 문제 해결(setter 사용)
//    private BoardService boardService;

    private final BoardRepository boardRepository;

    private final UserRepository userRepository;

    private final FileHandler fileHandler;

    private final PhotoRepository photoRepository;

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
    public Board insert(BoardInsertDTO boardInsertDTO, List<MultipartFile> files, User user) throws IOException {

        Board board = Board.builder()
                .prizeName(boardInsertDTO.getPrizeName())
                .content(boardInsertDTO.getContent())
                .user(user)
                .build();

        List<Photo> photoList = fileHandler.parseFileInfo(files);

        // 파일이 존재할 때만 처리
        if(!photoList.isEmpty()) {
            for(Photo photo:photoList) {
                log.info("board file save");
                // 파일들을 DB에 저장
                board.addPhoto(photoRepository.save(photo));
            }
        }

        return boardRepository.save(board);
    }

    @Override
    public Board update(BoardUpdateDTO boardUpdateDTO, User user) {

        Board board = boardRepository.findById(boardUpdateDTO.getId()).orElseThrow(() -> new WrongIdException("board", boardUpdateDTO.getId()));

        if(user.getId() != board.getUser().getId()) {
            throw new NotSameIdException(board.getId());
        }

        board.modify(boardUpdateDTO.getPrizeName(), boardUpdateDTO.getContent());

        return board;
    }

    @Override
    public Long delete(BoardDeleteDTO boardDeleteDTO) {

        Board board = boardRepository.findById(boardDeleteDTO.getId()).orElseThrow(() -> new WrongIdException("board", boardDeleteDTO.getId()));

        boardRepository.delete(board);

        return board.getId();

    }

    @Override
    public List<BoardListDTO> getList(String search, Pageable pageable) {
        List<Board> list = boardRepository.findByPrizeNameContaining(search, pageable);
        List<BoardListDTO> result = new ArrayList<>();

        list.forEach(board -> {
            BoardListDTO boardListDTO = BoardListDTO.builder()
                    .id(board.getId())
                    .prizeName(board.getPrizeName())
                    .price(board.getItems().get(0).getPrice()) // item에서 첫번째 값의 가격을 가져온다.
                    .build();

            result.add(boardListDTO);
        });

        return result;
    }

    @Override
    public BoardViewDTO view(Long id) {

        Board board = boardRepository.findById(id).orElseThrow(() -> new WrongIdException("board", id));

        List<Integer> sizes = new ArrayList<>();

        board.getItems()
                .forEach(item -> {
                    sizes.add(item.getSize());
                });

        BoardViewDTO boardViewDTO = BoardViewDTO.builder()
                .id(board.getId())
                .prizeName(board.getPrizeName())
                .price(board.getItems().get(0).getPrice())
                .sizes(sizes)
                .build();

        return boardViewDTO;
    }
}
