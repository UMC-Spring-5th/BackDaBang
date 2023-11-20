package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.web.dto.Mission.MissionRequestDTO;
import umc.BackDaBang.web.dto.Mission.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.CreateMissionDTO request) {
        return Mission.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .point(request.getPoint())
                .authorizationCode(request.getAuthorizationCode())
                .deadline(request.getDeadline())
                .build();
    }

    public static MissionResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission) {
        return MissionResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
