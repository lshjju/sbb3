package com.mysite.sbb.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 이상한 놈 멀쩡하게 만들기 클래스
// 필수입력 같은거 안 넣거나 룰 안지키면 경고 때려줌
// 폼클래스는 검증과 함께 매핑되는 바인딩도 같이 함
// 여기서는 question_form subject content 와 매핑
public class QuestionForm {
	@NotEmpty(message="제목은 필수항목입니다.")
	@Size(max=200)
	private String subject;
	
	@NotEmpty(message="제목은 필수항목입니다.")
	private String content;

}
