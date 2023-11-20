package umc.BackDaBang.web.dto.Mission;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.validation.annotation.ExistStore;

import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class CreateMissionDTO {
        @NotBlank
        String title;

        @NotBlank
        String content;

        @NotNull
        Long point;

        @NotNull
        LocalDateTime deadline;

        @NotBlank
        String authorizationCode;

        @ExistStore
        Long storeId;
    }
}
