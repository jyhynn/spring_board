package com.spring.domain;

import lombok.Data;

@Data
public class RegistVO {
	private String userid, password, confirm_password, username, gender, email;

	public boolean checkPWD() {
		return password.equals(confirm_password);
	}

}
