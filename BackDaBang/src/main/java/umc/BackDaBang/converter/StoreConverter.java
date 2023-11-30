package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Region;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.web.dto.StoreRequest;
import umc.BackDaBang.web.dto.StoreResponse.GetStore;

public class StoreConverter {
    public static Store toStore(StoreRequest.CreateStore request, Region region) {
        return Store.builder()
                .name(request.getName())
                .type(request.getType())
                .address(request.getAddress())
                .region(region)
                .build();
    }

    public static GetStore toGetStore(Store store) {
        return GetStore.builder()
                .name(store.getName())
                .address(store.getAddress())
                .build();
    }
}
