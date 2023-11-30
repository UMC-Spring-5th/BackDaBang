package umc.BackDaBang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.BackDaBang.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByName(String name);
}
