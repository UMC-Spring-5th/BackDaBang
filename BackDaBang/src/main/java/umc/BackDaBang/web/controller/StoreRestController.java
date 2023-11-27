package umc.BackDaBang.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.StoreConverter;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.service.StoreService.StoreCommandService;
import umc.BackDaBang.service.StoreService.StoreQueryService;
import umc.BackDaBang.validation.annotation.CheckPage;
import umc.BackDaBang.validation.annotation.ExistStore;
import umc.BackDaBang.web.dto.Store.StoreRequestDTO;
import umc.BackDaBang.web.dto.Store.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;
    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.EnrollResultDTO> enroll(@RequestBody @Valid
                                                                StoreRequestDTO.EnrollDTO request) {
        Store store = storeCommandService.enroll(request);

        return ApiResponse.onSuccess(StoreConverter.toEnrollResultDTO(store));
    }
    @PostMapping("/region")
    public ApiResponse<StoreResponseDTO.EnrollRegionResultDTO> enrollRegion(@RequestBody @Valid
                                                                      StoreRequestDTO.EnrollRegionDTO request) {
        Store store = storeCommandService.enrollRegion(request);
        return ApiResponse.onSuccess(StoreConverter.toEnrollRegionResultDTO(store));
    }

    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/{storeId}/reviews")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<StoreResponseDTO.StoreReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                                 @CheckPage @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = storeQueryService.getReviewList(storeId,page);
        return ApiResponse.onSuccess(StoreConverter.toStoreReviewPreViewListDTO(reviewList));
    }


    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query string으로 page 번호를 주세요.")
    @GetMapping("/{storeId}/missions")
    @Parameters({
            @Parameter(name="storeId", description = "가게의 아이디, path variable 입니다."),
            @Parameter(name="page", description = "페이지 번호, 0번이 1페이지입니다.")
    })
    public ApiResponse<StoreResponseDTO.StoreMissionListDTO> getMissionList(@ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                            @CheckPage @RequestParam(name="page") Integer page) {

        Page<Mission> missionList = storeQueryService.getMissionList(storeId,page);

        return ApiResponse.onSuccess(StoreConverter.toStoreMissionListDTO(missionList));

    }
}
