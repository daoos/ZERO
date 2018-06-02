package com.zeroyip.zero.util.exception;

/*
*
* 自定义异常类(实现手动抛出异常)
*
* */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}
