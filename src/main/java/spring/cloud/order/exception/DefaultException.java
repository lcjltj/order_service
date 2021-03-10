package spring.cloud.order.exception;

import lombok.Getter;

@Getter
public class DefaultException extends RuntimeException {

	private static final long serialVersionUID = -3216335884997401952L;
	
	private final int errorCode;

	public DefaultException(DefaultExceptionType defaultExceptionType) {
		super(defaultExceptionType.getMessage());
		this.errorCode = defaultExceptionType.getErrorCode();
	}
	
	public DefaultException(JwtExceptionType jwtExceptionType) {
		super(jwtExceptionType.getMessage());
		this.errorCode = jwtExceptionType.getErrorCode();
	}
}