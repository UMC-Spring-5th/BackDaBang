package umc.BackDaBang.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Store;

public interface MissionRepository extends JpaRepository<Mission,Long> {
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
