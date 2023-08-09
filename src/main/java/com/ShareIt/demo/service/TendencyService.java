package com.ShareIt.demo.service;

import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.domain.Tendency;
import com.ShareIt.demo.repository.MemberRepository;
import com.ShareIt.demo.repository.TendencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TendencyService {

    private final TendencyRepository tendencyRepository;
    private final MemberRepository memberRepository;

    public void saveTendency(Long memberId) {
        Member member = memberRepository.findOne(memberId);
        // member에 필요한 모든 Answer들이 매핑되어 있다고 가정
        Tendency tendency = Tendency.createTendency(member);
        member.addTendency(tendency);
        tendencyRepository.save(tendency);
    }

    @Transactional(readOnly = true)
    public Tendency findOne(Long tendencyId) {
        return tendencyRepository.findOne(tendencyId);
    }


}
