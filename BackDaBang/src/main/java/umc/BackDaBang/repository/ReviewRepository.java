package umc.BackDaBang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.BackDaBang.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
