package umc.BackDaBang.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.MemberHandler;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.mapping.MemberMission;
import umc.BackDaBang.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    @Override
    public List<MemberMission> getMemberMissionList(Long memberId, Boolean isSucceed) {
        Member member = loadEntity(memberId);
        List<MemberMission> allMemberMissions = member.getMemberMissionList();
        if(isSucceed)
            return allMemberMissions.stream()
                    .filter(MemberMission::getIsSuccess)
                    .toList();
        return allMemberMissions.stream()
                .filter(memberMission -> memberMission.getIsSuccess().equals(Boolean.FALSE))
                .toList();
    }

    @Override
    public Member loadEntity(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if(member.isEmpty()) throw new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND);
        return member.get();
    }
}
