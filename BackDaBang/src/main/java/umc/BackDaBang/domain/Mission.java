package umc.BackDaBang.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.BackDaBang.domain.common.BaseEntity;
import umc.BackDaBang.domain.mapping.MemberMission;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long point;

    @Column(nullable = false)
    private LocalDateTime deadline;

    @Column(nullable = false, length = 20)
    private String authorizationCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
