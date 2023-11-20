package umc.BackDaBang.service.StoreService;

import org.springframework.data.domain.Page;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.domain.common.EntityLoader;

import java.util.Optional;

public interface StoreQueryService extends EntityLoader<Store, Long> {
    Page<Review> getReviewList(Long storeId, Integer page);
    Page<Review> getReviewListByMember(Long storeId, Long memberId, Integer page);

    Page<Mission> getMissionList(Long storeId, Integer page);
}
