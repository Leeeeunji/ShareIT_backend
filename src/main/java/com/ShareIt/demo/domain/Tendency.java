package com.ShareIt.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private int tenTypeIE; // I: +, E: -
    private int tenTypeNS; // N: +, S: -
    private int tenTypeTF; // T: +, F: -
    private int tenTypePJ; // P: +, J: -

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    /**
     * tendency 생성
     */
    public static Tendency createTendency(Member member) {
        Tendency tendency = new Tendency();
        tendency.setMember(member);
        tendency.setTenTypeIE(0);
        tendency.setTenTypeNS(0);
        tendency.setTenTypeTF(0);
        tendency.setTenTypePJ(0);

        return tendency;
    }
    
    public void makeResult() {
        // TenType Setting
        if (tenTypeIE <= 0 && tenTypeNS >= 0 && tenTypeTF >= 0 && tenTypePJ >= 0) {         // 1. intp
            type = TenType.INTP;
        } else if (tenTypeIE <= 0 && tenTypeNS >= 0 && tenTypeTF >= 0 && tenTypePJ < 0) {   // 2. intj
            type = TenType.INTJ;
        } else if (tenTypeIE <= 0 && tenTypeNS >= 0 && tenTypeTF < 0 && tenTypePJ >= 0) {    // 3. infp
            type = TenType.INFP;
        } else if (tenTypeIE <= 0 && tenTypeNS >= 0 && tenTypeTF < 0 && tenTypePJ < 0) {    // 4. infj
            type = TenType.INFJ;
        } else if (tenTypeIE <= 0 && tenTypeNS < 0 && tenTypeTF >= 0 && tenTypePJ >= 0) {   // 5. istp
            type = TenType.ISTP;
        } else if (tenTypeIE <= 0 && tenTypeNS < 0 && tenTypeTF >= 0 && tenTypePJ < 0) {    // 6. istj
            type = TenType.ISTJ;
        } else if (tenTypeIE <= 0 && tenTypeNS < 0 && tenTypeTF < 0 && tenTypePJ >= 0) {    // 7. isfp
            type = TenType.ISFP;
        } else if (tenTypeIE <= 0 && tenTypeNS < 0 && tenTypeTF < 0 && tenTypePJ < 0) {     // 8. isfj
            type = TenType.ISFJ;
        } else if (tenTypeIE > 0 && tenTypeNS >= 0 && tenTypeTF >= 0 && tenTypePJ >= 0) {  // 9. entp
            type = TenType.ENTP;
        } else if (tenTypeIE > 0 && tenTypeNS >= 0 && tenTypeTF >= 0 && tenTypePJ < 0) {   // 10. entj
            type = TenType.ENTJ;
        } else if (tenTypeIE > 0 && tenTypeNS >= 0 && tenTypeTF < 0 && tenTypePJ >= 0) {    // 11. enfp
            type = TenType.ENFP;
        } else if (tenTypeIE > 0 && tenTypeNS >= 0 && tenTypeTF < 0 && tenTypePJ < 0) {    // 12. enfj
            type = TenType.ENFJ;
        } else if (tenTypeIE > 0 && tenTypeNS < 0 && tenTypeTF >= 0 && tenTypePJ >= 0) {   // 13. estp
            type = TenType.ESTP;
        } else if (tenTypeIE > 0 && tenTypeNS < 0 && tenTypeTF >= 0 && tenTypePJ < 0) {    // 14. estj
            type = TenType.ESTJ;
        } else if (tenTypeIE > 0 && tenTypeNS < 0 && tenTypeTF < 0 && tenTypePJ >= 0) {    // 15. esfp
            type = TenType.ESFP;
        } else if (tenTypeIE > 0 && tenTypeNS < 0 && tenTypeTF < 0 && tenTypePJ < 0) {     // 16. esfj
            type = TenType.ESFJ;
        }
    }

   // 연관관계 메서드
    public void setMember(Member member) {
        this.member = member;
    }

    public void update_tenTypeIE(int num) {
        this.tenTypeIE += num;
    }

    public void update_tenTypeNS(int num) {
        this.tenTypeNS += num;
    }

    public void update_tenTypeTF(int num) {
        this.tenTypeTF += num;
    }

    public void update_tenTypePJ(int num) {
        this.tenTypePJ += num;
    }
}
