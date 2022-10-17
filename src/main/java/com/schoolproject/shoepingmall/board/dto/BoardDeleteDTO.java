package com.schoolproject.shoepingmall.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class BoardDeleteDTO {

    @NotNull
    private Long id;

    @Builder
    public BoardDeleteDTO(Long id) {
        this.id = id;
    }

}
