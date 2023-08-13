package com.ShareIt.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Tendency {
    @Id
    @GeneratedValue
    @Column(name = "tendency_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TenType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    /**
     * tendency 생성
     */
    public static Tendency createTendency(Member member) {
        Tendency tendency = new Tendency();
        tendency.setMember(member);
        List<Answer> answers = member.getAnswers();

        int ie = 0, ns = 0, tf = 0, pj = 0; // 앞글자 +, 뒷글자 -

        for (Answer answer : answers) {
            ie += answer.getTenTypeIE();
            ns += answer.getTenTypeNS();
            tf += answer.getTenTypeTF();
            pj += answer.getTenTypePJ();
        }

        // TenType Setting
        if (ie >= 0 && ns >= 0 && tf >= 0 && pj >= 0) {         // 1. intp
            tendency.setType(TenType.INTP);
        } else if (ie >= 0 && ns >= 0 && tf >= 0 && pj < 0) {   // 2. intj
            tendency.setType(TenType.INTJ);
        } else if (ie>= 0 && ns >= 0 && tf < 0 && pj >= 0) {    // 3. infp
            tendency.setType(TenType.INFP);
        } else if (ie >= 0 && ns >= 0 && tf < 0 && pj < 0) {    // 4. infj
            tendency.setType(TenType.INFJ);
        } else if (ie >= 0 && ns < 0 && tf >= 0 && pj >= 0) {   // 5. istp
            tendency.setType(TenType.ISTP);
        } else if (ie >= 0 && ns < 0 && tf >= 0 && pj < 0) {    // 6. istj
            tendency.setType(TenType.ISTJ);
        } else if (ie >= 0 && ns < 0 && tf < 0 && pj >= 0) {    // 7. isfp
            tendency.setType(TenType.ISFP);
        } else if (ie >= 0 && ns < 0 && tf < 0 && pj < 0) {     // 8. isfj
            tendency.setType(TenType.ISFJ);
        } else if (ie < 0 && ns >= 0 && tf >= 0 && pj >= 0) {  // 9. entp
            tendency.setType(TenType.ENTP);
        } else if (ie < 0 && ns >= 0 && tf >= 0 && pj < 0) {   // 10. entj
            tendency.setType(TenType.ENTJ);
        } else if (ie < 0 && ns >= 0 && tf < 0 && pj >= 0) {    // 11. enfp
            tendency.setType(TenType.ENFP);
        } else if (ie < 0 && ns >= 0 && tf < 0 && pj < 0) {    // 12. enfj
            tendency.setType(TenType.ENFJ);
        } else if (ie < 0 && ns < 0 && tf >= 0 && pj >= 0) {   // 13. estp
            tendency.setType(TenType.ESTP);
        } else if (ie < 0 && ns < 0 && tf >= 0 && pj < 0) {    // 14. estj
            tendency.setType(TenType.ESTJ);
        } else if (ie < 0 && ns < 0 && tf < 0 && pj >= 0) {    // 15. esfp
            tendency.setType(TenType.ESFP);
        } else if (ie < 0 && ns < 0 && tf < 0 && pj < 0) {     // 16. esfj
            tendency.setType(TenType.ESFJ);
        }

        return tendency;
    }

   // 연관관계 메서드
    public void setMember(Member member) {
        this.member = member;
        member.getTendencies().add(this);
    }
}
