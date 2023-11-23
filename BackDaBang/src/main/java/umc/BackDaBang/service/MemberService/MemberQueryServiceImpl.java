package umc.BackDaBang.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.service.ReviewService.ReviewQueryService;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final ReviewQueryService reviewQueryService;
    private final MemberCommandService memberCommandService;
    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {

        Member member = memberCommandService.loadEntity(memberId);
        return reviewQueryService.findMemberReviews(member, page);

    }

}
