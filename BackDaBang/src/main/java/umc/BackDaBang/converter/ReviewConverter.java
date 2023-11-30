package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.web.dto.Review.ReviewRequest;

public class ReviewConverter {
    public static Review toReview(ReviewRequest.CreateReview request, Member member, Store store) {
        return Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .member(member)
                .store(store)
                .build();
    }
}
