package spring.cloud.order.exception;

import lombok.Getter;

@Getter
public class OrderException extends RuntimeException {

	private static final long serialVersionUID = 3709376842105639297L;
	private final int errorCode;

	public OrderException(OrderExceptionType orderExceptionType) {
		super(orderExceptionType.getMessage());
		this.errorCode = orderExceptionType.getErrorCode();
	}
}