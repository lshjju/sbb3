package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

	// getList - 파라미터로 받은 페이지 오브젝 리턴
	// PageRequest.of(page, 10) - 앞에거 - 조회할 페이지 넘버 - 뒤에거 - 한 페이지에 보여 줄 게시물 개수
	// findAll - 메서드 콜해서 해당리파지토러에서 데이터 리턴 받아라
    public Page<Question> getList(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return this.questionRepository.findAll(pageable);
    }
    
    
    public Question getQuestion(Integer id) {  
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }
    
    // QuestionController에서 데이터 받음
    public void create(String subject, String content) {
    	// 데이터 처리
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        // questionRepository가 처리한 데이터를 세입하게 함
        this.questionRepository.save(q);
    }
    

}
