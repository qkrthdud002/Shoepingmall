package com.schoolproject.shoepingmall.exception;

public class WrongIdException extends RuntimeException {

    public WrongIdException(String entity, Long id) {
        super(entity + " " + id + " 잘못된 아이디 입니다");
    }
}
