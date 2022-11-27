package com.schoolproject.shoepingmall.board.controller;

import com.schoolproject.shoepingmall.board.Board;
import com.schoolproject.shoepingmall.board.dto.*;
import com.schoolproject.shoepingmall.board.service.BoardService;
import com.schoolproject.shoepingmall.exception.LoginException;
import com.schoolproject.shoepingmall.jwt.util.SecurityUtil;
import com.schoolproject.shoepingmall.user.User;
import com.schoolproject.shoepingmall.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final UserRepository userRepository;

    @GetMapping("/view/{id}")
    public ResponseEntity<BoardViewDTO> view(@PathVariable("id")Long id) { //ㅁㄴㅇ.html/

        BoardViewDTO boardViewDTO = boardService.view(id);

        return ResponseEntity.ok().body(boardViewDTO);
    }

    @PostMapping("/write")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<BoardResponseDTO> write(@RequestPart @Valid BoardInsertDTO boardInsertDTO,
                                                  @RequestPart(required = false) List<MultipartFile> files) throws IOException {
        User user = SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername).orElseThrow(() -> new LoginException());

        Board board = boardService.insert(boardInsertDTO, files, user);

        BoardResponseDTO boardResponseDTO = BoardResponseDTO.builder()
                .prizeName(board.getPrizeName())
                .content(board.getContent())
                .build();

        return ResponseEntity.ok().body(boardResponseDTO);
    }

    @PostMapping("/update")
    public ResponseEntity<BoardResponseDTO> update(@RequestBody @Valid BoardUpdateDTO boardUpdateDTO) {

        User user = SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername).orElseThrow(() -> new LoginException());

        Board board = boardService.update(boardUpdateDTO, user);

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

    @GetMapping("/")
    public ResponseEntity<List<BoardListDTO>> getList(@RequestParam(required = false, defaultValue = "") String search,
                                                      @PageableDefault(sort = "id", direction = Sort.Direction.DESC)  Pageable pageable) {
        List<BoardListDTO> list = boardService.getList(search, pageable);

        return ResponseEntity.ok().body(list);
    }

}
