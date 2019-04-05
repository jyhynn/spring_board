package com.spring.mapper;

import com.spring.domain.RegistVO;

public interface RegisterMapper {

	public RegistVO selectById(String userid);	// 중복아이디 검사
	public int insert(RegistVO vo);				// 회원가입
	
	
}
