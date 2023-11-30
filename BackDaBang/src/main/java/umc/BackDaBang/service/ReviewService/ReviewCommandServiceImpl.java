package umc.BackDaBang.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.BackDaBang.converter.ReviewConverter;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.repository.MemberRepository;
import umc.BackDaBang.repository.ReviewRepository;
import umc.BackDaBang.repository.StoreRepository;
import umc.BackDaBang.web.dto.Review.ReviewRequest.CreateReview;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public Long createReview(CreateReview request, String memberName, String storeName) {
        Review review = ReviewConverter.toReview(request, memberRepository.findByName(memberName),
                storeRepository.findByName(storeName));
        reviewRepository.save(review);

        return review.getId();
    }
}
