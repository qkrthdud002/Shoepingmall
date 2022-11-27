package com.schoolproject.shoepingmall.buy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class BuyInsertDTO {

    @NotNull
    private int count;

    @NotNull
    private int price;

}
