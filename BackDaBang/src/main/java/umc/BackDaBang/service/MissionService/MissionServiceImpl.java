package umc.BackDaBang.service.MissionService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.converter.MissionConverter;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.repository.MissionRepository;
import umc.BackDaBang.service.StoreService.StoreService;
import umc.BackDaBang.web.dto.Mission.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionServiceImpl implements MissionService{

    private final MissionRepository missionRepository;
    private final StoreService storeService;

    @Override
    @Transactional
    public Mission createMission(MissionRequestDTO.CreateMissionDTO request) {

        Store store =  storeService.findStoreById(request.getStoreId());

        Mission newMission = MissionConverter.toMission(request);
        newMission.setMission(store);

        return missionRepository.save(newMission);
    }
}