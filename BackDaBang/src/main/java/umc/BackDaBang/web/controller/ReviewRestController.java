package umc.BackDaBang.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.service.ReviewService.ReviewCommandService;
import umc.BackDaBang.web.dto.Review.ReviewRequest.CreateReview;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping
    public ApiResponse<Long> createReviewAPI(@RequestBody CreateReview request, @RequestParam String memberName,
                                             @RequestParam String storeName) {

        return ApiResponse.onSuccess(reviewCommandService.createReview(request, memberName, storeName));
    }
}
