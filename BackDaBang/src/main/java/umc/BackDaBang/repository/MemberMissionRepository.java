package umc.BackDaBang.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Page<MemberMission> findByMemberAndIsSuccessIsFalse(Member member, PageRequest pageRequest);
}
