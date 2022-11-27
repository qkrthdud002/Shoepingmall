package com.schoolproject.shoepingmall.exception;

public class BuyCountException extends RuntimeException {

    public BuyCountException(int count) {
        super(count + ", 이 0이하 입니다.");
    }
}
