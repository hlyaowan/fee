package com.aoyetech.fee.domain.result;

/**
 * 
 * @author yyc
 * @ClassName ResultBean 返回结果
 * @date 2014年7月12日下午7:22:49
 */

public class ResultBean{
	private boolean result;				//返回结果
	
	private String message;				//返回信息

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
   
}