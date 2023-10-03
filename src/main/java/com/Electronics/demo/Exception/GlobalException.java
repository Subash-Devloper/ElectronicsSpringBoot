package com.Electronics.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
@ExceptionHandler(PriceNotFoundException.class)
public ResponseEntity<Object> handleprice(PriceNotFoundException p) {
	return new ResponseEntity<Object>("Please enter Valid Price",HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(ModelNotFoundException.class)
public ResponseEntity<Object> handleprices(ModelNotFoundException p) {
	return new ResponseEntity<Object>("Please enter Valid brand",HttpStatus.BAD_REQUEST);
}
}
