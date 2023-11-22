package umc.BackDaBang.converter;


import org.springframework.data.domain.Page;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.web.dto.Store.StoreRequestDTO;
import umc.BackDaBang.web.dto.Store.StoreResponseDTO;

import java.time.LocalDateTime;
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
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static StoreResponseDTO.EnrollRegionResultDTO toEnrollRegionResultDTO(Store store) {
        return StoreResponseDTO.EnrollRegionResultDTO.builder()
                .storeId(store.getId())
                .regionId(store.getRegion().getId())
                .build();
    }

    public static StoreResponseDTO.StoreReviewPreViewDTO toStoreReviewPreViewDTO(Review review){
        return StoreResponseDTO.StoreReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt())
                .content(review.getContent())
                .build();
    }
    public static StoreResponseDTO.StoreReviewPreViewListDTO toStoreReviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.StoreReviewPreViewDTO> storeReviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::toStoreReviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.StoreReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(storeReviewPreViewDTOList.size())
                .reviewList(storeReviewPreViewDTOList)
                .build();
    }
}
