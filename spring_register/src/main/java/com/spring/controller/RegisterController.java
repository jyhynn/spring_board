package com.spring.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.RegistVO;
import com.spring.service.RegisterService;
import com.spring.service.RegisterServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/regist/*")
public class RegisterController {
	// http://localhost:8083/regist/step1
	
	@Inject
	private RegisterService service;
	
	@RequestMapping("/step1")
	public void step1() {
		log.info("step1 요청");
	}

	// 직접 주소를 입력하여 중간단계부터 들어오는 것 제한
	@RequestMapping(value = { "/step2", "/step3" }, method = RequestMethod.GET)
	public String handleStep2_3Get() {
		return "redirect:step1";
	}

	@PostMapping("/step2")
	public String step2(@RequestParam(value = "agree", defaultValue = "false") boolean agree, RedirectAttributes rttr) {
		log.info("step2 요청");
		// 약관동의여부 체크하기
		// 약관동의x시 step1으로 돌려보내고
		// 동의했다면 setp2페이지가 보여지도록 코드 작성
		if (agree == false) {
			// 값을 가지고 움직이지 않기 때문에 sendRedirect로 리턴해야 실제 주소줄에서도 step1으로 유지됨
			rttr.addFlashAttribute("check", false);
			return "redirect:step1";
		}
		return "regist/step2";
	}

	@PostMapping("/step3")
	public String step3(@ModelAttribute("vo") RegistVO vo) {
		log.info("step3 요청");
		// pwd 같으면 step3.jsp로 이동
		// step3.jsp에서는 name님 회원가입을 축하합니다. 띄우기
		// 비번 다르면 step2.jsp로
		boolean pwdCheck = vo.checkPWD();
		if (pwdCheck == false) {
			// return "redirect:step2"; 컨트롤러로 재진입하게 되는데 redirect는 무조건 get방식으로 동작하기 때문에
			// 매핑충돌남. 이렇게 처리하고 싶은경우 get으로 메서드 따로 하나 더 만들든지..
			// 그리고 vo값 같이 넘어감
			return "regist/step2"; // 사용자가 입력했던 값 다시 보여주기 가능			
		} else {
			// 회원가입
			int result = service.register(vo);
			if (result > 0) {
				return "/regist/step3";
			} else {
				return "redirect:/"; // index로 이동
			}
		}
	}//step3
	
	//중복아이디 검사 ajax
	//http://local~/regist/checkId
	@ResponseBody	//응답역할만 하는 메소드임을 명시. 여기선 js로 응답 
	@PostMapping("/checkId")
	public String checkId(String userid) {	//return type must be String.
		log.info(userid);
		RegistVO vo = service.checkId(userid);
		if(vo!=null) return "false";
		return "true";
	}
	
	// Ajax uses HTTP which is a text protocol and has no concept of booleans. 
	// However, you can return the strings "1" or "0" to represent your boolean values.
	

}
















