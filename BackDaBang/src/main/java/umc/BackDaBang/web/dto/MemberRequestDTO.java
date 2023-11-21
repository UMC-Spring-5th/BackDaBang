package umc.BackDaBang.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import umc.BackDaBang.domain.enums.Gender;
import umc.BackDaBang.validation.annotation.ExistTypes;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class SignUpDTO {
        @Email(message = "이메일 형식에 맞춰서 입력해주십시오.")
        String email;
        @NotBlank(message = "이름은 필수 입력값입니다.")
        String name;
        @NotNull(message = "성별은 필수 선택값입니다.")
        Gender gender;
        @Past(message = "생일은 미래의 날짜를 선택할 수 없습니다.")
        LocalDate birthday;
        String address;
        String phoneNumber;
        @ExistTypes
        List<Long> foodTypeList;
    }
}
