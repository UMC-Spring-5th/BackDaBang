package umc.BackDaBang.converter;

import org.springframework.data.domain.Page;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.enums.Gender;
import umc.BackDaBang.web.dto.Member.MemberRequestDTO;
import umc.BackDaBang.web.dto.Member.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {


        return Member.builder()
                .address(request.getAddress())
                .email(request.getEmail())
                .gender(request.getGender())
                .name(request.getName())
                .socialType(request.getSocialType())
                .birthday(request.getBirthday())
                .phoneNumber(request.getPhoneNumber())
                .point(0)
                .memberFoodTypeList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.MemberReviewDTO toMemberReviewDTO(Review review) {
        return MemberResponseDTO.MemberReviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .rating(review.getRating())
                .content(review.getContent())
                .storeName(review.getStore().getName())
                .createdAt(review.getCreatedAt())
                .build();
    }
    public static MemberResponseDTO.MemberReviewListDTO toMemberReviewListDTO(Page<Review> reviewList) {

        List<MemberResponseDTO.MemberReviewDTO> memberReviewDTOList = reviewList.stream()
                .map(MemberConverter::toMemberReviewDTO).toList();

        return MemberResponseDTO.MemberReviewListDTO.builder()
                .reviewList(memberReviewDTOList)
                .listSize(memberReviewDTOList.size())
                .isFirst(reviewList.isFirst())
                .isLast(reviewList.isLast())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .build();

    }

    public static MemberResponseDTO.MemberMissionDTO toMemberMissionDTO(Mission mission) {
        return MemberResponseDTO.MemberMissionDTO.builder()
                .title(mission.getTitle())
                .content(mission.getContent())
                .deadline(mission.getDeadline())
                .point(mission.getPoint())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static MemberResponseDTO.MemberMissionListDTO toMemberMissionListDTO(Page<Mission> missionList) {
        List<MemberResponseDTO.MemberMissionDTO> memberMissionDTOList = missionList.stream()
                .map(MemberConverter::toMemberMissionDTO).toList();

        return MemberResponseDTO.MemberMissionListDTO.builder()
                .missionList(memberMissionDTOList)
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .listSize(memberMissionDTOList.size())
                .totalElements(missionList.getTotalElements())
                .totalPage(missionList.getTotalPages())
                .build();
    }
}
