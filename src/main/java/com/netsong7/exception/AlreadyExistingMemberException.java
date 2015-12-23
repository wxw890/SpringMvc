package com.netsong7.exception;

public class AlreadyExistingMemberException extends RuntimeException {
	public AlreadyExistingMemberException(String msg){
		super(msg);
	}
}
