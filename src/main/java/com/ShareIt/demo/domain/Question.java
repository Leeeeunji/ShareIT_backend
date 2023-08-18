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

    @OneToMany(fetch = FetchType.LAZY)
    private List<Answer> answers = new ArrayList<>();
}
