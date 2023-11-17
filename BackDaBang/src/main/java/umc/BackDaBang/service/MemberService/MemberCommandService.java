package umc.BackDaBang.service.MemberService;

import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.common.EntityLoader;
import umc.BackDaBang.web.dto.MemberRequestDTO;

public interface MemberCommandService extends EntityLoader<Member, Long> {

    Member signUpMember(MemberRequestDTO.SignUpDTO request);
}
