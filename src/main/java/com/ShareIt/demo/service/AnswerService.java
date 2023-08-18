package com.ShareIt.demo.service;

import com.ShareIt.demo.domain.Answer;
import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.repository.AnswerRepository;
import com.ShareIt.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final MemberRepository memberRepository;


    public void saveAnswer(Answer answer) { // 단순 저장 기능
        answerRepository.save(answer);
    }

    @Transactional(readOnly = true)
    public Answer findOne(Long id) {
        return answerRepository.findOne(id);
    }

    /*public Long mapAnswerMember(Long answerId, Long memberId) { // member와 매핑
        Answer answer = answerRepository.findOne(answerId);
        Answer newAns = new Answer();
        newAns.setContent(answer.getContent());
        newAns.setQuestion(answer.getQuestion());
        newAns.setNum(answer.getNum());
        newAns.setTenTypeIE(answer.getTenTypeIE());
        newAns.setTenTypeNS(answer.getTenTypeNS());
        newAns.setTenTypeTF(answer.getTenTypeTF());
        newAns.setTenTypePJ(answer.getTenTypePJ());

        Member member = memberRepository.findOne(memberId);
        newAns.setMember(member);
        answerRepository.save(newAns);

        return answer.getId();
    }*/
}
