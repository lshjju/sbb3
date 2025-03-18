package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

	private final QuestionService questionService;
	private final AnswerService answerService;

	// question 엔티티의 아이디
	@PostMapping("/create/{id}")
	// question_detail textarea의 content 를 얻어옴
	// QuestionController questionCreate 와 같음
	public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm,
			BindingResult bindingResult) {
		Question question = this.questionService.getQuestion(id);
		// QuestionController questionCreate 와 같음
		if (bindingResult.hasErrors()) {
			// 아래에서 거시기 리턴하려면 거시기가 필요함
			// 그러므로 거시기 오브젝을 가져옴
			model.addAttribute("question", question);
			// 에러가 있으면 거시기로
			return "question_detail";
		}
		// AnswerService create을 콜해서 리플라이를 저장할 수 있게 함
		// 거시기를 파라미터 담아서 메서드 콜
		this.answerService.create(question, answerForm.getContent());
		return String.format("redirect:/question/detail/%s", id);
	}
}
