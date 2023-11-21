package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.web.dto.MissionRequestDTO;
import umc.BackDaBang.web.dto.MissionResponseDTO;

import java.util.UUID;

public class MissionConverter {

    public static MissionResponseDTO.EnrollMissionResultDTO toCreateResultDTO(Mission mission) {
        return MissionResponseDTO.EnrollMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.EnrollMissionDTO request) {
        return Mission.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .point(request.getPoint())
                .deadline(request.getDeadline())
                .authorizationCode(UUID.randomUUID().toString())
                .build();
    }
}
