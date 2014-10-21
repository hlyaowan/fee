package com.aoyetech.fee.domain.base;

import java.io.Serializable;


public class Message implements Serializable {

    /**
     * 
     */
    
    public static final String JSON_ROOT_NAME = "";
    private static final long serialVersionUID = 1L;
    private int status;
    private String message;
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
}
