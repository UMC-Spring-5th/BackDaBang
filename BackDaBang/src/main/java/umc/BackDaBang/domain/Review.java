package umc.BackDaBang.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.BackDaBang.domain.common.BaseEntity;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Store store;

    public void setReview(Member writer, Store store) {
        this.member = writer;
        this.store = store;
        store.getReviews().add(this);
        store.updateRating();
    }
}
