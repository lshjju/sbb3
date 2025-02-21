package com.mysite.sbb;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 스프링부트가 이 클래스가 엔티티구나 인식하게 하는 어노테이션
// 디비 테이블과 자바를 매핑하는 롤
// 코드대로 디비에 테이블이 만들어짐
@Entity
// 사용자가 입력한 질문을 저장하는 롤
public class Question {
	// 중복되면 안되는 기본키
	@Id
	// 데이터 하나 생길때마다 알아서 1씩 증가하게 함
	// 뒤에 퍼렌서시스는 걍 묻따 코딩
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 200)
	private String subject;

	@Column(columnDefinition = "TEXT")
	private String content;

	private LocalDateTime createDate;

	// 질문 하나 답은 많이
	// 퀘스쳔이 앤서클래스의 퀘스쳔과 연결 롤
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	// 앤서에서 여러개의 답을 가져와야 하니까 리스트
	private List<Answer> answerList;
}
