package com.spring.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.domain.RegistVO;
import com.spring.mapper.RegisterMapper;

@Service("regist")
public class RegisterServiceImpl implements RegisterService{

	@Inject
	private RegisterMapper mapper;
	
	@Override
	public RegistVO checkId(String userid) {
		return mapper.selectById(userid);
	}
	
	@Override
	public int register(RegistVO vo) {
		return mapper.insert(vo);
	}
}
