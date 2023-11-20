package umc.BackDaBang.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.StoreHandler;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.repository.StoreRepository;
import umc.BackDaBang.service.ReviewService.ReviewQueryService;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final ReviewQueryService reviewQueryService;

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = loadEntity(storeId);

        return reviewQueryService.findStoreReviews(store, page);
    }

    @Override
    public Store loadEntity(Long storeId) {
        Optional<Store> store = storeRepository.findById(storeId);
        if(store.isEmpty()) throw new StoreHandler(ErrorStatus.STORE_NOT_FOUDN);
        return store.get();
    }
}
