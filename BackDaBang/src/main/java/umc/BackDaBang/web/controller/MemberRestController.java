package umc.BackDaBang.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
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

    @PostMapping("/")
    @Operation(summary = "회원가입 API", description = "새로운 회원을 가입하는 API 입니다,")
    public ApiResponse<MemberResponseDTO.SignUpDTO> signUp(@RequestBody @Valid MemberRequestDTO.SignUpDTO request) {
        Member member = memberCommandService.signUpMember(request);
        return ApiResponse.onSuccess(MemberConverter.toSignUpDTO(member));
    }

    @PostMapping("/missions/{missionId}")
    @Operation(summary = "멤버 미션 등록 API", description = "특정 미션을 시작하는 API 입니다.")
    @Parameters({
            @Parameter(name = "missionId", description = "미션의 아이디, path variable 입니다."),
            @Parameter(name = "memberId", description = "멤버의 아이디, request parameter 입니다.")
    })
    public ApiResponse<MemberResponseDTO.StartMissionDTO> startMission(@PathVariable(name = "missionId") Long missionId,
                                                                       @RequestParam(name = "memberId") Long memberId) {
        MemberMission memberMission = memberCommandService.startMission(memberId, missionId);
        return ApiResponse.onSuccess(MemberConverter.toStartMissionDTO(memberMission));
    }

    @GetMapping("/")
    @Operation(summary = "마이 페이지 조회 API", description = "특정 멤버의 정보를 조회하는 API 입니다.")
    @Parameter(name = "memberId", description = "멤버의 아이디, request parameter 입니다.")
    public ApiResponse<MemberResponseDTO.MyPageDTO> getMyPage(@RequestParam(name = "memberId") Long memberId) {
        Member member = memberCommandService.loadEntity(memberId);
        return ApiResponse.onSuccess(MemberConverter.toMyPageDTO(member));
    }

    @GetMapping("/missions")
    @Operation(summary = "멤버 미션 조회 API", description = "특정 멤버의 미션을 조회하는 API 입니다.")
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, request parameter 입니다."),
            @Parameter(name = "isSucceed", description = "조회할 미션의 완료 여부, request parameter 입니다."),
    })
    public ApiResponse<List<MemberResponseDTO.MemberMissionDTO>> getMemberMissions(@RequestParam(name = "memberId") Long memberId,
                                                                                 @RequestParam(name = "isSucceed") Boolean isSucceed) {
        List<MemberMission> memberMissionList = memberQueryService.getMemberMissionList(memberId, isSucceed);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionListDTO(memberMissionList));
    }
}
