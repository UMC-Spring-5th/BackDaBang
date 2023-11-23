package umc.BackDaBang.service.StoreService;

import org.springframework.data.domain.Page;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.domain.common.EntityLoader;
import umc.BackDaBang.web.dto.Store.StoreRequestDTO;

public interface StoreCommandService  {
    Store enroll(StoreRequestDTO.EnrollDTO request);
    Store enrollRegion(StoreRequestDTO.EnrollRegionDTO request);
    boolean existsById(Long storeId);

    }
