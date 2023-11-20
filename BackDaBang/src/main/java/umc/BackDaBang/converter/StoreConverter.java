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

    public static StoreResponseDTO.EnrollDTO toEnrollDTO(Store store) {
        return StoreResponseDTO.EnrollDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static StoreResponseDTO.UpdateRegionDTO toUpdateRegionDTO(Store store) {
        return StoreResponseDTO.UpdateRegionDTO.builder()
                .storeId(store.getId())
                .regionName(store.getRegion().getName())
                .build();
    }

    private static StoreResponseDTO.StoreReviewDTO toStoreReviewDTO(Review review) {
        return StoreResponseDTO.StoreReviewDTO.builder()
                .nickname(review.getMember().getName())
                .rating(review.getRating())
                .content(review.getContent())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static StoreResponseDTO.StoreReviewListDTO toStoreReviewListDTO(Page<Review> reviews) {
        List<StoreResponseDTO.StoreReviewDTO> reviewDTOList = reviews.stream()
                .map(StoreConverter::toStoreReviewDTO)
                .toList();

        return StoreResponseDTO.StoreReviewListDTO.builder()
                .isFirst(reviews.isLast())
                .isLast(reviews.isLast())
                .totalPage(reviews.getTotalPages())
                .totalElements(reviews.getTotalElements())
                .listSize(reviewDTOList.size())
                .reviewList(reviewDTOList)
                .build();
    }

    private static StoreResponseDTO.StoreMissionDTO toStoreMissionDTO(Mission mission) {
        return StoreResponseDTO.StoreMissionDTO.builder()
                .missionId(mission.getId())
                .title(mission.getTitle())
                .content(mission.getContent())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static StoreResponseDTO.StoreMissionListDTO toStoreMissionListDTO(Page<Mission> missions) {
        List<StoreResponseDTO.StoreMissionDTO> missionDTOList = missions.stream()
                .map(StoreConverter::toStoreMissionDTO)
                .toList();

        return StoreResponseDTO.StoreMissionListDTO.builder()
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .totalElements(missions.getTotalElements())
                .listSize(missionDTOList.size())
                .missionList(missionDTOList)
                .build();
    }
}
