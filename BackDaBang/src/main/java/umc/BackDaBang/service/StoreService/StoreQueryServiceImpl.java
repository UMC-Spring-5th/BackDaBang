package umc.BackDaBang.service.StoreService;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.BackDaBang.converter.StoreConverter;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.repository.StoreRepository;
import umc.BackDaBang.web.dto.Store.StoreResponse.GetStore;

@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;

    @Override
    public GetStore getStoreById(Long storeId) {

        // JPA에서 해주는 findById는 null일 수 있기 때문에 Optional로 변경
        // 그런데 optional일 수 있기때문에 orElseThrow를 붙여서 옵셔널을 벗겨줌
        Optional<Store> store = storeRepository.findById(storeId);
        Store store1 = storeRepository.findById(storeId).orElseThrow();
        // 옵셔널을 벗긴 객체를 사용하면 다시 get해서 필드를 가져올 수 있게 된다.
        return StoreConverter.toGetStore(store1);
    }
}
