package umc.BackDaBang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.BackDaBang.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findMemberByEmail(String email);
}
