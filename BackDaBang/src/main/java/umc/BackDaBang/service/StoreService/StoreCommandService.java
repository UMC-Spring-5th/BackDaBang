package umc.BackDaBang.service.StoreService;

import umc.BackDaBang.domain.Store;
import umc.BackDaBang.web.dto.StoreRequest.CreateStore;

public interface StoreCommandService {

    public Store createStore(CreateStore request, String regionName);
}
