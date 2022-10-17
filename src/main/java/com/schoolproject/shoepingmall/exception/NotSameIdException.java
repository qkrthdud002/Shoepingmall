package com.schoolproject.shoepingmall.exception;

public class NotSameIdException extends RuntimeException {
    public NotSameIdException(Long id) {
        super(id + " 아이디가 같지 않습니다.");
    }
}
