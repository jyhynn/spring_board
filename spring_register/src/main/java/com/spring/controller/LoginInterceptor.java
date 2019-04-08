package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.domain.AuthInfo;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//세션 정보가 있는지 확인하여 세션이 없는 경우 signin페이지로 이동
		HttpSession session = request.getSession(false);
		if(session!=null) {
			AuthInfo info = (AuthInfo)session.getAttribute("info");
			if(info!=null) {
				return true;
			}
		response.sendRedirect(request.getContextPath()+"/member/signin");
		}
		return false;
	}
	
}
