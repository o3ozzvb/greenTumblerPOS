package com.sinc.greentumbler.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * 모바일에서 AJAX 요청을 하면,
 * 기본적으로 CORS 정책에 의해 차단된다.
 * 이를 막기 위해 요청의 헤더에 권한을 추가해주는 Interceptor 이다.
 */

public class CORSInterceptor extends HandlerInterceptorAdapter {
	public static final String CREDENTIALS_NAME = "Access-Control-Allow-Credentials";
    public static final String ORIGIN_NAME = "Access-Control-Allow-Origin";
    public static final String METHODS_NAME = "Access-Control-Allow-Methods";
    public static final String HEADERS_NAME = "Access-Control-Allow-Headers";
    public static final String MAX_AGE_NAME = "Access-Control-Max-Age";
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
       Object handler) throws Exception {
    	
       response.setHeader(CREDENTIALS_NAME, "true");
       response.setHeader(ORIGIN_NAME, "*");
       response.setHeader(METHODS_NAME, "GET, OPTIONS, POST, PUT, DELETE");
       response.setHeader(HEADERS_NAME, "Origin, X-Requested-With, Content-Type, Accept");
       response.setHeader(MAX_AGE_NAME, "3600");
       return true;
    }
}
