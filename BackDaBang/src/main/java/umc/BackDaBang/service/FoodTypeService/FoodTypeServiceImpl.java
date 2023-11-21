package umc.BackDaBang.service.FoodTypeService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.repository.FoodTypeRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodTypeServiceImpl implements FoodTypeService {
    private final FoodTypeRepository foodTypeRepository;

    @Override
    public boolean existsById(Long id) {
        return foodTypeRepository.existsById(id);
    }
}
