package umc.BackDaBang.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
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
    @Operation(summary = "가게 리뷰 등록 API", description = "특정 가게에 리뷰를 등록하는 API 입니다.")
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, request parameter 입니다."),
            @Parameter(name = "storeId", description = "가게의 아이디, request parameter 입니다.")
    })
    public ApiResponse<ReviewResponseDTO.EnrollReviewResultDTO> createReview(@RequestParam Long memberId,
                                                                             @RequestParam Long storeId,
                                                                             @RequestBody @Valid ReviewRequestDTO.EnrollReviewDTO request) {
        Review review = reviewCommandService.enrollReview(memberId, storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDTO(review));
    }
}
