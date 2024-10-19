package com.blogpost.blog.entities;


public class ResponseModel<T> {

	private int statusCode;
	private String errorMessage;
	private Object data;

	public ResponseModel() {
	} 

	public ResponseModel(int statusCode, String errorMessage, Object data) {
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.data = data;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}

