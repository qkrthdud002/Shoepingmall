package com.schoolproject.shoepingmall.entity.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class UserInsertDTO {

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 5, max = 20)
    private String password;

}
