package spring.cloud.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import spring.cloud.order.dto.response.DefaultResponse;

@ControllerAdvice
public class OrderExceptionHandler {
		
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<DefaultResponse> userException(OrderException e) {
		DefaultResponse errorResult = DefaultResponse
				.builder()
				.message(e.getMessage())
				.errorCode(e.getErrorCode())
				.build();
		
		return new ResponseEntity<DefaultResponse>(errorResult, HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(DefaultException.class)
	public ResponseEntity<DefaultResponse> userException(DefaultException e) {
		DefaultResponse errorResult = DefaultResponse
				.builder()
				.message(e.getMessage())
				.errorCode(e.getErrorCode())
				.build();
		
		return new ResponseEntity<DefaultResponse>(errorResult, HttpStatus.OK);
	}
}

