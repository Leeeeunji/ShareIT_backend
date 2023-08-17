package com.ShareIt.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Answer {
    @Id @GeneratedValue
    @Column(name = "answer_id")
    private Long id;

    private Long num; // 답변 번호

    private String content;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    private int TenTypeIE; // I: +, E: -
    private int TenTypeNS; // N: +, S: -
    private int TenTypeTF; // T: +, F: -
    private int TenTypePJ; // P: +, J: -

    // 연관관계 메서드
    public void setMember(Member member) {
        this.member = member;
        member.getAnswers().add(this);
    }

    public void setQuestion(Question question) { // Question 존재하는 상태에서 Answer 추가한다고 가정
        this.question = question;
        question.getAnswers().add(this);
    }
}
