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

    // 아래 유알엘 요청하면 크리에잇앤서 메서드가 호출됨
    // 포스트매핑 - 겟매핑과 롤 같음 - 포스트요청 받았으니까 포스트매핑
    // 유알엘에 밸류 코드는 생략 가능 
    // 유알엘 아이디는 질문 엔티티의 아이디
    // 조회 했을때 값이 없으면 404에러 발생
    @PostMapping("/create/{id}")
    // 피퀘스트파람스트링콘텐트 - 퀘스쳔디테일에서 답변으로 입력한 내용을 가져옴
    // 퀘스천티테일 텍스트에어리어 네임이 콘텐트니까 밸류를 콘텐트로 연결
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String content) {
        Question question = this.questionService.getQuestion(id);
        this.answerService.create(question, content);
        return String.format("redirect:/question/detail/%s", id);
    }
}
