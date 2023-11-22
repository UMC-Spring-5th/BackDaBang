package umc.BackDaBang.service.MissionService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.MissionHandler;
import umc.BackDaBang.converter.MemberMissionConverter;
import umc.BackDaBang.converter.MissionConverter;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.domain.mapping.MemberMission;
import umc.BackDaBang.repository.MissionRepository;
import umc.BackDaBang.service.MemberService.MemberCommandService;
import umc.BackDaBang.service.StoreService.StoreService;
import umc.BackDaBang.web.dto.Mission.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionServiceImpl implements MissionService{

    private final MissionRepository missionRepository;
    private final StoreService storeService;
    private final MemberCommandService memberCommandService;
    @Override
    @Transactional
    public Mission createMission(MissionRequestDTO.CreateMissionDTO request) {

        Store store =  storeService.loadEntity(request.getStoreId());

        Mission newMission = MissionConverter.toMission(request);
        newMission.setMission(store);

        return missionRepository.save(newMission);
    }

    @Override
    @Transactional
    public MemberMission challengeMission(Long memberId, Long missionId) {
        Member member = memberCommandService.loadEntity(memberId);
        Mission mission = loadEntity(missionId);
        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(mission);

        // 미션 진행 여부 확인
        member.getMemberMissionList()
                .forEach(
                        memberMission -> {
                            if(memberMission.equals(newMemberMission)) throw new MissionHandler(ErrorStatus.MEMBER_MISSION_EXIST);
                        });

        newMemberMission.setMember(member);

        return newMemberMission;
    }
    @Override
    public Mission loadEntity(Long missionId) {
        return missionRepository.findById(missionId).orElseThrow(
                () -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND)
        );
    }
}
