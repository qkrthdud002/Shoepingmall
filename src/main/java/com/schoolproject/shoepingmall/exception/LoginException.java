package com.schoolproject.shoepingmall.exception;

public class LoginException extends RuntimeException {

    public LoginException() {
        super("로그인 하지 않았습니다.");
    }
}
