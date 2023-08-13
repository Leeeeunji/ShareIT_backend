package com.ShareIt.demo.service;

import com.ShareIt.demo.domain.Answer;
import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.repository.AnswerRepository;
import com.ShareIt.demo.repository.TendencyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class TendencyServiceTest {
    @Autowired
    TendencyService tendencyService;
    @Autowired
    TendencyRepository tendencyRepository;
    @Autowired
    AnswerService answerService;
    @Autowired MemberService memberService;
    @Autowired
    AnswerRepository answerRepository;
    @Test
    @Rollback(value = false)
    public void 유형계산() {
        // member 생성
        Member member = new Member();
        member.setToken("member1");
        Long memberId = memberService.join(member);
        
        // answer 매핑
        for (int i = 1; i <= 10; i++) {
            Answer answer = answerRepository.findByContent("a" + i + "-" + (i % 4 + 1));
            answerService.updateAnswer(answer, memberId);
        }

        // 유형 계산
        Long tendencyId = tendencyService.saveTendency(memberId);
        
        // 검증
        Assertions.assertThat(member.getTendencies().get(0).getId()).isEqualTo(tendencyId);
    }
}
