package com.h13.che.core;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 14-3-19
 * Time: 下午4:57
 * To change this template use File | Settings | File Templates.
 */
public class H13RequestErrorException extends Exception {
    private int code = 0;

    public H13RequestErrorException(String msg) {
        super(msg);
    }

    public H13RequestErrorException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}


