package umc.BackDaBang.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.BackDaBang.domain.FoodType;
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
    private FoodType foodType;

    public void setMember(Member member){
        if(this.member != null)
            member.getMemberFoodTypeList().remove(this);
        this.member = member;
        member.getMemberFoodTypeList().add(this);
    }

    public void setFoodType(FoodType foodType){
        this.foodType = foodType;
    }
}
