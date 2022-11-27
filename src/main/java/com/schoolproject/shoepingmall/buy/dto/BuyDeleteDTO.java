package com.schoolproject.shoepingmall.buy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@Builder
public class BuyDeleteDTO {

    @NotNull
    private Long buyId;

}
