package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.mapping.MemberMission;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(Mission mission) {
        return MemberMission.builder()
                .isSuccess(Boolean.FALSE)
                .mission(mission)
                .build();
    }
}
