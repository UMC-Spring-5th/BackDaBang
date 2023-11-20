package umc.BackDaBang.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.MissionConverter;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.service.MissionService.MissionService;
import umc.BackDaBang.web.dto.Mission.MissionRequestDTO;
import umc.BackDaBang.web.dto.Mission.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionService missionService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDTO> createMission (
            @RequestBody @Valid MissionRequestDTO.CreateMissionDTO request) {
        Mission mission = missionService.createMission(request);

        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDTO(mission));
    }
}