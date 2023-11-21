package umc.BackDaBang.converter;

import org.springframework.data.domain.Page;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.web.dto.StoreRequestDTO;
import umc.BackDaBang.web.dto.StoreResponseDTO;

import java.util.List;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.EnrollStoreDTO request) {
        return Store.builder()
                .name(request.getName())
                .type(request.getType())
                .address(request.getAddress())
                .build();
    }

    public static StoreResponseDTO.EnrollStoreResultDTO toEnrollDTO(Store store) {
        return StoreResponseDTO.EnrollStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static StoreResponseDTO.UpdateRegionResultDTO toUpdateRegionDTO(Store store) {
        return StoreResponseDTO.UpdateRegionResultDTO.builder()
                .storeId(store.getId())
                .regionName(store.getRegion().getName())
                .build();
    }

    private static StoreResponseDTO.StoreReviewResultDTO toStoreReviewDTO(Review review) {
        return StoreResponseDTO.StoreReviewResultDTO.builder()
                .nickname(review.getMember().getName())
                .rating(review.getRating())
                .content(review.getContent())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static StoreResponseDTO.StoreReviewListResultDTO toStoreReviewListDTO(Page<Review> reviews) {
        List<StoreResponseDTO.StoreReviewResultDTO> reviewDTOList = reviews.stream()
                .map(StoreConverter::toStoreReviewDTO)
                .toList();

        return StoreResponseDTO.StoreReviewListResultDTO.builder()
                .isFirst(reviews.isLast())
                .isLast(reviews.isLast())
                .totalPage(reviews.getTotalPages())
                .totalElements(reviews.getTotalElements())
                .listSize(reviewDTOList.size())
                .reviewList(reviewDTOList)
                .build();
    }

    private static StoreResponseDTO.StoreMissionResultDTO toStoreMissionDTO(Mission mission) {
        return StoreResponseDTO.StoreMissionResultDTO.builder()
                .missionId(mission.getId())
                .title(mission.getTitle())
                .content(mission.getContent())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static StoreResponseDTO.StoreMissionListResultDTO toStoreMissionListDTO(Page<Mission> missions) {
        List<StoreResponseDTO.StoreMissionResultDTO> missionDTOList = missions.stream()
                .map(StoreConverter::toStoreMissionDTO)
                .toList();

        return StoreResponseDTO.StoreMissionListResultDTO.builder()
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .totalElements(missions.getTotalElements())
                .listSize(missionDTOList.size())
                .missionList(missionDTOList)
                .build();
    }
}
