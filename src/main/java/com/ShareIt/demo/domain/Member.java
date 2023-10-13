package com.ShareIt.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    @OneToOne(mappedBy = "member")
    private Tendency tendencies;

    @OneToMany(mappedBy = "member")
    private List<Answer> answers = new ArrayList<>();

    /*public void register(String token) {
        this.token = token;
    }*/
}
