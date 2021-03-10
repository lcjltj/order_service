package spring.cloud.order.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import spring.cloud.order.exception.DefaultException;
import spring.cloud.order.exception.DefaultExceptionType;

@Component
@Slf4j
@RequiredArgsConstructor
public class InnerIntercepter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("remote Addrr : " + request.getRemoteAddr());
		String ip = request.getHeader("X-FORWARDED-FOR");
		log.info("remote Header Addrr : " + ip);
		
		if(!"172.19.0.1".equals(request.getRemoteAddr())) {
			throw new DefaultException(DefaultExceptionType.NOT_ALLOW_ADDR);
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
