package spring.cloud.order.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DefaultExceptionType {
	
	NOT_LOGIN("로그인 후 이용해 주세요.",105),
	INVALID_REQUEST("잘못된 요청입니다.",106),
	NOT_ALLOW_USER("사용 권한이 없습니다.",107),
	NOT_ALLOW_ADDR("내부 요청만 가능합니다.",108);
	
	private final String message;
	private final int errorCode;
}
