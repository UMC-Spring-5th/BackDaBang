package umc.BackDaBang.service.MissionService;

import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.web.dto.Mission.MissionRequestDTO;

public interface MissionService {
    Mission createMission(MissionRequestDTO.CreateMissionDTO request);
}
