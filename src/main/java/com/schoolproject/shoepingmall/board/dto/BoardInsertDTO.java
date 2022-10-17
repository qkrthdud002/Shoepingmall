package com.schoolproject.shoepingmall.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class BoardInsertDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String prizeName;

    @NotBlank
    private String content;

    @NotNull
    private Long userId;

    @Builder
    public BoardInsertDTO(Long id, String prizeName, String content, Long userId) {
        this.id = id;
        this.prizeName = prizeName;
        this.content = content;
        this.userId = userId;
    }

}
