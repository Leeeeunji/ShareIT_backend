package com.ShareIt.demo.service;

import com.ShareIt.demo.api.dto.ResponseDto;
import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.domain.Tendency;
import com.ShareIt.demo.repository.MemberRepository;
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
public class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TendencyService tendencyService;
    @Autowired
    TendencyRepository tendencyRepository;

    @Test
    public void 회원등록() {
        /*Member member = new Member();
        member.setToken("yeonsu");
        Long id = memberService.join(member);

        Member member1=new Member();
        member1.setToken("hyoseong");
        memberRepository.save(member1);*/


        Member member = new Member();
        member.setToken("member1");
        Long memberId = memberService.join(member);

        Tendency tendency = Tendency.createTendency(member); // tendency까지 생성해서 매핑
        Long tendencyId = tendencyService.save(tendency);

        Assertions.assertThat(tendencyRepository.findOne(tendencyId)).isEqualTo(memberRepository.findOne(memberId).getTendencies().get(0));
    }
}
