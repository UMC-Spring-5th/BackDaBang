package umc.BackDaBang.service.StoreService;

import umc.BackDaBang.web.dto.Store.StoreRequest.CreateStore;

public interface StoreCommandService {

    public Long createStore(CreateStore request, String regionName);
}
