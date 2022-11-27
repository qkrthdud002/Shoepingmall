package com.schoolproject.shoepingmall.user.controller;

import com.schoolproject.shoepingmall.jwt.JwtFilter;
import com.schoolproject.shoepingmall.jwt.TokenProvider;
import com.schoolproject.shoepingmall.user.dto.LoginDTO;
import com.schoolproject.shoepingmall.user.dto.TokenDTO;
import com.schoolproject.shoepingmall.user.dto.UserInsertDTO;
import com.schoolproject.shoepingmall.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

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

    @PostMapping("/authenticate")
    public ResponseEntity<TokenDTO> authorize(@Valid @RequestBody LoginDTO loginDTO) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new TokenDTO(jwt), httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserInsertDTO userInsertDTO) {
        // @RequestBody만 사용하면 둘 다 안먹음. @Valid를 사용하게 되면 DTO에서 작성한 @NotNull, @NotBlank를 먹게 해준다.

        userService.join(userInsertDTO);

        return new ResponseEntity(HttpStatus.OK);

    }

}
