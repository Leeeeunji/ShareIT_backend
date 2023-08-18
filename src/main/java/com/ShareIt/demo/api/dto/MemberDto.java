package com.ShareIt.demo.api.dto;

import lombok.Data;

@Data
public class MemberDto {
    private Long memberId;

    public MemberDto(Long memberId) {
        this.memberId=memberId;
    }
}
