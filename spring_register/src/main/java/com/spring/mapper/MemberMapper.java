package com.spring.mapper;

import com.spring.domain.AuthInfo;
import com.spring.domain.MemberVO;

public interface MemberMapper {
	public AuthInfo selectById(MemberVO vo);
	public int delete(String userid);
	public int update(MemberVO vo);
}
