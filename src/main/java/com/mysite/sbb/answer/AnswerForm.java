package com.mysite.sbb.answer;

import jakarta.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 엔티티생성
public class AnswerForm {
	// QuestionForm과 같음
	// 이것은 제목은 필요없음
	// 내용만 있으면 됨
    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;
}
