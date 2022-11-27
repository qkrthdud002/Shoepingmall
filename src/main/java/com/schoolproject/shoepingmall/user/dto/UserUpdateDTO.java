package com.schoolproject.shoepingmall.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
public class UserUpdateDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Builder
    public UserUpdateDTO(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


}
