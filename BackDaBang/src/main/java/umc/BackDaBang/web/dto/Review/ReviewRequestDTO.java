package umc.BackDaBang.web.dto.Review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.BackDaBang.validation.annotation.ExistStore;

public class ReviewRequestDTO {

    @Getter
    public static class CreateReviewDTO {

        @NotBlank
        String content;

        @NotNull
        Double rating;

        @ExistStore
        Long storeId;
    }
}
