package umc.BackDaBang.web.dto;

import lombok.Getter;
import umc.BackDaBang.domain.enums.Gender;

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
        List<Long> foodTypeList;
    }
}
