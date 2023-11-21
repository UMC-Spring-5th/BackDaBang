package umc.BackDaBang.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    @Override
    public Page<Review> findStoreReviews(Store store, Integer page) {
        return reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
    }

    @Override
    public Page<Review> findStoreReviewsByMember(Store store, Member member, Integer page) {
        return reviewRepository.findAllByStoreAndMember(store, member, PageRequest.of(page, 10));
    }
}
