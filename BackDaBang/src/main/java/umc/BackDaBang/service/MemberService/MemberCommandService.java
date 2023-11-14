package umc.BackDaBang.service.MemberService;

import umc.BackDaBang.domain.Member;
import umc.BackDaBang.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    Member signUpMember(MemberRequestDTO.SignUpDTO request);
}
