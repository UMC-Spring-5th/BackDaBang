package umc.BackDaBang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.BackDaBang.domain.Region;

public interface RegionRepository extends JpaRepository<Region,Long> {
}
