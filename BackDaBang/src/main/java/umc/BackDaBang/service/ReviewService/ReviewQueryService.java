package umc.BackDaBang.service.ReviewService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;

public interface ReviewQueryService {
    Page<Review> findStoreReviews(Store store, Integer page);
}
