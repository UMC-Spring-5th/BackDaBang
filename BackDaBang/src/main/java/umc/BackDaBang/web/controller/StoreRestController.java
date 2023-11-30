package umc.BackDaBang.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.service.StoreService.StoreCommandService;
import umc.BackDaBang.service.StoreService.StoreQueryService;
import umc.BackDaBang.web.dto.Store.StoreRequest;
import umc.BackDaBang.web.dto.Store.StoreResponse.GetStore;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

    @PostMapping
    public ApiResponse<Long> createStoreAPI(@RequestBody StoreRequest.CreateStore request,
                                            @RequestParam String regionName) {

        return ApiResponse.onSuccess(storeCommandService.createStore(request, regionName));
    }

    // StoreId를 통해 엔티티를 가져오는 메소드
    @GetMapping
    public ApiResponse<GetStore> findStoreAPI(@RequestParam Long storeId) {

        return ApiResponse.onSuccess(storeQueryService.getStoreById(storeId));
    }

}
