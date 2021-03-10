package spring.cloud.order.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import spring.cloud.order.exception.OrderExceptionType;

@Getter
@Setter
@Builder
@ToString
public class DefaultResponse<T> {
	
	private final String message;
	private final int errorCode;
	private final T body;

	public DefaultResponse (){
		this.message = null;
		this.errorCode = 0;
		this.body = null;
	}
	
	public DefaultResponse (T body) { // 성공
		this.message = null;
		this.errorCode = 0;
		this.body = body;
	}
	
	public DefaultResponse (String message, int errorCode) { // 실패
		this(message, errorCode, null);
	}
	
	public DefaultResponse (OrderExceptionType orderExcetpionType) { //실패
		this(orderExcetpionType, null);
	}
	
	public DefaultResponse (String message, int errorCode, T body) { // 실패 
		this.message = message;
		this.errorCode = errorCode;
		this.body = body;
	}
	
	public DefaultResponse (OrderExceptionType orderExcetpionType, T body) { //실패
		this.message = orderExcetpionType.getMessage();
		this.errorCode = orderExcetpionType.getErrorCode();
		this.body = body;
	}
}
