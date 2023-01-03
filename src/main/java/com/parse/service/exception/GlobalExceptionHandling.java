package com.parse.service.exception;


import com.parse.service.exception.cust.exeption.InvalidFileException;
import com.parse.service.exception.cust.exeption.UnParseException;
import com.parse.service.exception.cust.exeption.KafkaException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Log4j2
//@RequiredArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {


	@ExceptionHandler(KafkaException.class)
	public ResponseEntity<?> duplicationException(KafkaException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(),"invalid or duplicated email", ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidFileException.class)
	public ResponseEntity<?> invalidImageException(InvalidFileException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UnParseException.class)
	public ResponseEntity<?> notFoundRecordException(UnParseException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
