package com.ShareIt.demo;

import com.ShareIt.demo.domain.Answer;
import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.QuestionAnswerDbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

         /**
         * question & answer 초기화
         */

        public void QuestionAnswerDbInit() {
            Member member=new Member();
            member.setToken("hyoseong");
            em.persist(member);

            List<Question> questions = new ArrayList<>(11);
            for (int i = 0; i <= 10; i++) questions.add(new Question());
            List<Answer> answers = new ArrayList<>(41);
            for (int i = 0; i <= 40; i++) answers.add(new Answer());
            for (int i = 1; i <= 10; i++) {
                questions.get(i).setContent("q" + i);
                questions.get(i).setNum(new Long(i));
                em.persist(questions.get(i));
                for (int j = 1; j <= 4; j++) {
                    int ansIdx = 4 * (i-1) + j;
                    if (j == 1) {
                        answers.get(ansIdx).setTenTypeIE(1);
                        answers.get(ansIdx).setTenTypeNS(1);
                    } else if (j == 2) {
                        answers.get(ansIdx).setTenTypeTF(-1);
                        answers.get(ansIdx).setTenTypePJ(-1);
                    } else if (j == 3) {
                        answers.get(ansIdx).setTenTypeTF(1);
                        answers.get(ansIdx).setTenTypeNS(-1);
                    } else {
                        answers.get(ansIdx).setTenTypeIE(-1);
                        answers.get(ansIdx).setTenTypePJ(1);
                    }
                    answers.get(ansIdx).setNum(new Long(j));
                    answers.get(ansIdx).setContent("a" + i + "-" + j);
                    answers.get(ansIdx).setQuestion(questions.get(i));
                    em.persist(answers.get(ansIdx));
                }
            }
        }
    }
}

