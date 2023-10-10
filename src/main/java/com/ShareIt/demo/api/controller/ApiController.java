package com.ShareIt.demo.api.controller;

import com.ShareIt.demo.api.dto.*;
import com.ShareIt.demo.domain.*;
import com.ShareIt.demo.service.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ApiController {
    private final MemberService memberService;
    private final AnswerService answerService;
    private final TendencyService tendencyService;
    private final QuestionService questionService;
    private final VisitedService visitedService;

//    //회원 등록
//    @PostMapping("/start")
//    public ResponseEntity<MemberDto> saveMember() {
//
//        Member member = new Member();
//        /*member.register(request.getToken());*/
//        memberService.join(member);
//        Tendency tendency = Tendency.createTendency(member); // tendency까지 생성해서 매핑
//        tendencyService.save(tendency);
//
//        MemberDto memberDto = new MemberDto(member.getId());
//        return ResponseEntity.ok().body(memberDto);
//    }

    // 문제풀이
    @PostMapping("/answer/{memberId}/{answerId}")
    public ResponseEntity<ResponseDto> updateMember(
            @PathVariable("memberId") Long memberId,
            @PathVariable("answerId") Long answerId) {


        Answer answer = answerService.findOne(answerId);
        Tendency tendency = tendencyService.findByMemberId(memberId);


        // tendency에 answer 값 저장
        tendency.update_tenTypeIE(answer.getTenTypeIE());
        tendency.update_tenTypeNS(answer.getTenTypeNS());
        tendency.update_tenTypeTF(answer.getTenTypeTF());
        tendency.update_tenTypePJ(answer.getTenTypePJ());

        tendencyService.save(tendency);

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
    @GetMapping("/result/{memberId}")
    public ResponseEntity getResult(@PathVariable("memberId") Long memberId) {
        Member member = memberService.findOne(memberId);
        Tendency tendency = tendencyService.findByMemberId(memberId);
        tendency.makeResult();
        tendencyService.save(tendency);
        //방문자수 count 증가
        visitedService.increase();

        TenType ten=tendency.getType();
        if(ten.equals(TenType.INTP)) {
            // AI
        }
        else if(ten.equals(TenType.INTJ)) {
            // 풀스택
        }
        else if(ten.equals(TenType.INFP)) {
            // 웹디자이너
        }
        else if(ten.equals(TenType.INFJ)) {
            // 보안개발자
        }
        else if(ten.equals(TenType.ISTP)) {
            //블록 체인 개발자
        }
        else if(ten.equals(TenType.ISTJ)) {
            //백엔드
        }
        else if(ten.equals(TenType.ISFP)) {
            // 네트워크
        }
        else if(ten.equals(TenType.ISFJ)) {
            //빅데이터
        }
        else if(ten.equals(TenType.ENTP)) {
            //IOS
        }
        else if(ten.equals(TenType.ENTJ)) {
            //게임 개발자
        }
        else if(ten.equals(TenType.ENFP)) {
            // 그래픽 개발자
        }
        else if(ten.equals(TenType.ENFJ)) {
            //프론트
        }
        else if(ten.equals(TenType.ESTP)) {
            // 안드로이드
        }
        else if(ten.equals(TenType.ESTJ)) {
            // 데브옵스
        }
        else if(ten.equals(TenType.ESFP)) {
            // 임베디드
        }
        else if(ten.equals(TenType.ESFJ)) {
            // 기획자
        }

        ResultDto resultDto = new ResultDto(member);
        return ResponseEntity.ok().body(resultDto);
    }

    @GetMapping("/visited")
    public VisitedDto visited(){
        int count = visitedService.getCount();

        VisitedDto visitedDto = new VisitedDto();
        visitedDto.setVisited(count);

        return visitedDto;
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
