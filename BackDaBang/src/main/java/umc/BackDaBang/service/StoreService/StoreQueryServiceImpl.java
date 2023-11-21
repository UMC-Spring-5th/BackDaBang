package umc.BackDaBang.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.StoreHandler;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.repository.StoreRepository;
import umc.BackDaBang.service.MemberService.MemberQueryService;
import umc.BackDaBang.service.MissionService.MissionQueryService;
import umc.BackDaBang.service.ReviewService.ReviewQueryService;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final MemberQueryService memberQueryService;
    private final ReviewQueryService reviewQueryService;
    private final MissionQueryService missionQueryService;

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = loadEntity(storeId);

        return reviewQueryService.findStoreReviews(store, page);
    }

    @Override
    public Page<Review> getReviewListByMember(Long storeId, Long memberId, Integer page) {
        Store store = loadEntity(storeId);
        Member member = memberQueryService.loadEntity(memberId);

        return reviewQueryService.findStoreReviewsByMember(store, member, page);
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        Store store = loadEntity(storeId);

        return missionQueryService.findStoreMissions(store, page);
    }

    @Override
    public Store loadEntity(Long storeId) {
        Optional<Store> store = storeRepository.findById(storeId);
        if(store.isEmpty()) throw new StoreHandler(ErrorStatus.STORE_NOT_FOUDN);
        return store.get();
    }
}
