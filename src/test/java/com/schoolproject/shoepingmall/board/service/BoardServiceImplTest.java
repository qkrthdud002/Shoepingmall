package com.schoolproject.shoepingmall.board.service;

import com.schoolproject.shoepingmall.board.Board;
import com.schoolproject.shoepingmall.board.dto.BoardDeleteDTO;
import com.schoolproject.shoepingmall.board.dto.BoardInsertDTO;
import com.schoolproject.shoepingmall.board.dto.BoardUpdateDTO;
import com.schoolproject.shoepingmall.exception.WrongIdException;
import com.schoolproject.shoepingmall.user.User;
import com.schoolproject.shoepingmall.user.dto.UserInsertDTO;
import com.schoolproject.shoepingmall.user.dto.UserUpdateDTO;
import com.schoolproject.shoepingmall.user.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class BoardServiceImplTest {

    @Autowired
    BoardService boardService;

    @Autowired
    UserService userService;

    @Test
    void 저장() throws IOException {

        User user = createUser("천사");

        BoardInsertDTO boardInsertDTO = BoardInsertDTO.builder()
                .prizeName("aaa")
                .content("aaaaa")
                .build();

        Board board = boardService.insert(boardInsertDTO, null, null);

        assertThat(board.getPrizeName()).isEqualTo(boardInsertDTO.getPrizeName());


//        BoardInsertDTO boardInsertDTO =

    }

    @Test
    void 등록에러() {

        User user = createUser("aaa");

        assertThrows(WrongIdException.class, ()->{
            createBoard(user.getId() + 1);
        });

    }

    @Test
    void 수정() throws IOException {

        User user = createUser("bbb");

        Board board = createBoard(user.getId());
        BoardUpdateDTO boardUpdateDTO = BoardUpdateDTO.builder()
                .prizeName("qqq")
                .content("ccc")
                .id(board.getId())
                .build();

        Board modify = boardService.update(null, null);

        assertThat(board.getPrizeName()).isEqualTo(boardUpdateDTO.getPrizeName()).isEqualTo(modify.getPrizeName());


    }

    @Test
    void 삭제() throws IOException {

        User user = createUser("ggg");
        Board board = createBoard(user.getId());

        BoardDeleteDTO boardDeleteDTO = BoardDeleteDTO.builder()
                .id(board.getId())
                .build();

        Long boardId = boardService.delete(boardDeleteDTO);

        assertThat(board.getId()).isEqualTo(boardDeleteDTO.getId()).isEqualTo(boardId);

    }

    private User createUser(String username) {

        UserInsertDTO userInsertDTO = UserInsertDTO.builder()
                    .username(username)
                    .password("1234")
                    .build();

        return userService.join(userInsertDTO);

    }

    private Board createBoard(Long userId) throws IOException {

        BoardInsertDTO boardInsertDTO = BoardInsertDTO.builder()
                .prizeName("aaa")
                .content("aaaaa")
                .build();

        return boardService.insert(boardInsertDTO, null, null);

    }
}