package umc.BackDaBang.web.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import umc.BackDaBang.validation.annotation.InvalidPoint;

import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class EnrollMissionDTO {
        @NotBlank(message = "미션 제목은 필수 입력값 입니다.")
        String title;
        String content;
        @Positive(message = "미션 포인트는 양수값 이어야 합니다.")
        @InvalidPoint
        Long point;
        @FutureOrPresent(message = "미션 종료 날짜에 과거를 입력할 수 없습니다.")
        LocalDateTime deadline;
    }
}
