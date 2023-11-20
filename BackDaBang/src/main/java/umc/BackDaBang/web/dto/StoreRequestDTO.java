package umc.BackDaBang.web.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

public class StoreRequestDTO {

    @Getter
    public static class EnrollDTO {
        @Length(min = 1, max = 20)
        String name;
        @Length(max = 20)
        String type;
        String address;
    }
}
