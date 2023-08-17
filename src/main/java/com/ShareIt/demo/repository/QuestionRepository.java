package com.ShareIt.demo.repository;

import com.ShareIt.demo.domain.Answer;
import com.ShareIt.demo.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {
    private final EntityManager em;

    public void save(Question question) {
        em.persist(question);
    }

    public Question findOne(Long id) {
        return em.find(Question.class, id);
    }

    public Question findByNum(Long num) {
        return em.createQuery("select q from Question q where q.num = :num", Question.class)
                .setParameter("num", num).getSingleResult();
    }
}
