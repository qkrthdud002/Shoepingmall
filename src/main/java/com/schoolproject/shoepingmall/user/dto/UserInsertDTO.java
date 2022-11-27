package com.schoolproject.shoepingmall.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UserInsertDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Builder
    public UserInsertDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
