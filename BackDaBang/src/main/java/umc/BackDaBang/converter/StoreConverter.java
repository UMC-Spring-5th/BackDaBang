package umc.BackDaBang.converter;

import org.springframework.data.domain.Page;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.web.dto.StoreRequestDTO;
import umc.BackDaBang.web.dto.StoreResponseDTO;

import java.util.List;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.EnrollDTO request) {
        return Store.builder()
                .name(request.getName())
                .type(request.getType())
                .address(request.getAddress())
                .build();
    }

    public static StoreResponseDTO.EnrollDTO toEnrollResultDTO(Store store) {
        return StoreResponseDTO.EnrollDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static StoreResponseDTO.UpdateRegionResultDTO toUpdateRegionResultDTO(Store store) {
        return StoreResponseDTO.UpdateRegionResultDTO.builder()
                .storeId(store.getId())
                .regionName(store.getRegion().getName())
                .build();
    }

    public static StoreResponseDTO.GetReviewDTO toGetReviewDTO(Review review) {
        return StoreResponseDTO.GetReviewDTO.builder()
                .nickname(review.getMember().getName())
                .rating(review.getRating())
                .content(review.getContent())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static StoreResponseDTO.GetReviewListDTO toGetReviewListDTO(Page<Review> reviews) {
        List<StoreResponseDTO.GetReviewDTO> reviewDTOList = reviews.stream()
                .map(StoreConverter::toGetReviewDTO)
                .toList();

        return StoreResponseDTO.GetReviewListDTO.builder()
                .isLast(reviews.isLast())
                .isFirst(reviews.isLast())
                .totalPage(reviews.getTotalPages())
                .totalElements(reviews.getTotalElements())
                .listSize(reviewDTOList.size())
                .reviewList(reviewDTOList)
                .build();
    }

    public static StoreResponseDTO.GetMissionDTO toGetMissionDTO(Mission mission) {
        return StoreResponseDTO.GetMissionDTO.builder()
                .missionId(mission.getId())
                .title(mission.getTitle())
                .content(mission.getContent())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static StoreResponseDTO.GetMissionListDTO toGetMissionListDTO(Page<Mission> missions) {
        List<StoreResponseDTO.GetMissionDTO> missionDTOList = missions.stream()
                .map(StoreConverter::toGetMissionDTO)
                .toList();

        return StoreResponseDTO.GetMissionListDTO.builder()
                .isFirst(missions.isLast())
                .isFirst(missions.isFirst())
                .totalElements(missions.getTotalElements())
                .listSize(missionDTOList.size())
                .missionList(missionDTOList)
                .build();
    }
}
