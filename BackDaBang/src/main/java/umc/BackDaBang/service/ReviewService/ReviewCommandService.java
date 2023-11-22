package umc.BackDaBang.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.web.dto.Review.ReviewRequestDTO;

public interface ReviewCommandService {
    Review createReview(ReviewRequestDTO.CreateReviewDTO request,Long memberId);

}
