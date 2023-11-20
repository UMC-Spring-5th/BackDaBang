package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.web.dto.MissionRequestDTO;
import umc.BackDaBang.web.dto.MissionResponseDTO;

public class MissionConverter {

    public static MissionResponseDTO.CreateResultDTO toCreateResultDTO(Mission mission) {
        return MissionResponseDTO.CreateResultDTO.builder()
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
