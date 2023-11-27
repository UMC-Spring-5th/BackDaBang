package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.mapping.MemberMission;
import umc.BackDaBang.web.dto.Mission.MissionResponseDTO;

import java.util.List;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(Mission mission) {
        return MemberMission.builder()
                .isSuccess(Boolean.FALSE)
                .mission(mission)
                .build();
    }


    public static MissionResponseDTO.ChallengeMissionDTO toChallengeMissionDTO(MemberMission memberMission) {
        return MissionResponseDTO.ChallengeMissionDTO.builder()
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .build();
    }

    public static MissionResponseDTO.CompleteMissionDTO toCompleteMissionDTO(MemberMission memberMission) {
        return MissionResponseDTO.CompleteMissionDTO.builder()
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .build();
    }
}
