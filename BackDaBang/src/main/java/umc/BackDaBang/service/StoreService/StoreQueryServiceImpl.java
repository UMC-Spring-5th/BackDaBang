package umc.BackDaBang.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.StoreHandler;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.repository.StoreRepository;
import umc.BackDaBang.service.MissionService.MissionQueryService;
import umc.BackDaBang.service.ReviewService.ReviewQueryService;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService {
    private final ReviewQueryService reviewQueryService;
    private final MissionQueryService missionQueryService;
    private final StoreRepository storeRepository;
    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = loadEntity(storeId);

        Page<Review> storePage = reviewQueryService.findStoreReviews(store, page);
        return storePage;
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        Store store = loadEntity(storeId);

        Page<Mission> storePage = missionQueryService.findStoreMissions(store, page);
        return storePage;
    }

    @Override
    public Store loadEntity(Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
    }
}
