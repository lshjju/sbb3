package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;


    // 답변을 생성하기 위해 크리에잇 메서드 추가
    // 크리에잇은 퀘스쳔, 콘텐트 파라미터 2개를 사용해서 앤서 오브젝을 생성하고 저장
    public void create(Question question, String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        this.answerRepository.save(answer);
    }
}
