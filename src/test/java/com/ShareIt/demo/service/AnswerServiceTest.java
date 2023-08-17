package com.ShareIt.demo.service;

import com.ShareIt.demo.domain.Answer;
import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.domain.Tendency;
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
    @Autowired
    TendencyService tendencyService;

    @Test
    public void 답변제출() {
        Member member = new Member();
        member.setToken("token");
        Long memberId = memberService.join(member);
        Tendency tendency = Tendency.createTendency(member); // tendency까지 생성해서 매핑
        tendencyService.save(tendency);

        Answer answer = answerRepository.findOne(new Long(3));
        Tendency t = member.getTendencies().get(0);

        System.out.println("IE = " + tendency.getTenTypeIE());
        // tendency에 answer 값 저장
        int temp1 = tendency.getTenTypeIE() + answer.getTenTypeIE();
        tendency.setTenTypeIE(temp1);
        int temp = tendency.getTenTypeNS() + answer.getTenTypeNS();
        tendency.setTenTypeNS(temp);
        temp = tendency.getTenTypeTF() + answer.getTenTypeTF();
        tendency.setTenTypeTF(temp);
        temp = tendency.getTenTypePJ() + answer.getTenTypePJ();
        tendency.setTenTypePJ(temp);

        System.out.println("IE = " + tendency.getTenTypeIE());
        Assertions.assertThat(member.getTendencies().get(0).getTenTypeIE()).isEqualTo(temp1);
    }

}
