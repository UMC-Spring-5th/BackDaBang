package umc.BackDaBang.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.BackDaBang.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MissionAlarm extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean isChecked;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Mission mission;
}
