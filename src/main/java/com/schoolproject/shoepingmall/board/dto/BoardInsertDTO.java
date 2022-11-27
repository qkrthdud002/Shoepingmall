package com.schoolproject.shoepingmall.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class BoardInsertDTO {

    @NotBlank
    private String prizeName;

    @NotBlank
    private String content;

    @Builder
    public BoardInsertDTO(String prizeName, String content) {
        this.prizeName = prizeName;
        this.content = content;
    }

}
