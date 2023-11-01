package umc.BackDaBang.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.BackDaBang.domain.common.BaseEntity;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewAlarm extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isChecked;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn
//    private MemberMisison memberMission;

}
