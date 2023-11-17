package umc.BackDaBang.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class CreateDTO {
        Long storeId;
        String content;
        Double rating;
    }

}
