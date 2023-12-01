package umc.BackDaBang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.BackDaBang.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {

//    Mission findByTitle(String title);
    
//    Mission findByTitle
}
