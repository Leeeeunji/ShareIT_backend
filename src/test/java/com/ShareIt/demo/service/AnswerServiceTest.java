package com.ShareIt.demo.service;

import com.ShareIt.demo.domain.Answer;
import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.repository.AnswerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class AnswerServiceTest {
    @Autowired
    AnswerService answerService;
    @Autowired MemberService memberService;
    @Autowired
    AnswerRepository answerRepository;

    @Test
    public void 답변제출() {
        Member member = new Member();
        member.setToken("token");
        Long memberId = memberService.join(member);
        Answer answer = answerRepository.findByContent("a1-1");
        answerService.updateAnswer(answer, memberId);

        Assertions.assertThat(answer.getMember().getId()).isEqualTo(memberId);
    }

}
