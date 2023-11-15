package umc.BackDaBang.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import umc.BackDaBang.domain.enums.Gender;
import umc.BackDaBang.validation.annotation.ExistTypes;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class SignUpDTO {
        String email;
        String name;
        Gender gender;
        LocalDate birthday;
        String address;
        String phoneNumber;
        @ExistTypes
        List<Long> foodTypeList;
    }
}
