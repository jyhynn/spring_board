package com.spring.service;

import com.spring.domain.AuthInfo;
import com.spring.domain.MemberVO;

public interface MemberService {
	public AuthInfo login(MemberVO vo);
	public int leave(String userid);
	public int changePwd(String userid, String new_password);
}
