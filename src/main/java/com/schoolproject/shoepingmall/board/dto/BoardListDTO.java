package com.schoolproject.shoepingmall.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class BoardListDTO {

    private Long id;

    private String prizeName;

    private int price;

}
