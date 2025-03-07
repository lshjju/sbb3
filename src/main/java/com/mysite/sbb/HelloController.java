package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 이 클래스는 콘트롤러 기능을 수행함
// 이게 있어야 이 클래스를 컨트롤러로 인식
@Controller
public class HelloController {
	// http://localhost:8080/hello 유알엥 료청 발생하면 헬로 메서드가 실행됨
	// /hello - 유알엘과 헬로메서드를 매빙하는 롤
	// 유알엘과 메서드네임이 동일할 필요는 없음
	@GetMapping("/hello")
	// 메서드의 출력 결과가 문자열 그 자체임을 의미
	// 리턴의 문자열을 리턴
	@ResponseBody
	public String hello() {
		return "Hello Spring Boot Board"; 
	}

}
