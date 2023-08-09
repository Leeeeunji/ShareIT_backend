package com.ShareIt.demo.repository;

import com.ShareIt.demo.domain.Tendency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class TendencyRepository {
    private final EntityManager em;

    public void save(Tendency tendency) {
        em.persist(tendency);
    }

    public Tendency findOne(Long id) {
        return em.find(Tendency.class, id);
    }


}
