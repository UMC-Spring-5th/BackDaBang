package umc.BackDaBang.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class EnrollDTO {
        @NotBlank(message = "리뷰 내용은 필수 입력 값입니다.")
        String content;
        @Max(value = 5L, message = "평점은 5점을 넘을 수 없습니다.")
        @Min(value = 0L, message = "평점은 0점이상 이어야 합니다.")
        Double rating;
    }

}
