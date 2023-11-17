package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Review;
import umc.BackDaBang.web.dto.ReviewRequestDTO;
import umc.BackDaBang.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static ReviewResponseDTO.CreateResultDTO toCreateResultDTO(Review review) {
        return ReviewResponseDTO.CreateResultDTO.builder()
                .reviewId(review.getId())
                .createAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.CreateDTO request) {
        return Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .build();
    }
}
