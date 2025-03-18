package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.answer.AnswerForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

// 유알엘을 매핑하기 위한 콘트롤러
// 질문 목록이 담긴 데이터를 죄회하여 이를 템플릿을 통해 화면에 전달
// 질문 목록 관련 데이터를 조회하려면 퀘스천리포지토리 사용
// 퀘스천리포지토리로 조회한 질문 목록 데이터는 모델 클래스를 사용하여 템플릿에 전달

// 프리픽스 - 유알엘 접두사 또는 시작 부분
// 리퀘스트매핑 - 유알엘이 프리픽스로 알아서 딱딱 붙음
// /list = /question/list
@RequestMapping("/question")
// 디아이 롤 - 롬복 제공 - 파이널이 붙은 속석을 포함하는 콘스트럭터 자동 생성 역할
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	// 디아이 - 퀘스천서비스 객체 주입 
	private final QuestionService questionService;

	
	// @GetMapping - http://localhost:8080/question/list?page=0
	// public - 모델 오브젝은 파라미터로 지정하면 스프링부트가 모델 오브젝 자동 생성
	// public - 페이지값을 가져오기 위해 파라미터 입력
	// public - 파라미터가 전달되지 않는 경우 디폴트는 0으로 세팅
	// public - 스프링부트 페이징 첫 페이지는 0
    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
    	Page<Question> paging = this.questionService.getList(page);       
        model.addAttribute("paging", paging);
        return "question_list";
    }
    
    @GetMapping(value = "/detail/{id}")
    // 패스베리어블 - 유알엘에 파라미터 주사가 필요할때
    // 아이디 - 위에 밸류와 패스배리어블 파라미터 일치
    // AnswerForm answerForm - question_detail 이 거시기와 연결되었으므로 추가
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
    	// 겟퀘스천 메서드 호출해서 퀘스천을 템플릿에 전달
    	Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
    
    @GetMapping("/create")
    // question_form 에 th:object가 추가 되서 QuestionForm 필요
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }   
    
    // question_form에서 subject와 content를 포스트매핑으로 받음
    @PostMapping("/create")
    // 이걸 파라미터로 넘겨줌
    // 이렇게 일단 정보를 받아 둠
    // 오버로딩
    // @Valid - subject content를 알아서 바인딩해서 QuestionForm으로 가져감
    // QuestionForm에서 검증하고 이리로 다시 넘어옴
    // BindingResult - 검증 결과 - 위치는 항상 @Valid 뒤
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
    	// 에러 있으면 아래 코드 리턴
    	if (bindingResult.hasErrors()) {
    		return "question_form";
    	}
    	// questionService create 메서드 콜해서 검증된 파라미터 넘김
    	this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        // QuestionService가 저장하면 이리로 다시 넘어 와서 아래 코드 실행
        return "redirect:/question/list"; 
    }
}
