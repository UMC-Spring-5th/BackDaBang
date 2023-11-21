package umc.BackDaBang.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.MissionHandler;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.repository.MissionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public Page<Mission> findStoreMissions(Store store, Integer page) {
        return missionRepository.findAllByStore(store, PageRequest.of(page, 10));
    }

    @Override
    public Mission loadEntity(Long missionId) {
        Optional<Mission> mission = missionRepository.findById(missionId);
        if(mission.isEmpty()) throw new MissionHandler(ErrorStatus.MISSION_NOT_FOUND);
        return mission.get();
    }
}
