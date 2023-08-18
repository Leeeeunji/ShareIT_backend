package com.ShareIt.demo.api.dto;

import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.domain.TenType;
import lombok.Data;


@Data
public class ResultDto {
    private Long memberId;
    private String token;
    private TenType tenType;

    public ResultDto(Member member) {
        memberId = member.getId();
        token = member.getToken();
        tenType = member.getTendencies().get(1).getType();
    }
}
