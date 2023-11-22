package umc.BackDaBang.service.StoreService;

import umc.BackDaBang.domain.Store;
import umc.BackDaBang.domain.common.EntityLoader;
import umc.BackDaBang.web.dto.Store.StoreRequestDTO;

public interface StoreService extends EntityLoader<Store,Long> {
    Store enroll(StoreRequestDTO.EnrollDTO request);
    Store enrollRegion(StoreRequestDTO.EnrollRegionDTO request);

    boolean existsById(Long storeId);

    }
