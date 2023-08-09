package com.ShareIt.demo.service;

import com.ShareIt.demo.domain.Answer;
import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void saveAnswer(Answer answer) { // 단순 저장 기능
        answerRepository.save(answer);
    }

    @Transactional(readOnly = true)
    public Answer findOne(Long id) {
        return answerRepository.findOne(id);
    }

    public Long updateAnswer(Answer answer, Member member) { // member와 매핑
        answer.setMember(member);
        return answer.getId();
    }
}
