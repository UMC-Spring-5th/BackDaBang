package umc.BackDaBang.service.MissionService;

import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.common.EntityLoader;
import umc.BackDaBang.web.dto.MissionRequestDTO;

public interface MissionCommandService extends EntityLoader<Mission, Long> {
    Mission enrollMission(Long storeId, MissionRequestDTO.EnrollMissionDTO request);
}
