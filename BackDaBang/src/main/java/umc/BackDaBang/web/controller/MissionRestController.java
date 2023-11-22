package umc.BackDaBang.web.controller;


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
    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDTO> createMission (
            @RequestBody @Valid MissionRequestDTO.CreateMissionDTO request) {
        Mission mission = missionCommandService.createMission(request);

        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDTO(mission));
    }

    @PatchMapping("/challenge")
    public ApiResponse<MissionResponseDTO.ChallengeMissionDTO> challengeMission(
            @RequestParam Long memberId,
            @RequestParam Long missionId) {

        MemberMission memberMission = missionCommandService.challengeMission(memberId, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeMissionDTO(memberMission));
    }
}
