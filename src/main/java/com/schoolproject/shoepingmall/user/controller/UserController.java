package com.schoolproject.shoepingmall.user.controller;

import com.schoolproject.shoepingmall.user.dto.UserInsertDTO;
import com.schoolproject.shoepingmall.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @GetMapping("/login")
//    public String login() {
//
//        return "/login";
//    }

//    @PostMapping("/login")
//    public String login() {
//
//
//    }

//    @GetMapping("/register")
//    public String register() {
//
//        return "/register";
//    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserInsertDTO userInsertDTO) {
        // @RequestBody만 사용하면 둘 다 안먹음. @Valid를 사용하게 되면 DTO에서 작성한 @NotNull, @NotBlank를 먹게 해준다.

        userService.join(userInsertDTO);

        return new ResponseEntity(HttpStatus.OK);

    }

}
