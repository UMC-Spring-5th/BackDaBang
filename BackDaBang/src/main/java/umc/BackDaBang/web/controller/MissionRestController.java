package umc.BackDaBang.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.MemberMissionConverter;
import umc.BackDaBang.converter.MissionConverter;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.mapping.MemberMission;
import umc.BackDaBang.service.MissionService.MissionCommandService;
import umc.BackDaBang.web.dto.Mission.MissionRequestDTO;
import umc.BackDaBang.web.dto.Mission.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;


    @Operation(summary = "미션 생성 API", description = "미션 생성 API입니다.")
    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDTO> createMission (
            @RequestBody @Valid MissionRequestDTO.CreateMissionDTO request) {
        Mission mission = missionCommandService.createMission(request);

        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDTO(mission));
    }

    @Operation(summary = "미션을 도전하는 API", description = "미션을 도전하는 API입니다. memberId와 missionId를 query string으로 주세요.")
    @Parameters({
            @Parameter(name = "memberId", description = "memberId 입니다."),
            @Parameter(name = "missionId",description = "missionId 입니다.")
    })
    @PostMapping("/challenge")
    public ApiResponse<MissionResponseDTO.ChallengeMissionDTO> challengeMission(
            @RequestParam Long memberId,
            @RequestParam Long missionId) {

        MemberMission memberMission = missionCommandService.challengeMission(memberId, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeMissionDTO(memberMission));
    }


    @Operation(summary = "진행중인 미션 진행 완료로 바꾸기 API",description = "진행 중인 미션을 진행 완료로 바꾸는 미션입니다.")
    @Parameters({
            @Parameter(name = "memberId", description = "memberId request param입니다."),
            @Parameter(name = "missionId", description = "missionId request param입니다."),
            @Parameter(name = "authorizationCode",description = "authrizationCode request param입니다.")
    })

    @PatchMapping("/complete")
    public ApiResponse<MissionResponseDTO.CompleteMissionDTO> completeMission (
            @RequestParam Long memberId,
            @RequestParam Long missionId,
            @RequestParam String authorizationCode
            ) {
        MemberMission memberMission = missionCommandService.CompleteMission(memberId,missionId,authorizationCode);
        return ApiResponse.onSuccess(MemberMissionConverter.toCompleteMissionDTO(memberMission));
    }
}
