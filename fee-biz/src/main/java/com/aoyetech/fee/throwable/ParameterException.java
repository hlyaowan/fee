/*
 * 
 */
// Created on 2013-8-7

package com.aoyetech.fee.throwable;

/**
 * @author joe.chen
 */
public class ParameterException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 8292179904081144037L;

    private int    code;

    private String msg;

    public ParameterException(int code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ParameterException(Throwable t){
        super(t);
    }

    public ParameterException(String msg, Throwable t){
        super(msg, t);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
