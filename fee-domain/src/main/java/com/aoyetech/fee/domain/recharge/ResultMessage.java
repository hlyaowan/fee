package com.aoyetech.fee.domain.recharge;

public class ResultMessage {

    private int    status;
    private String message;
    private String picVCodeURL;
    private String confirmId;



    public String getConfirmId() {
        return confirmId;
    }

    public void setConfirmId(String confirmId) {
        this.confirmId = confirmId;
    }

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

    public String getPicVCodeURL() {
        return picVCodeURL;
    }

    public void setPicVCodeURL(String picVCodeURL) {
        this.picVCodeURL = picVCodeURL;
    }
}
