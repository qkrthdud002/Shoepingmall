package com.schoolproject.shoepingmall.item.dto;

import com.schoolproject.shoepingmall.board.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@Builder
public class ItemInsertDTO {

    @NotBlank
    private String name;

    @NotNull
    private int price;

    @NotNull
    private int size;

    @NotNull
    private int quantity;

    @NotNull
    private Long boardId;



}
