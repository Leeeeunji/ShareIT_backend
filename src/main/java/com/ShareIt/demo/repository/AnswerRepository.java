package com.ShareIt.demo.repository;

import com.ShareIt.demo.domain.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class AnswerRepository {
    private final EntityManager em;

    public void save(Answer answer) {
        em.persist(answer);
    }

    public Answer findOne(Long id) {
        return em.find(Answer.class, id);
    }
}
