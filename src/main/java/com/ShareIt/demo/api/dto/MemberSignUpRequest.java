package com.ShareIt.demo.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MemberSignUpRequest {
    @NotBlank(message = "이름을 입력하세요.")
    private String token;
}
