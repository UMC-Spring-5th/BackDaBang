package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Store;
import umc.BackDaBang.web.dto.StoreRequestDTO;
import umc.BackDaBang.web.dto.StoreResponseDTO;

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
}
