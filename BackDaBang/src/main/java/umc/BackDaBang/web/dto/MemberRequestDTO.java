package umc.BackDaBang.web.dto;

import lombok.Getter;
import umc.BackDaBang.domain.enums.Gender;
import umc.BackDaBang.domain.enums.SocialType;
import umc.BackDaBang.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDto{
        private String email;

        private SocialType socialType;

        private String name;

        private Gender gender;

        private LocalDate birthday;

        private String address;

        private String phoneNumber;

        @ExistCategories
        List<Long> preferCategory;

    }
}
