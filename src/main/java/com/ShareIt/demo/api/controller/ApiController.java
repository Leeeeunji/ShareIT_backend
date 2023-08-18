package com.ShareIt.demo.api.controller;

import com.ShareIt.demo.api.dto.MemberSignUpRequest;
import com.ShareIt.demo.api.dto.QuestionDto;
import com.ShareIt.demo.api.dto.ResponseDto;
import com.ShareIt.demo.api.dto.ResultDto;
import com.ShareIt.demo.domain.Answer;
import com.ShareIt.demo.domain.Member;
import com.ShareIt.demo.domain.Question;
import com.ShareIt.demo.domain.Tendency;
import com.ShareIt.demo.service.AnswerService;
import com.ShareIt.demo.service.MemberService;
import com.ShareIt.demo.service.QuestionService;
import com.ShareIt.demo.service.TendencyService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ApiController {
    private final MemberService memberService;
    private final AnswerService answerService;
    private final TendencyService tendencyService;
    private final QuestionService questionService;

    //회원 등록
    @PostMapping("/member/save")
    public ResponseEntity<ResponseDto> saveMember(@RequestBody @Validated MemberSignUpRequest request) {

        Member member = new Member();
        member.register(request.getToken());
        memberService.join(member);
        Tendency tendency = Tendency.createTendency(member); // tendency까지 생성해서 매핑
        tendencyService.save(tendency);

        return ResponseEntity.ok().body(new ResponseDto("회원가입이 완료되었습니다."));
    }

    // 문제풀이
    @PostMapping("/answer/{memberId}/{answerId}")
    public ResponseEntity<ResponseDto> updateMember(
            @PathVariable("memberId") Long memberId,
            @PathVariable("answerId") Long answerId,
            @RequestBody @Valid UpdateMemberRequest request) {

        Member member = memberService.findOne(memberId);
        Answer answer = answerService.findOne(answerId);
        Tendency tendency = member.getTendencies().get(0);

        // tendency에 answer 값 저장
        int temp;
        temp = tendency.getTenTypeIE() + answer.getTenTypeIE();
        tendency.setTenTypeIE(temp);
        temp = tendency.getTenTypeNS() + answer.getTenTypeNS();
        tendency.setTenTypeNS(temp);
        temp = tendency.getTenTypeTF() + answer.getTenTypeTF();
        tendency.setTenTypeTF(temp);
        temp = tendency.getTenTypePJ() + answer.getTenTypePJ();
        tendency.setTenTypePJ(temp);

        return ResponseEntity.ok().body(new ResponseDto("답변이 성공적으로 저장되었습니다."));
    }

    // 문제 & 답안 표시
    @GetMapping("/question/{num}")
    public ResponseEntity getQuestion(@PathVariable("num") Long num) {
        Question question = questionService.findByNum(num);

        QuestionDto questionDto = new QuestionDto(question);

        return ResponseEntity.ok().body(questionDto);
    }
    
    // Tendency 계산 및 결과 표시
    @GetMapping("/result/{memberId}/")
    public ResponseEntity getResult(@PathVariable("memberId") Long memberId) {
        Member member = memberService.findOne(memberId);
        Tendency tendency = member.getTendencies().get(0);
        tendency.makeResult();

        tendencyService.save(tendency);

        ResultDto resultDto = new ResultDto(member);

        return ResponseEntity.ok().body(resultDto);
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse {
        private Long memberId;
        private Long answerId;
    }

    @Data
    static class UpdateMemberRequest {
        private String name;
    }
}
