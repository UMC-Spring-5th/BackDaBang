package umc.BackDaBang.service.StoreService;

import umc.BackDaBang.web.dto.Store.StoreResponse.GetStore;

public interface StoreQueryService {
    public GetStore getStoreById(Long storeId);
}
