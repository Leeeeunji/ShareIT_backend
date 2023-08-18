package com.ShareIt.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String token;

    @OneToMany(mappedBy = "member")
    private List<Tendency> tendencies = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Answer> answers = new ArrayList<>();

    public void addTendency(Tendency tendency) {
        tendencies.add(tendency);
    }

    public void register(String token) {
        this.token = token;
    }
}
