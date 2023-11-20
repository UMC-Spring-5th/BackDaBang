package umc.BackDaBang.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.RegionHandler;
import umc.BackDaBang.apiPayload.exception.handler.StoreHandler;
import umc.BackDaBang.converter.StoreConverter;
import umc.BackDaBang.domain.Region;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.domain.common.EntityLoader;
import umc.BackDaBang.repository.RegionRepository;
import umc.BackDaBang.repository.StoreRepository;
import umc.BackDaBang.service.RegionService.RegionCommandService;
import umc.BackDaBang.web.dto.StoreRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionCommandService regionCommandService;

    @Override
    @Transactional
    public Store enrollStore(StoreRequestDTO.EnrollDTO request) {
        Store newStore = StoreConverter.toStore(request);

        return storeRepository.save(newStore);
    }

    @Override
    @Transactional
    public Store updateRegion(StoreRequestDTO.UpdateRegionDTO request) {
        Store updateStore = loadEntity(request.getStoreId());
        Region region = regionCommandService.loadEntity(request.getRegionId());
        updateStore.setRegion(region);
        return updateStore;
    }

    @Override
    public Store loadEntity(Long storeId) {
        Optional<Store> store = storeRepository.findById(storeId);
        if(store.isEmpty()) throw new StoreHandler(ErrorStatus.STORE_NOT_FOUDN);
        return store.get();
    }
}
