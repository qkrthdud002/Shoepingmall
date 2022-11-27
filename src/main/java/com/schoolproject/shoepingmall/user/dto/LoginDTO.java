package com.schoolproject.shoepingmall.user.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDTO {

    @NotNull
    @Column(length = 20, nullable = false)
    private String username;

    @NotNull
    @Column(length = 25, nullable = false)
    private String password;

}
