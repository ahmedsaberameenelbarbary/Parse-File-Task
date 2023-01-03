package com.parse.service.exception.cust.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidFileException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 8791923496388627990L;

	public InvalidFileException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InvalidFileException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidFileException(String msg) {
		super(msg);
	}

}
