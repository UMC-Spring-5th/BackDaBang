package umc.BackDaBang.web.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class CreateDTO {
        Long storeId;
        String title;
        String content;
        Long point;
        LocalDateTime deadline;
        String authorizationCode;
    }
}
