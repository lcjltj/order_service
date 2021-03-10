package spring.cloud.order.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfiguration implements WebMvcConfigurer {

	private final LoginIntercepter loginIntercepter;
	private final InnerIntercepter innerIntercepter;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginIntercepter)
				.addPathPatterns("/order/auth/**","/order/admin/**")
				.excludePathPatterns("/order/inner/**");

		registry.addInterceptor(innerIntercepter)
				.addPathPatterns("/order/inner/**");
	}
}
