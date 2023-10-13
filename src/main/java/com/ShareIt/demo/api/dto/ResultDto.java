package com.ShareIt.demo.api.dto;

import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.domain.TenType;
import com.ShareIt.demo.domain.Tendency;
import lombok.Data;

import javax.persistence.Enumerated;


@Data
public class ResultDto {
    private Long memberId;
    // private String token;
    private TenType tenType;

    public ResultDto(Tendency tendency) {
        this.memberId = tendency.getId()-1;
        // this.token = member.getToken();
        this.tenType = tendency.getType();
    }
}
