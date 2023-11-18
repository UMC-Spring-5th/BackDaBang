package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Review;
import umc.BackDaBang.web.dto.Review.ReviewRequestDTO;
import umc.BackDaBang.web.dto.Review.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateReviewDTO request) {
        return Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .build();
    }

    public static ReviewResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review) {
        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createAt(LocalDateTime.now())
                .build();
    }
}
