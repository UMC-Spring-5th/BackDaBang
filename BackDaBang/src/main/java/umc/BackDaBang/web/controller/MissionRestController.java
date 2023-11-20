package umc.BackDaBang.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.MemberMissionConverter;
import umc.BackDaBang.converter.MissionConverter;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.mapping.MemberMission;
import umc.BackDaBang.service.MemberMissionService.MemberMissionService;
import umc.BackDaBang.service.MissionService.MissionService;
import umc.BackDaBang.web.dto.Mission.MissionRequestDTO;
import umc.BackDaBang.web.dto.Mission.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionService missionService;
    private final MemberMissionService memberMissionService;
    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDTO> createMission (
            @RequestBody @Valid MissionRequestDTO.CreateMissionDTO request) {
        Mission mission = missionService.createMission(request);

        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDTO(mission));
    }

    @PatchMapping("/challenge")
    public ApiResponse<MissionResponseDTO.ChallengeMissionDTO> challengeMission(
            @RequestBody @Valid MissionRequestDTO.ChallengeMissionDTO request) {

        MemberMission memberMission = memberMissionService.challengeMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeMissionDTO(memberMission));
    }
}
