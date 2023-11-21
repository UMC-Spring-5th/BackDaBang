package umc.BackDaBang.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.ReviewHandler;
import umc.BackDaBang.converter.ReviewConverter;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.repository.ReviewRepository;
import umc.BackDaBang.service.MemberService.MemberCommandService;
import umc.BackDaBang.service.StoreService.StoreCommandService;
import umc.BackDaBang.web.dto.ReviewRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberCommandService memberCommandService;
    private final StoreCommandService storeCommandService;


    @Override
    @Transactional
    public Review enrollReview(Long memberId, Long storeId, ReviewRequestDTO.EnrollDTO request) {
        Review newReview = ReviewConverter.toReview(request);
        Member member = memberCommandService.loadEntity(memberId);
        Store store = storeCommandService.loadEntity(storeId);
        newReview.setReview(member, store);

        return reviewRepository.save(newReview);
    }

    @Override
    public Review loadEntity(Long reviewId ) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if(review.isEmpty()) throw new ReviewHandler(ErrorStatus.REVIEW_NOT_FOUND);
        return review.get();
    }
}
