package umc.BackDaBang.service.StoreService;

import umc.BackDaBang.domain.Store;
import umc.BackDaBang.web.dto.Store.StoreRequestDTO;

public interface StoreService {
    Store enroll(StoreRequestDTO.EnrollDTO request);
    Store enrollRegion(StoreRequestDTO.EnrollRegionDTO request);
}
