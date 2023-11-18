package umc.BackDaBang.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.ReviewConverter;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.service.ReviewService.ReviewService;
import umc.BackDaBang.web.dto.Review.ReviewRequestDTO;
import umc.BackDaBang.web.dto.Review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewService reviewService;


    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> createReview(
            @RequestBody @Valid ReviewRequestDTO.CreateReviewDTO request) {

        Review review = reviewService.createReview(request);

        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDTO(review));
    }
}
