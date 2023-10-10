package com.ShareIt.demo.service;

import com.ShareIt.demo.domain.Tendency;
import com.ShareIt.demo.repository.TendencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TendencyService {

    private final TendencyRepository tendencyRepository;

    public Long save(Tendency tendency) {
        tendencyRepository.save(tendency);
        return tendency.getId();
    }

    public Optional<Tendency> findOne(Long tendencyId) {
        return tendencyRepository.findById(tendencyId);
    }

    public Tendency findByMemberId(Long id) {
        return tendencyRepository.findByMemberId(id);
    }

    public void initTendency(Tendency tendency){
        tendency.setTenTypeIE(0);
        tendency.setTenTypeNS(0);
        tendency.setTenTypeTF(0);
        tendency.setTenTypePJ(0);

    }
}
