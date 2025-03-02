package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/list")
    // 모델 오브젝은 파라미터로 지정하면 스프링부트가 모델 오브젝 자동 생성
    public String list(Model model) {
    	// 퀘스천 서비스의 겟리스트 메서드로 질문 목록 데이터인 퀘스쳔리스트 생성 
    	List<Question> questionList = this.questionService.getList();       
        // 퀘스천리스트 네임으로 모델 오브젝에 저장
        // 모델 오브젝은 클래스와 템플릿 연결 롤
        // 모델 오브젝에 밸류를 담아두면 템플릿에서 그것을 사용
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
    
    @GetMapping(value = "/detail/{id}")
    // 패스베리어블 - 유알엘에 파라미터 주사가 필요할때
    // 아이디 - 위에 밸류와 패스배리어블 파라미터 일치
    public String detail(Model model, @PathVariable("id") Integer id) {
    	// 겟퀘스천 메서드 호출해서 퀘스천을 템플릿에 전달
    	Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
}
