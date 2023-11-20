package umc.BackDaBang.service.StoreService;

import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.domain.common.EntityLoader;
import umc.BackDaBang.web.dto.StoreRequestDTO;

public interface StoreCommandService extends EntityLoader<Store, Long> {

    Store enrollStore(StoreRequestDTO.EnrollDTO request);

    Store updateRegion(Long storeId, Long regionId);
}
