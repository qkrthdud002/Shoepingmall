package com.schoolproject.shoepingmall.buy.controller;

import com.schoolproject.shoepingmall.board.dto.BoardListDTO;
import com.schoolproject.shoepingmall.board.service.BoardService;
import com.schoolproject.shoepingmall.buy.Buy;
import com.schoolproject.shoepingmall.buy.dto.BuyDeleteDTO;
import com.schoolproject.shoepingmall.buy.dto.BuyInsertDTO;
import com.schoolproject.shoepingmall.buy.service.BuyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BuyController {

    private final BuyService buyService;

    private final BoardService boardService;

    @PostMapping("/buy")
    public ResponseEntity<List<BoardListDTO>> buy(@RequestBody @Valid BuyInsertDTO buyInsertDTO, Pageable pageable) {

        Buy buy = buyService.insert(buyInsertDTO);

        List<BoardListDTO> list = boardService.getList("", pageable);

        return ResponseEntity.ok().body(list);

    }

    @PostMapping("/buy_delete")
    public ResponseEntity<List<BoardListDTO>> buyDelete(@RequestBody @Valid BuyDeleteDTO buyDeleteDTO, Pageable pageable) {

        buyService.delete(buyDeleteDTO);

        List<BoardListDTO> list = boardService.getList("", pageable);

        return ResponseEntity.ok().body(list);
    }

}
