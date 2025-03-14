package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 스프링부트에 유알엘 매핑시켜주는 콘트롤러
@Controller
public class MainController {
	// 유알엘 요청하면 매핑되는 메서드 찾아서 실행
	// http://localhost:8080/sbb 오청 발생하면 유알엘과 매핑되는 인덱스 메서드를 이 클래스에서 찾아서 실행
	@GetMapping("/sbb")
	// 서버에서 유알엘 요청하면 문자열을 리턴하라
	@ResponseBody
	public String index() {
		return "안녕하세요 sbb에 오신 것을 환영합니다.";
	}
	
	// http://localhost:8080/
	@GetMapping("/")
	public String root() {
		// 루트 메서드를 실행하면 /question/list 유알엘을 매핑값으로 전송하라
		return "redirect:/question/list";
	}

}