package umc.BackDaBang.service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.RegionHandler;
import umc.BackDaBang.domain.Region;
import umc.BackDaBang.domain.common.EntityLoader;
import umc.BackDaBang.repository.RegionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionCommandServiceImpl implements RegionCommandService {

    private final RegionRepository regionRepository;

    @Override
    public Region loadEntity(Long regionId) {
        Optional<Region> region = regionRepository.findById(regionId);
        if(region.isEmpty()) throw new RegionHandler(ErrorStatus.REGION_NOT_FOUND);
        return region.get();
    }
}
