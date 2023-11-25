package umc.BackDaBang.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.MemberHandler;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.mapping.MemberMission;
import umc.BackDaBang.repository.MemberMissionRepository;
import umc.BackDaBang.repository.MemberRepository;
import umc.BackDaBang.service.ReviewService.ReviewQueryService;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final ReviewQueryService reviewQueryService;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {

        Member member = loadEntity(memberId);
        return reviewQueryService.findMemberReviews(member, page);

    }

    @Override
    public Page<Mission> getMissionList(Long memberId, Integer page) {
        Member member =loadEntity(memberId);

        Page<MemberMission> memberMissionsPage = memberMissionRepository
                .findByMemberAndIsSuccessIsFalse(member, PageRequest.of(page,10));

        List<Mission> missions = memberMissionsPage.getContent().stream()
                .map(MemberMission::getMission)
                .toList();

        return new PageImpl<>(missions, PageRequest.of(page,10), memberMissionsPage.getTotalElements());
    }

    @Override
    public Member loadEntity(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }
}
