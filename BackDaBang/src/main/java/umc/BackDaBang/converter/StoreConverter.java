package umc.BackDaBang.converter;


import umc.BackDaBang.domain.Store;
import umc.BackDaBang.web.dto.Store.StoreRequestDTO;
import umc.BackDaBang.web.dto.Store.StoreResponseDTO;

import java.time.LocalDateTime;

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
}
