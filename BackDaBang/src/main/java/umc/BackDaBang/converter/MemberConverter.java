package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.enums.SocialType;
import umc.BackDaBang.domain.mapping.MemberMission;
import umc.BackDaBang.web.dto.MemberRequestDTO;
import umc.BackDaBang.web.dto.MemberResponseDTO;

import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.SignUpResultDTO toSignUpDTO(Member member) {
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

    public static MemberResponseDTO.MissionIdResultDTO toMissionIdDTO(MemberMission memberMission) {
        return MemberResponseDTO.MissionIdResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }

    public static MemberResponseDTO.MyPageResultDTO toMyPageDTO(Member member) {
        return MemberResponseDTO.MyPageResultDTO.builder()
                .name(member.getName())
                .email(member.getEmail())
                .phoneNumber(member.getPhoneNumber())
                .point(member.getPoint())
                .build();
    }
}
