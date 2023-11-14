package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.enums.Gender;
import umc.BackDaBang.web.dto.MemberRequestDTO;
import umc.BackDaBang.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {
        Gender gender =null;


        return Member.builder()
                .address(request.getAddress())
                .email(request.getEmail())
                .gender(request.getGender())
                .name(request.getName())
                .socialType(request.getSocialType())
                .birthday(request.getBirthday())
                .memberFoodTypeList(new ArrayList<>())
                .build();
    }
}
