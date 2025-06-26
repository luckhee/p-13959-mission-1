package com.back.Answer;

import com.back.Question.entity.Question;
import com.back.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Answer extends BaseEntity {

    @ManyToOne
    private Question question;
    @Column(columnDefinition = "text")
    private String content;
}
