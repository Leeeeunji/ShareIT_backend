package com.ShareIt.demo.service;

import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.domain.Question;
import com.ShareIt.demo.repository.MemberRepository;
import com.ShareIt.demo.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public Long save(Question question) {
        questionRepository.save(question);
        return question.getId();
    }

    @Transactional(readOnly = true)
    public Question findOne(Long id) {
        return questionRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public Question findByNum(Long num) {
        return questionRepository.findByNum(num);
    }

}
