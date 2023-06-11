package com.pending.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PendingNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(PendingNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String pendingNotFoundHandler(PendingNotFoundException ex) {
		return ex.getMessage();
	}

}
