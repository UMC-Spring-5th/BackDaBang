package umc.BackDaBang.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.BackDaBang.converter.MissionConverter;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.repository.MissionRepository;
import umc.BackDaBang.repository.StoreRepository;
import umc.BackDaBang.web.dto.Mission.MissionRequest.CreateMission;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Long createMission(String storeName, CreateMission request) {
        Mission mission = MissionConverter.toMission(storeRepository.findByName(storeName), request);
        missionRepository.save(mission);
        return mission.getId();
    }
}
