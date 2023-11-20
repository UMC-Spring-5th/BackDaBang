package umc.BackDaBang.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.converter.ReviewConverter;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.repository.ReviewRepository;
import umc.BackDaBang.service.MemberService.MemberCommandService;
import umc.BackDaBang.service.StoreService.StoreService;
import umc.BackDaBang.web.dto.Review.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final MemberCommandService memberCommandService;
    private final StoreService storeService;
    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.CreateReviewDTO request) {
        Member member = memberCommandService.findMemberById(1L); //멤버 지정
        Store store =  storeService.findStoreById(request.getStoreId());

        Review newReview = ReviewConverter.toReview(request);
        newReview.setReview(member,store);

        return reviewRepository.save(newReview);
    }
}