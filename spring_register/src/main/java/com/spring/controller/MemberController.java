package com.spring.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.AuthInfo;
import com.spring.domain.MemberVO;
import com.spring.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member/*")
@SessionAttributes("auth")		// 단, Model에 담은거라 나중에 remove했을 때도 살아있을 수 있기 때문에 불편할 수 있긴 함
public class MemberController {

	// ~~/member/signin
	@Inject
	private MemberService service;
	
	@RequestMapping("/signin")
	public void signinForm() {
		log.info("로그인signin 호출");
	}
	
	@PostMapping("/signin")
	public String signin(MemberVO vo, Model model ) {
		AuthInfo auth = service.login(vo);
		if(auth!=null) {
			// 로그인 시키고 세션에 담기
			// 1.httpSession 사용
			// 2.annotation 사용. 클래스 위에 붙임. 단, @SessionAttributes("이름")에 담는 "이름"은 ModelAttribute의 이름과 동일해야함
			model.addAttribute("auth", auth);
			return "redirect:/";
		}else {
			return "redirect:signin";
		}
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		log.info("로그아웃...");
		// 1. httpSession : invalidate(), removeAttribute()
		// 2. SessionStatus : setComplete()
		status.setComplete();
		//return "index";	이러면 아직 request에는 남아있기 때문에 로그아웃이 한번에 안됨
		return "redirect:/";
	}
	
	//탈퇴
	@GetMapping("/leave")
	public String leave(@ModelAttribute("auth")AuthInfo auth, SessionStatus status, RedirectAttributes rttr) {
		int result = service.leave(auth.getUserid());
		if(result>0) {
			if(!status.isComplete()) {
				status.setComplete();	
				rttr.addFlashAttribute("msg","success");
			}
		}else {			
			rttr.addFlashAttribute("msg","fail");
		}
		return "redirect:/";
	}

	//비번변경
	@RequestMapping("/changePwd")
	public void changePwdpage(@ModelAttribute("auth")AuthInfo auth) {
		log.info("비번변경폼 요청");
		
	}

	/*@PostMapping("/checkPwd") // ajax
	public String checkPwd(@ModelAttribute("auth")AuthInfo auth, String password) {
		log.info("비번변경요청");
		log.info(auth.getUserid() + " 비번 : " +password);
		MemberVO vo = new MemberVO();
		vo.setUserid(auth.getUserid());	// 현재 세션의 아이디
		vo.setPassword(password);		
		AuthInfo info = service.login(vo);	
		if(info!=null) return "true";
		return "false";
	}*/
	
	@PostMapping("/goChangePwd")
	public String goChangePwd(@ModelAttribute("auth")AuthInfo auth, String password, String new_password, RedirectAttributes rttr, SessionStatus status) {
		log.info("비번변경 요청");
		MemberVO vo = new MemberVO();
		vo.setUserid(auth.getUserid());
		vo.setPassword(password);
		AuthInfo info = service.login(vo);	
		if(info!=null) {	//아이디랑 비번 모두 일치시
			int result = service.changePwd(auth.getUserid(), new_password);
			if(result>0) {
				rttr.addFlashAttribute("msg","changeSuccess");
				status.setComplete();
				return "redirect:/";
			}else {
				rttr.addFlashAttribute("error","changeFailed");
				return "redirect:changePwd";
			}
		}else {
			rttr.addFlashAttribute("error","wrongPassword");
			return "redirect:changePwd";
		}
		
	}

	
}
