package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.mapping.MemberMission;
import umc.BackDaBang.web.dto.MemberResponseDTO;

import java.util.List;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(Mission mission) {
        return MemberMission.builder()
                .isSuccess(Boolean.FALSE)
                .mission(mission)
                .build();
    }

    public static List<MemberResponseDTO.MemberMissionResultDTO> toMemberMissionResultList(List<MemberMission> memberMissions) {
        return memberMissions.stream()
                .map(memberMission -> toMemberMissionResult(memberMission.getId(), memberMission.getMission()))
                .toList();

    }

    private static MemberResponseDTO.MemberMissionResultDTO toMemberMissionResult(Long memberMissionId, Mission mission) {
        return MemberResponseDTO.MemberMissionResultDTO.builder()
                .memberMissionId(memberMissionId)
                .title(mission.getTitle())
                .content(mission.getContent())
                .point(mission.getPoint())
                .build();
    }
}
