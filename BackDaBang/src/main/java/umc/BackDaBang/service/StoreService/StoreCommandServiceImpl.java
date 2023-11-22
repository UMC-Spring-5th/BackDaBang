package umc.BackDaBang.service.StoreService;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.StoreHandler;
import umc.BackDaBang.converter.StoreConverter;
import umc.BackDaBang.domain.Region;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.repository.StoreRepository;
import umc.BackDaBang.service.RegionService.RegionCommandService;
import umc.BackDaBang.service.ReviewService.ReviewQueryServiceImpl;
import umc.BackDaBang.web.dto.Store.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final RegionCommandService regionCommandService;
    private final ReviewQueryServiceImpl reviewQueryService;
    @Override
    @Transactional
    public Store enroll(StoreRequestDTO.EnrollDTO request) {

        Store newStore = StoreConverter.toStore(request);
        return storeRepository.save(newStore);
    }



    @Override
    @Transactional
    public Store enrollRegion(StoreRequestDTO.EnrollRegionDTO request) {
        Store store = loadEntity(request.getStoreId());
        Region region = regionCommandService.loadEntity(request.getRegionId());

        store.setRegion(region);
        return store;
    }

    @Override
    public Store loadEntity(Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {

        Store store = loadEntity(storeId);

        Page<Review> storePage = reviewQueryService.findStoreReviews(store, page);
        return storePage;
    }
    @Override
    public boolean existsById(Long storeId) {
        return storeRepository.existsById(storeId);
    }


}
