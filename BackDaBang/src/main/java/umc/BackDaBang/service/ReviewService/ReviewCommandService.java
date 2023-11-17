package umc.BackDaBang.service.ReviewService;

import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.common.EntityLoader;
import umc.BackDaBang.web.dto.ReviewRequestDTO;


public interface ReviewCommandService extends EntityLoader<Review, Long> {

    Review createReview(Long memberId, ReviewRequestDTO.CreateDTO request);
}
