package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.web.dto.MissionRequestDTO;
import umc.BackDaBang.web.dto.MissionResultDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResultDTO.CreateResultDTO toCreateResultDTO(Mission mission) {
        return MissionResultDTO.CreateResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.CreateDTO request) {
        return Mission.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .point(request.getPoint())
                .deadline(request.getDeadline())
                .authorizationCode(request.getAuthorizationCode())
                .build();
    }
}
