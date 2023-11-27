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


@Service
@RequiredArgsConstructor
@Transactional
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

    @Override
    public MemberMission CompleteMission(Long memberId, Long missionId,String authorizationCode) {
        Member member = memberQueryService.loadEntity(memberId);
        Mission mission = missionQueryService.loadEntity(missionId);

        //진행 중인 미션인지 check
        MemberMission memberMission = memberMissionRepository.findByMemberAndMission(member, mission)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MEMBER_MISSION_NOT_EXIST));

        //이미 진행 완료된 미션인지 check
        if(!memberMission.getIsSuccess().equals(Boolean.FALSE))
            throw new MissionHandler(ErrorStatus.MEMBER_MISSION_ALREADY_COMPLETE);

        //인증코드가 일치하는지 check
        if(!mission.getAuthorizationCode().equals(authorizationCode))
            throw new MissionHandler(ErrorStatus.INVALID_MISSION_AUTHORIZATION_CODE);

        memberMission.setIsSuccess(Boolean.TRUE);

        return memberMission;
    }
}
