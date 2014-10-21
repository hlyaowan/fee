/*
 * 
 */
// Created on 2013-4-29

package com.aoyetech.fee.domain.error;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author joe.chen
 */
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class Error {

    public static final Error SYS_ERROR = new Error(999999, "系统异常");
    @XmlElement(name = "code")
    private int               code;
    @XmlElement(name = "message")
    private String            msg;

    @JsonProperty("code")
    public int getCode() {
        return code;
    }

    @JsonProperty("message")
    public String getMsg() {
        return msg;
    }

    public Error(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Error(){
    }
}
