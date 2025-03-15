package com.mysite.sbb.question;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
// 엔티티 - 디비 테이블 생성 롤
// 리포지토리 - 디비 테이블에 접근하고 시알유디를 가능하게 하는 롤 - 데이터 관리 메서드 제공 - 예 파인드올 세이브 등
// 제피에이리포지토리 - 제이피에이가 제공하는 인터페이스 - 씨알유디 메서드 내장 - 디비관리가 편리
// JpaRepository<Question, Integer> - 퀘스천 엔티티로 리포지토리를 생성함 - 인티저는 엔티티 기본키
// findAll - 콜받으면 페이지어블 클래스를 사용해서 페이지 자료형 타입 오브젝을 리턴
public interface QuestionRepository extends JpaRepository<Question, Integer>{
//    Question findBySubject(String subject);
//    Question findBySubjectAndContent(String subject, String content);
//    List<Question> findBySubjectLike(String subject);
    Page<Question> findAll(Pageable pageable);

}
