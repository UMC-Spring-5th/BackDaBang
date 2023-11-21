package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Review;
import umc.BackDaBang.web.dto.ReviewRequestDTO;
import umc.BackDaBang.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static ReviewResponseDTO.EnrollReviewResultDTO toCreateResultDTO(Review review) {
        return ReviewResponseDTO.EnrollReviewResultDTO.builder()
                .reviewId(review.getId())
                .createAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.EnrollReviewDTO request) {
        return Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .build();
    }
}
