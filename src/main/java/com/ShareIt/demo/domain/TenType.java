package com.ShareIt.demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TenType {
    INFP, INFJ, INTP, INTJ, ISFP, ISFJ, ISTP, ISTJ, ENFP, ENFJ, ENTP, ENTJ, ESFP, ESFJ, ESTP, ESTJ;

    @JsonCreator
    public static TenType from(String s) {
        return TenType.valueOf(s.toUpperCase());
    }
}
