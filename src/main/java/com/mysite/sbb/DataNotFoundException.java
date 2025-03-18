package com.mysite.sbb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 디비에서 특정 엔티티 혹은 데이터를 찾을 수 없는 예외 발생시 실행되는 클래스

// 이거 실행되면 설정된 에이치티티피 상태코드와 이유를 클라이언트에게 리턴
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
// 런타임익셉션 - 실행시 발생하는 예외
public class DataNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public DataNotFoundException(String message) {
        super(message);
    }
}
