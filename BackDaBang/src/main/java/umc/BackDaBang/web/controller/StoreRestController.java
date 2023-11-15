package umc.BackDaBang.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.StoreConverter;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.service.StoreService.StoreCommandService;
import umc.BackDaBang.web.dto.StoreRequestDTO;
import umc.BackDaBang.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.EnrollResultDTO> enrollStore(@RequestBody @Valid StoreRequestDTO.EnrollDTO request) {
        Store store = storeCommandService.enrollStore(request);
        return ApiResponse.onSuccess(StoreConverter.toEnrollResultDTO(store));
    }

    @PostMapping("/region")
    public ApiResponse<StoreResponseDTO.UpdateRegionResultDTO> updateRegion(@RequestBody @Valid StoreRequestDTO.UpdateRegionDTO request) {
        Store store = storeCommandService.updateRegion(request);
        return ApiResponse.onSuccess(StoreConverter.toUpdateRegionResultDTO(store));
    }
}
