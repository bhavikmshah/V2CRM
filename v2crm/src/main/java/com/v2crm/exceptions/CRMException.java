package com.v2crm.exceptions;

public class CRMException extends RuntimeException{

	public CRMException(){
		super();
	}
	
	public CRMException(String message){
		super(message);
	}
	
	public CRMException(String message, Throwable t){
		super(message, t);
	}

}
