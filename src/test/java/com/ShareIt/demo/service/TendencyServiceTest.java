package com.ShareIt.demo.service;

import com.ShareIt.demo.api.dto.ResultDto;
import com.ShareIt.demo.domain.Answer;
import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.domain.TenType;
import com.ShareIt.demo.domain.Tendency;
import com.ShareIt.demo.repository.AnswerRepository;
import com.ShareIt.demo.repository.TendencyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
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
    public void 유형계산() {
        Member member = new Member();
        member.setToken("member1");
        Long memberId = memberService.join(member);

        Tendency tendency = Tendency.createTendency(member); // tendency까지 생성해서 매핑
        tendencyService.save(tendency);

        Tendency t = member.getTendencies().get(0);

        // ENTJ
        t.setTenTypeIE(-5);
        t.setTenTypeNS(5);
        t.setTenTypeTF(5);
        t.setTenTypePJ(-5);

        tendency.makeResult();
        Assertions.assertThat(tendency.getType()).isEqualTo(TenType.ENTJ);

    }
}
