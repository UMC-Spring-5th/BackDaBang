package umc.BackDaBang.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.MemberConverter;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.mapping.MemberMission;
import umc.BackDaBang.service.MemberService.MemberCommandService;
import umc.BackDaBang.web.dto.MemberRequestDTO;
import umc.BackDaBang.web.dto.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.SignUpResultDTO> signUp(@RequestBody @Valid MemberRequestDTO.SignUpDTO request) {
        Member member = memberCommandService.signUpMember(request);
        return ApiResponse.onSuccess(MemberConverter.toSignUpResultDTO(member));
    }

    @PostMapping("/missions")
    public ApiResponse<MemberResponseDTO.StartMissionResultDTO> startMission(@RequestParam Long memberId,
                                                                             @RequestParam Long missionId) {
        MemberMission memberMission = memberCommandService.startMission(memberId, missionId);
        return ApiResponse.onSuccess(MemberConverter.toStartMissionResultDTO(memberMission));
    }
}
