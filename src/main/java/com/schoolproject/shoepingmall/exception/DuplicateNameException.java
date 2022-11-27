package com.schoolproject.shoepingmall.exception;

public class DuplicateNameException extends RuntimeException {

    public DuplicateNameException(String name) {
        super(name + "중복");
    }
}
