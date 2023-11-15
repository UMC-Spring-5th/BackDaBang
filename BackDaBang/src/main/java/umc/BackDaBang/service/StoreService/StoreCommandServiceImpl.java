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
import umc.BackDaBang.repository.RegionRepository;
import umc.BackDaBang.repository.StoreRepository;
import umc.BackDaBang.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store enrollStore(StoreRequestDTO.EnrollDTO request) {
        Store newStore = StoreConverter.toStore(request);

        return storeRepository.save(newStore);
    }

    @Override
    @Transactional
    public Store updateRegion(StoreRequestDTO.UpdateRegionDTO request) {
        Store updateStore = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUDN));
        Region region = regionRepository.findById(request.getRegionId()).orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        System.out.println(region.getName());
        updateStore.setRegion(region);
        return updateStore;
    }
}
