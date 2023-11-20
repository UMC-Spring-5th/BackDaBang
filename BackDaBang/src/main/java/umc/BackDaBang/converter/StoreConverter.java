package umc.BackDaBang.converter;

import org.springframework.data.domain.Page;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.web.dto.StoreRequestDTO;
import umc.BackDaBang.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.EnrollDTO request) {
        return Store.builder()
                .name(request.getName())
                .type(request.getType())
                .address(request.getAddress())
                .build();
    }

    public static StoreResponseDTO.EnrollResultDTO toEnrollResultDTO(Store store) {
        return StoreResponseDTO.EnrollResultDTO.builder()
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
}
