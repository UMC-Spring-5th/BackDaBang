package umc.BackDaBang.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class SignUpDTO {
        String email;
        String name;
//        Gender gender;
        LocalDate birthday;
        String address;
        String phoneNumber;
//        @ExistTypes
        List<Long> foodTypeList;
    }
}
