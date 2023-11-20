package umc.BackDaBang.service.MemberService;

import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.common.EntityLoader;
import umc.BackDaBang.domain.mapping.MemberMission;

import java.util.List;

public interface MemberQueryService extends EntityLoader<Member, Long> {

    List<MemberMission> getMemberMissions(Long memberId, Boolean isSucceed);
}
