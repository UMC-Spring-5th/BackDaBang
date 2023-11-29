package umc.BackDaBang.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
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


    @Operation(summary = "리뷰를 생성하는 API", description = "특정 가게의 리뷰를 생성하는 API입니다. query String으로 memberId를 주세요.")
    @Parameters({
            @Parameter(name = "memberId", description = "memberId 입니다.")
    })
    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDTO> createReview(@RequestParam Long memberId,
            @RequestBody @Valid ReviewRequestDTO.CreateReviewDTO request) {

        Review review = reviewCommandService.createReview(request, memberId); //memberId 임시

        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResultDTO(review));
    }
}
