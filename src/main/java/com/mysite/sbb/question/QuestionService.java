package com.mysite.sbb.question;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor

// 클래스를 서비스로 만들는 롤
@Service


public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }
    
    // 갯퀘스쳔 - 아디값으로 질문 데이터 조회
    public Question getQuestion(Integer id) {  
    	// 퀘스천에 데이터가 없으면 에러 발생하므로 예외 처리 필요
        Optional<Question> question = this.questionRepository.findById(id);
        // 퀘스천에 데이터가 있다면 밸류를 담아라
        if (question.isPresent()) {
            return question.get();
            // 데이터 없으면 데이터낫파운드익셉션 실행해라
        } else {
            throw new DataNotFoundException("question not found");
        }
    }
}
