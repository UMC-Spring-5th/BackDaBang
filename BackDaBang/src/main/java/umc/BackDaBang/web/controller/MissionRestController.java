package umc.BackDaBang.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.service.MissionService.MissionCommandService;
import umc.BackDaBang.web.dto.Mission.MissionRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping
    public ApiResponse<Long> createMission(@RequestParam String storeName,
                                           @RequestBody MissionRequest.CreateMission request) {
        System.out.println(storeName);
        System.out.println(request.getDeadline());

        return ApiResponse.onSuccess(missionCommandService.createMission(storeName, request));
    }
}
