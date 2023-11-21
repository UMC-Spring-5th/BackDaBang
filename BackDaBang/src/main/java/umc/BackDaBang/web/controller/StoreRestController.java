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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.StoreConverter;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.service.StoreService.StoreCommandService;
import umc.BackDaBang.service.StoreService.StoreQueryService;
import umc.BackDaBang.web.dto.StoreRequestDTO;
import umc.BackDaBang.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

    @PostMapping("/")
    @Operation(summary = "가게 등록 API", description = "새로운 가게를 등록하는 API입니다.")
    public ApiResponse<StoreResponseDTO.EnrollStoreResultDTO> enrollStore(@RequestBody @Valid StoreRequestDTO.EnrollStoreDTO request) {
        Store store = storeCommandService.enrollStore(request);
        return ApiResponse.onSuccess(StoreConverter.toEnrollDTO(store));
    }

    @PostMapping("/{storeId}/regions/{regionId}")
    @Operation(summary = "특정 가게의 지역 설정 API", description = "특정 가게에 지역을 설정하는 API입니다.")
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다."),
            @Parameter(name = "regionId", description = "지역의 아이디, path variable 입니다.")
    })
    public ApiResponse<StoreResponseDTO.UpdateRegionResultDTO> updateRegion(@PathVariable(name = "storeId") Long storeId,
                                                                            @PathVariable(name = "regionId") Long regionId) {
        Store store = storeCommandService.updateRegion(storeId, regionId);
        return ApiResponse.onSuccess(StoreConverter.toUpdateRegionDTO(store));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다."),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),

    })
    public ApiResponse<StoreResponseDTO.StoreReviewListResultDTO> getStoreReviews(@PathVariable(name = "storeId") Long storeId,
                                                                                  @RequestParam(name = "page") Integer page) {
        Page<Review> reviewList = storeQueryService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(StoreConverter.toStoreReviewListDTO(reviewList));
    }

    @GetMapping("/{storeId}/reviews/member")
    @Operation(summary = "특정 가게의 특정 멤버 리뷰 목록 조회 API", description = "특정 가게의 리뷰들 중 특정 멤버의 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),

    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다."),
            @Parameter(name = "memberId", description = "멤버의 아이디, request parameter 입니다."),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),

    })
    public ApiResponse<StoreResponseDTO.StoreReviewListResultDTO> getStoreReviewsByMember(@PathVariable(name = "storeId") Long storeId,
                                                                                          @RequestParam(name = "memberId") Long memberId,
                                                                                          @RequestParam(name = "page") Integer page) {
        Page<Review> reviewList = storeQueryService.getReviewListByMember(storeId, memberId, page);
        return ApiResponse.onSuccess(StoreConverter.toStoreReviewListDTO(reviewList));
    }

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API ", description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다."),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<StoreResponseDTO.StoreMissionListResultDTO> getMissionListDTOApiResponse(@PathVariable(name = "storeId") Long storeId,
                                                                                                @RequestParam(name = "page") Integer page) {
        Page<Mission> missionList = storeQueryService.getMissionList(storeId, page);
        return ApiResponse.onSuccess(StoreConverter.toStoreMissionListDTO(missionList));
    }
}
