package spring.cloud.order.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderExceptionType {
	
	FAIL_ORDER_PRODUCT("상품 주문에 실패하였습니다.",100);
	
	private final String message;
	private final int errorCode;
}
