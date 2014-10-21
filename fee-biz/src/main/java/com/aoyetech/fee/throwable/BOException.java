/*
 * 
 */
// Created on 2013-3-24

package com.aoyetech.fee.throwable;

/**
 * @author joe.chen
 */
public class BOException extends RuntimeException {

    private static final long serialVersionUID = 145829665786329638L;

    private int               code;

    private String            msg;

    public BOException(int code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BOException(Throwable t){
        super(t);
    }

    public BOException(String msg, Throwable t){
        super(msg, t);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
