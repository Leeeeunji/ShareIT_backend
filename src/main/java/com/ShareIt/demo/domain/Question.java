package com.ShareIt.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Question {
    @Id @GeneratedValue
    @Column(name = "question_id")
    private Long id;
    
    private Long num; // 문제 번호

    private String content;
    // DB 초기화할때 question, answer 다 저장해 놓은 뒤 문제를 풀때마다 사람이 선택한 answer을 저장? ㅇㅇ

    @OneToMany(fetch = FetchType.LAZY)
    private List<Answer> answers = new ArrayList<>();
}
