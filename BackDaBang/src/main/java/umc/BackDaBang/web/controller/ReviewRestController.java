package umc.BackDaBang.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.ReviewConverter;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.service.ReviewService.ReviewCommandService;
import umc.BackDaBang.web.dto.ReviewRequestDTO;
import umc.BackDaBang.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.CreateResultDTO> createReview(@RequestParam Long memberId,
                                                       @RequestBody ReviewRequestDTO.CreateDTO request) {
        Review review = reviewCommandService.createReview(memberId, request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDTO(review));
    }
}
