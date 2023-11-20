package umc.BackDaBang.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean isSuccess;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Mission mission;

    public void setMember(Member member) {
        this.member = member;
        member.getMemberMissionList().add(this);
    }

    public Boolean complete() {
        if(this.isSuccess) return Boolean.FALSE;
        this.isSuccess = Boolean.TRUE;
        return Boolean.TRUE;
    }

    public Boolean equals(MemberMission memberMission) {
        if(memberMission.mission.equals(this.mission))
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
}
