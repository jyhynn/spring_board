package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("index요청");
		
		return "index";
	}	
	
	//404 오류 페이지 처리
	//	404 페이지형태 1. 컨트롤러 없이 404
	//			   2. 컨틀롤러 있이 404-1 : 파라미터처리 요구
	//			   3. 컨트롤러 있이 404-2 : 컨트롤러가 받아서 넘어갈 jsp페이지가 없을 때 생김
	@GetMapping("/except")
	public void exceptionGet(int no) {
		log.info("Exception 테스트");
	}
	
}
