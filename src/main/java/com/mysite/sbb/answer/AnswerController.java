package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String content) {
        Question question = this.questionService.getQuestion(id);
        // AnswerService create을 콜해서 리플라이를 저장할 수 있게 함
        this.answerService.create(question, content);
        return String.format("redirect:/question/detail/%s", id);
    }
}
