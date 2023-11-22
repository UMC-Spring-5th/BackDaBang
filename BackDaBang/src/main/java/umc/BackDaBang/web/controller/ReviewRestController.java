package umc.BackDaBang.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.ReviewConverter;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.service.ReviewService.ReviewCommandService;
import umc.BackDaBang.web.dto.Review.ReviewRequestDTO;
import umc.BackDaBang.web.dto.Review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;


    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> createReview(@RequestParam Long memberId,
            @RequestBody @Valid ReviewRequestDTO.CreateReviewDTO request) {

        Review review = reviewCommandService.createReview(request, memberId); //memberId 임시

        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDTO(review));
    }
}
