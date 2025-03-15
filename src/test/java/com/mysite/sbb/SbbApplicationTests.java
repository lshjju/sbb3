package com.mysite.sbb;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;


@SpringBootTest
class SbbApplicationTests {

	
	
//	더미 데이터 300개 만들기 코드
//	만들고자 하는 데이터가 세자리일 경우는 [%03d]
//	만들고자 하는 데이터가 네자리일 경우는 [%04d]
	
//    @Autowired
//    private QuestionService questionService;
//
//    @Test
//    void testJpa() {      
//        for (int i = 1; i <= 300; i++) {
//            String subject = String.format("테스트 데이터입니다:[%03d]", i);
//            String content = "내용무";
//            this.questionService.create(subject, content);
//        }
//    }    
    
//    @Autowired
//    private QuestionRepository questionRepository;    
//    
//    @Test
//    void testJpa() {      
//        Question q1 = new Question();
//        q1.setSubject("sbb가 무엇인가요?");
//        q1.setContent("sbb에 대해서 알고 싶습니다.");
//        q1.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q1);  // 첫번째 질문 저장
//
//        Question q2 = new Question();
//        q2.setSubject("스프링부트 모델 질문입니다.");
//        q2.setContent("id는 자동으로 생성되나요?");
//        q2.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q2);  // 두번째 질문 저장
//    }
    
    
    
    
    
}
