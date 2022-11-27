package com.schoolproject.shoepingmall.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UserDeleteDTO {

    @NotNull
    private Long id;

    @Builder
    public UserDeleteDTO(Long id) {
        this.id = id;
    }

}


