package com.parse.service.exception.cust.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnParseException extends RuntimeException {

    /**
	 *
	 */
	private static final long serialVersionUID = -4354117561239653414L;

	public UnParseException(String msg) {
        super(msg);
    }
	public UnParseException() {

	}
}
