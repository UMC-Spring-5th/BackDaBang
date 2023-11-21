package umc.BackDaBang.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.StoreConverter;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.service.StoreService.StoreService;
import umc.BackDaBang.web.dto.Store.StoreRequestDTO;
import umc.BackDaBang.web.dto.Store.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreService storeService;


    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.EnrollResultDTO> enroll(@RequestBody @Valid
                                                                StoreRequestDTO.EnrollDTO request) {
        Store store = storeService.enroll(request);

        return ApiResponse.onSuccess(StoreConverter.toEnrollResultDTO(store));
    }
    @PostMapping("/region")
    public ApiResponse<StoreResponseDTO.EnrollRegionResultDTO> enrollRegion(@RequestBody @Valid
                                                                      StoreRequestDTO.EnrollRegionDTO request) {
        Store store = storeService.enrollRegion(request);
        return ApiResponse.onSuccess(StoreConverter.toEnrollRegionResultDTO(store));
    }
}
