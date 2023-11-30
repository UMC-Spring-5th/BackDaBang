package umc.BackDaBang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.BackDaBang.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
    
}
