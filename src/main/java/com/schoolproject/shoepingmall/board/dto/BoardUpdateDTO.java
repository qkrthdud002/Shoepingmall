package com.schoolproject.shoepingmall.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardUpdateDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String prizeName;

    @NotBlank
    private String content;

    @NotNull
    private Long userId;

}
