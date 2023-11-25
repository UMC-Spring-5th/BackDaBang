package umc.BackDaBang.service.MemberService;

import org.springframework.data.domain.Page;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.common.EntityLoader;

public interface MemberQueryService extends EntityLoader<Member,Long> {
    Page<Review> getReviewList(Long memberId, Integer page);
    Page<Mission> getMissionList(Long memberId, Integer page);
}
