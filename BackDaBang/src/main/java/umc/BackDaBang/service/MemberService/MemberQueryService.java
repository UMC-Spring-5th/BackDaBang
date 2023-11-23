package umc.BackDaBang.service.MemberService;

import org.springframework.data.domain.Page;
import umc.BackDaBang.domain.Review;

public interface MemberQueryService {
    Page<Review> getReviewList(Long memberId, Integer page);
}
