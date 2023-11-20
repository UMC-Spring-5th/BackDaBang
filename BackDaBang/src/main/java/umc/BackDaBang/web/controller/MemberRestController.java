package umc.BackDaBang.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.MemberConverter;
import umc.BackDaBang.converter.MemberMissionConverter;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.mapping.MemberMission;
import umc.BackDaBang.service.MemberService.MemberCommandService;
import umc.BackDaBang.service.MemberService.MemberQueryService;
import umc.BackDaBang.web.dto.MemberRequestDTO;
import umc.BackDaBang.web.dto.MemberResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    /**
     * 회원가입 API
     * @param request 회원가입을 위한 유저 정보
     * @return 회원가입 response DTO
     */
    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.SignUpResultDTO> signUp(@RequestBody @Valid MemberRequestDTO.SignUpDTO request) {
        Member member = memberCommandService.signUpMember(request);
        return ApiResponse.onSuccess(MemberConverter.toSignUpResultDTO(member));
    }

    /**
     * 회원 미션 시작 API
     * @param memberId 미션 시작할 유저
     * @param missionId 시작할 미션
     * @return 회원 미션 response DTO
     */
    @PostMapping("/missions")
    public ApiResponse<MemberResponseDTO.StartMissionResultDTO> startMission(@RequestParam Long memberId,
                                                                             @RequestParam Long missionId) {
        MemberMission memberMission = memberCommandService.startMission(memberId, missionId);
        return ApiResponse.onSuccess(MemberConverter.toStartMissionResultDTO(memberMission));
    }

    /**
     * 마이페이지 조회 API
     * @param memberId 조회할 유저
     * @return 마이페이지 response DTO
     */
    @GetMapping("/")
    public ApiResponse<MemberResponseDTO.MyPageResultDTO> getMyPage(@RequestParam Long memberId) {
        Member member = memberCommandService.loadEntity(memberId);
        return ApiResponse.onSuccess(MemberConverter.toMyPageResultDTO(member));
    }

    /**
     * 특정 유저의 미션 조회 API
     * @param memberId 조회할 유저
     * @param isSucceed 조회활 미션 종류(완료 or 진행 중)
     * @return 유저 미션 response DTO
     */
    @GetMapping("/missions")
    public ApiResponse<List<MemberResponseDTO.MemberMissionResultDTO>> getMemberMissions(@RequestParam Long memberId,
                                                                                        @RequestParam Boolean isSucceed) {
        List<MemberMission> memberMissions = memberQueryService.getMemberMissions(memberId, isSucceed);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResultList(memberMissions));
    }
}
