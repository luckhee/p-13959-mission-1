package com.back;

import com.back.Question.entity.Question;
import com.back.Question.repository.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class BackApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @DisplayName("질문 데이터 저장하기")
    @Test
    void t1() {
        Question question = new Question();
        question.setSubject("sbb가 무엇인가요?");
        question.setContent("sbb에 대해서 알고 싶습니다.");

        questionRepository.save(question);

        Question question2 = new Question();
        question2.setSubject("sbb가 무엇인가요?");
        question2.setContent("sbb에 대해서 알고 싶습니다.");

        questionRepository.save(question2);
    }

    @DisplayName("질문 데이터 검사하기")
    @Test
    void t2() {
        Optional<Question> oq = questionRepository.findById(1);

        Question question = oq.get();

        assertThat(question.getSubject()).isEqualTo("sbb가 무엇인가요?");

    }

    @DisplayName("질문 데이터 검사하기")
    @Test
    void t3() {
        Optional<Question> oq = questionRepository.findById(1);

        Question question = oq.get();
        question.setContent("sbb에 대해서 알고 싶습니다. 수정했습니다.");

        assertThat(question.getContent()).isEqualTo("sbb에 대해서 알고 싶습니다. 수정했습니다.");




    }


}
