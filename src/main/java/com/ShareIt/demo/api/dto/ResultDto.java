package com.ShareIt.demo.api.dto;

import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.domain.TenType;
import lombok.Data;

import javax.persistence.Enumerated;


@Data
public class ResultDto {
    private Long memberId;
    private String token;
    private TenType tenType;

    public ResultDto(Member member) {
        this.memberId = member.getId();
        this.token = member.getToken();
        this.tenType = member.getTendencies().getType();
    }
}
