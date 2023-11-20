package umc.BackDaBang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.BackDaBang.domain.FoodType;

import java.util.Optional;

public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {
}
