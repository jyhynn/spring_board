package com.spring.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.domain.AuthInfo;
import com.spring.domain.MemberVO;
import com.spring.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("member")
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberMapper mapper;
	
	@Override
	public AuthInfo login(MemberVO vo) {
		return mapper.selectById(vo);
	}

	@Override
	public int leave(String userid) {
		return mapper.delete(userid);
	}

	@Override
	public int changePwd(String userid, String new_password) {
		MemberVO vo = new MemberVO();
		vo.setUserid(userid);
		vo.setPassword(new_password);
		return mapper.update(vo);
	}

}
