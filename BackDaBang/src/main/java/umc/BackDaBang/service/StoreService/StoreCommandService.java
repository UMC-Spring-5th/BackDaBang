package umc.BackDaBang.service.StoreService;

import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Store enrollStore(StoreRequestDTO.EnrollDTO request);

    Store updateRegion(StoreRequestDTO.UpdateRegionDTO request);
}
