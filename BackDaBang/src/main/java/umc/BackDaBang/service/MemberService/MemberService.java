package umc.BackDaBang.service.MemberService;

import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.common.EntityLoader;
import umc.BackDaBang.web.dto.Member.MemberRequestDTO;

public interface MemberService extends EntityLoader<Member,Long> {
     Member joinMember(MemberRequestDTO.JoinDto request);
}
