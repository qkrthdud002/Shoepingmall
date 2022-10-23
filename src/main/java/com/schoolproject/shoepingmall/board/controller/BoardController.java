package com.schoolproject.shoepingmall.board.controller;

import com.schoolproject.shoepingmall.board.Board;
import com.schoolproject.shoepingmall.board.dto.BoardDeleteDTO;
import com.schoolproject.shoepingmall.board.dto.BoardInsertDTO;
import com.schoolproject.shoepingmall.board.dto.BoardResponseDTO;
import com.schoolproject.shoepingmall.board.dto.BoardUpdateDTO;
import com.schoolproject.shoepingmall.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

//    @GetMapping("/write")
//    public String write() {
//
//        return "/write";
//    }

    @PostMapping("/wirtie")
    public ResponseEntity<BoardResponseDTO> write(@RequestBody @Valid BoardInsertDTO boardInsertDTO) {
        Board board = boardService.insert(boardInsertDTO);

        BoardResponseDTO boardResponseDTO = BoardResponseDTO.builder()
                .prizeName(board.getPrizeName())
                .content(board.getContent())
                .build();

        return ResponseEntity.ok().body(boardResponseDTO);
    }

    @PostMapping("/update")
    public ResponseEntity<BoardResponseDTO> update(@RequestBody @Valid BoardUpdateDTO boardUpdateDTO) {
        Board board = boardService.update(boardUpdateDTO);

        BoardResponseDTO boardResponseDTO = BoardResponseDTO.builder()
                .prizeName(board.getPrizeName())
                .content(board.getContent())
                .build();

        return ResponseEntity.ok().body(boardResponseDTO);

    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody @Valid BoardDeleteDTO boardDeleteDTO) {
        boardService.delete(boardDeleteDTO);

        return new ResponseEntity(HttpStatus.OK);
    }

}
