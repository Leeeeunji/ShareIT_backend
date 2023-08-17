package com.ShareIt.demo.api.dto;

import com.ShareIt.demo.domain.Answer;
import com.ShareIt.demo.domain.Question;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
public class QuestionDto {
    private Long questionId;
    private String questionContent;

    private Long answerId1;
    private String answerContent1;

    private Long answerId2;
    private String answerContent2;

    public QuestionDto(Question q) {
        questionId = q.getId();
        questionContent = q.getContent();
        List<Answer> answers = q.getAnswers();

        answerId1 = answers.get(0).getId();
        answerContent1 = answers.get(0).getContent();
        answerId2 = answers.get(1).getId();
        answerContent2 = answers.get(1).getContent();
    }
}
