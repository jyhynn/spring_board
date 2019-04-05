package com.spring.domain;

import lombok.Data;

@Data
public class BookVO {
	private int code;
	private String title, writer;
	private int price;
}
