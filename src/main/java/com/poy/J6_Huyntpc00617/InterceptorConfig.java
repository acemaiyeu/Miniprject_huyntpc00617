package com.poy.J6_Huyntpc00617;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.poy.J6_Huyntpc00617.interceptor.GloballInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	GloballInterceptor globallinterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(globallinterceptor)
		.addPathPatterns("/**").excludePathPatterns("/rest/**","/admin/**","/assets/**","/auth/login/form");
	}
}
