package umc.BackDaBang.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.BackDaBang.converter.StoreConverter;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.repository.RegionRepository;
import umc.BackDaBang.repository.StoreRepository;
import umc.BackDaBang.web.dto.Store.StoreRequest.CreateStore;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;

    private final RegionRepository regionRepository;


    @Override
    public Long createStore(CreateStore request, String regionName) {
        Store store = StoreConverter.toStore(request, regionRepository.findByName(regionName));
        storeRepository.save(store);
        return store.getId();
    }
}
