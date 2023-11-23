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
import umc.BackDaBang.service.MemberService.MemberQueryService;
import umc.BackDaBang.service.StoreService.StoreCommandService;
import umc.BackDaBang.service.StoreService.StoreQueryService;
import umc.BackDaBang.web.dto.Review.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final MemberQueryService memberQueryService;
    private final StoreQueryService storeQueryService;
    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.CreateReviewDTO request, Long memberId) {
        Member member = memberQueryService.loadEntity(memberId); //멤버 지정
        Store store =  storeQueryService.loadEntity(request.getStoreId());

        Review newReview = ReviewConverter.toReview(request);
        newReview.setReview(member,store);

        return reviewRepository.save(newReview);
    }



}
