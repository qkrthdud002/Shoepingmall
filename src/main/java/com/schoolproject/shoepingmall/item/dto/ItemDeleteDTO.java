package com.schoolproject.shoepingmall.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@Builder
public class ItemDeleteDTO {

    @NotNull
    private Long id;

}
