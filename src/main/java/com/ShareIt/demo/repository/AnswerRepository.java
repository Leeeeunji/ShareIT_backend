package com.ShareIt.demo.repository;

import com.ShareIt.demo.domain.Answer;
import com.ShareIt.demo.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

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

    public Answer findByContent(String content) {
        return em.createQuery("select a from Answer a where a.content = :content", Answer.class)
                .setParameter("content", content).getSingleResult();
    }

    public Answer findByNum(Long num) {
        return em.createQuery("select a from Answer a where a.num = :num", Answer.class)
                .setParameter("num", num).getSingleResult();
    }
}
