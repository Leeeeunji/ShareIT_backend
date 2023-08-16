package com.ShareIt.demo.service;

import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원등록() {
        Member member = new Member();
        member.setToken("yeonsu");
        Long id = memberService.join(member);

        Member member1=new Member();
        member1.setToken("hyoseong");
        memberRepository.save(member1);

        Assertions.assertThat(memberRepository.findOne(id)).isEqualTo(member);
    }
}
