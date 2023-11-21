package umc.BackDaBang.service.ReviewService;

import umc.BackDaBang.domain.Review;
import umc.BackDaBang.web.dto.Review.ReviewRequestDTO;

public interface ReviewService {
    Review createReview(ReviewRequestDTO.CreateReviewDTO request,Long memberId);
}
