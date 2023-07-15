package com.Learn.eduTrack.model;

import org.springframework.stereotype.Component;

@Component
public class ResponseMessage {

	private String message;
	private int status;
	private boolean error = false;
	

	@Override
	public String toString() {
		return "ResponseMessage [message=" + message + ", status=" + status + ", error=" + error + "]";
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean getError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	
}
