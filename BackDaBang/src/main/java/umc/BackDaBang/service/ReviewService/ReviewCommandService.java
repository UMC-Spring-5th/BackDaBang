package umc.BackDaBang.service.ReviewService;

import umc.BackDaBang.web.dto.Review.ReviewRequest.CreateReview;

public interface ReviewCommandService {
    public Long createReview(CreateReview request, String memberName, String storeName);
}
