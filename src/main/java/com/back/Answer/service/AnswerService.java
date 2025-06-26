package com.back.Answer.service;

import com.back.Answer.Answer;
import com.back.Answer.repository.AnswerRepository;
import com.back.Question.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;


    public void answerCreate(Question question, String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setQuestion(question);
        answerRepository.save(answer);
    }
}
