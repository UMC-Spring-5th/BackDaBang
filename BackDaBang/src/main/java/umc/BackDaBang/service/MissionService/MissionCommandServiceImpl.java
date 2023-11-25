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
import umc.BackDaBang.repository.MemberMissionRepository;
import umc.BackDaBang.repository.MissionRepository;
import umc.BackDaBang.service.MemberService.MemberQueryService;
import umc.BackDaBang.service.StoreService.StoreQueryService;
import umc.BackDaBang.web.dto.Mission.MissionRequestDTO;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final StoreQueryService storeQueryService;
    private final MemberQueryService memberQueryService;
    private final MissionQueryService missionQueryService;
    @Override
    public Mission createMission(MissionRequestDTO.CreateMissionDTO request) {

        Store store =  storeQueryService.loadEntity(request.getStoreId());

        Mission newMission = MissionConverter.toMission(request);
        newMission.setMission(store);

        return missionRepository.save(newMission);
    }

    @Override
    public MemberMission challengeMission(Long memberId, Long missionId) {
        Member member = memberQueryService.loadEntity(memberId);
        Mission mission = missionQueryService.loadEntity(missionId);
        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(mission);

        // 미션 진행 여부 확인
        member.getMemberMissionList()
                .forEach(
                        memberMission -> {
                            if(memberMission.getMission().getId().equals(mission.getId())) throw new MissionHandler(ErrorStatus.MEMBER_MISSION_EXIST);
                        });

        newMemberMission.setMember(member);

        return memberMissionRepository.save(newMemberMission);
    }
}
