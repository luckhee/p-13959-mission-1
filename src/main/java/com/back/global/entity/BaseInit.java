package com.back.global.entity;

import com.back.Question.entity.Question;
import com.back.Question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Configuration

public class BaseInit {
    @Autowired
    @Lazy
    private BaseInit self;

    @Autowired
    private QuestionRepository questionRepository;

    @Bean
    public ApplicationRunner BaseInit() {
        return args -> {
            work1();
            self.work2();
        };
    }
    @Transactional
    public void work2() {
        Optional<Question> oq = questionRepository.findById(1);

        Question question = oq.get();
        question.setContent("sbb에 대해서 알고 싶습니다. 수정했습니다.");


    }

    private void work1() {
        if (questionRepository.count() > 0) {
            return;
        }


        Question question = new Question();
        question.setSubject("sbb가 무엇인가요?");
        question.setContent("sbb에 대해서 알고 싶습니다.");
        questionRepository.save(question);

        Question question1 = new Question();
        question1.setSubject("스프링부트 모델 질문입니다.");
        question1.setContent("id는 자동을 생성되나요?");
        questionRepository.save(question1);
    }


}
