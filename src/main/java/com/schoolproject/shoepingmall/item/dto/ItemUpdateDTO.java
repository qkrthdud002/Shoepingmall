package com.schoolproject.shoepingmall.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@Builder
public class ItemUpdateDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private int price;

    @NotNull
    private int size;

    @NotNull
    private int quantity;

}
