package umc.BackDaBang.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.MissionConverter;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.service.MissionService.MissionCommandService;
import umc.BackDaBang.web.dto.MissionRequestDTO;
import umc.BackDaBang.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    @Operation(summary = "미션 등록 API", description = "특정 가게에 미션을 등록하는 API 입니다.")
    @Parameter(name = "storeId", description = "가게의 아이디, request parameter 입니다.")
    public ApiResponse<MissionResponseDTO.EnrollMissionResultDTO> enrollMission(@RequestParam(name = "storeId") Long storeId,
                                                                                @RequestBody @Valid MissionRequestDTO.EnrollMissionDTO request) {
        Mission newMission = missionCommandService.enrollMission(storeId, request);
        return ApiResponse.onSuccess(MissionConverter.toCreateResultDTO(newMission));
    }
}
