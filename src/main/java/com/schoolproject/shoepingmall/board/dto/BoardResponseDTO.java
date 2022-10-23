package com.schoolproject.shoepingmall.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@Builder
public class BoardResponseDTO {

    @NotBlank
    private String prizeName;

    @NotBlank
    private String content;

}
