package com.learn.RESTApi.CustomExceptions;

public class ExceptionManager extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int statusCode;
	public ExceptionManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionManager(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ExceptionManager(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionManager(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ExceptionManager(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public ExceptionManager(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
		// TODO Auto-generated constructor stub
	}
	
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
