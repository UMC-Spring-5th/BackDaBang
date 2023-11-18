package umc.BackDaBang.service.StoreService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.StoreHandler;
import umc.BackDaBang.converter.StoreConverter;
import umc.BackDaBang.domain.Region;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.repository.StoreRepository;
import umc.BackDaBang.service.RegionService.RegionService;
import umc.BackDaBang.web.dto.Store.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    private final RegionService regionService;
    @Override
    @Transactional
    public Store enroll(StoreRequestDTO.EnrollDTO request) {

        Store newStore = StoreConverter.toStore(request);
        return storeRepository.save(newStore);
    }



    @Override
    @Transactional
    public Store enrollRegion(StoreRequestDTO.EnrollRegionDTO request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Region region = regionService.findRegionById(request.getRegionId());

        store.setRegion(region);
        return store;
    }

}
