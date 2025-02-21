package com.mysite.sbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 반드시 있어야 하는 어노테이션
// 스프링부트를 시작하게하는 롤
@SpringBootApplication

// 스프링부트 시작 담당 파일
public class SbbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbbApplication.class, args);
	}

}
