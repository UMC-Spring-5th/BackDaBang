package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.enums.SocialType;
import umc.BackDaBang.web.dto.MemberRequestDTO;
import umc.BackDaBang.web.dto.MemberResponseDTO;

import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.SignUpResultDTO toSignUpResultDTO(Member member) {
        return MemberResponseDTO.SignUpResultDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    public static Member toMember(MemberRequestDTO.SignUpDTO request) {
        return Member.builder()
                .email(request.getEmail())
                .name(request.getName())
                .socialType(SocialType.NONE)
                .gender(request.getGender())
                .birthday(request.getBirthday())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .memberFoodTypeList(new ArrayList<>())
                .build();
    }
}