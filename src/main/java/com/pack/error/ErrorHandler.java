package com.pack.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler
	public ResponseEntity<Object> myFieldErrorHandler(MethodArgumentNotValidException ex) {
		HashMap<String, String> errorList = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldError = ((FieldError) error).getField();
			String errorMsg = error.getDefaultMessage();
			errorList.put(fieldError, errorMsg);
		});
		return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<String> userDataNotfoundHandler(UsersDataNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
