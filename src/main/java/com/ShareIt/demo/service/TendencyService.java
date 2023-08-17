package com.ShareIt.demo.service;

import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.domain.Tendency;
import com.ShareIt.demo.repository.AnswerRepository;
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

    public Long save(Tendency tendency) {
        tendencyRepository.save(tendency);
        return tendency.getId();
    }

    @Transactional(readOnly = true)
    public Tendency findOne(Long tendencyId) {
        return tendencyRepository.findOne(tendencyId);
    }
}
