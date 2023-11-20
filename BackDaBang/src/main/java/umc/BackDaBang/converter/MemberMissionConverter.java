package umc.BackDaBang.converter;

import org.springframework.data.domain.Page;
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

    private static MemberResponseDTO.MemberMissionDTO toMemberMissionDTO(MemberMission memberMission) {
        return MemberResponseDTO.MemberMissionDTO.builder()
                .memberMissionId(memberMission.getId())
                .title(memberMission.getMission().getTitle())
                .content(memberMission.getMission().getContent())
                .point(memberMission.getMission().getPoint())
                .deadline(memberMission.getMission().getDeadline())
                .createdAt(memberMission.getCreatedAt().toLocalDate())
                .build();
    }

    public static List<MemberResponseDTO.MemberMissionDTO> toMemberMissionListDTO(List<MemberMission> memberMissionList) {
        return memberMissionList.stream()
                .map(MemberMissionConverter::toMemberMissionDTO)
                .toList();
    }
}
