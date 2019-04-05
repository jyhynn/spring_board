package com.spring.service;

import com.spring.domain.RegistVO;

public interface RegisterService {
	
	public RegistVO checkId(String userid);
	public int register(RegistVO vo);
}
