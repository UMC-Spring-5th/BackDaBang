package umc.BackDaBang.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberFoodType extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private MemberFoodType memberFoodType;
}
