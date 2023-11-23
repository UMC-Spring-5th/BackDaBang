package umc.BackDaBang.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.MemberHandler;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.repository.MemberRepository;
import umc.BackDaBang.service.ReviewService.ReviewQueryService;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final ReviewQueryService reviewQueryService;
    private final MemberRepository memberRepository;

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {

        Member member = loadEntity(memberId);
        return reviewQueryService.findMemberReviews(member, page);

    }

    @Override
    public Member loadEntity(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }
}
