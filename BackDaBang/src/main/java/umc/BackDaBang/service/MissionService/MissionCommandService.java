package umc.BackDaBang.service.MissionService;

import umc.BackDaBang.web.dto.Mission.MissionRequest.CreateMission;

public interface MissionCommandService {
    public Long createMission(String storeName, CreateMission request);
}
