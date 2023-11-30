package umc.BackDaBang.web.dto.Review;

import lombok.Getter;

public class ReviewRequest {

    @Getter
    public static class CreateReview {
        String content;
        Double rating;
    }
}
