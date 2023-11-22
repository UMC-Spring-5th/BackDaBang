package umc.BackDaBang.service.MissionService;

import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.common.EntityLoader;
import umc.BackDaBang.domain.mapping.MemberMission;
import umc.BackDaBang.web.dto.Mission.MissionRequestDTO;

public interface MissionService extends EntityLoader<Mission,Long> {
    Mission createMission(MissionRequestDTO.CreateMissionDTO request);
    MemberMission challengeMission(Long memberId, Long missionId);
}
