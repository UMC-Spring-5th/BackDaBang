package umc.BackDaBang.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.MissionHandler;
import umc.BackDaBang.converter.MissionConverter;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.repository.MissionRepository;
import umc.BackDaBang.service.StoreService.StoreCommandService;
import umc.BackDaBang.web.dto.MissionRequestDTO;

import java.util.Optional;

@Service
@RestController
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final StoreCommandService storeCommandService;

    @Override
    @Transactional
    public Mission createMission(MissionRequestDTO.CreateDTO request) {
        Mission newMission = MissionConverter.toMission(request);
        Store store = storeCommandService.loadEntity(request.getStoreId());
        newMission.setMission(store);

        return missionRepository.save(newMission);
    }



    @Override
    public Mission loadEntity(Long missionId) {
        Optional<Mission> mission = missionRepository.findById(missionId);
        if(mission.isEmpty()) throw new MissionHandler(ErrorStatus.MISSION_NOT_FOUND);
        return mission.get();
    }


}
