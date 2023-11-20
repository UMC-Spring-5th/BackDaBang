package umc.BackDaBang.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.ErrorHandler;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.FoodTypeHandler;
import umc.BackDaBang.apiPayload.exception.handler.MemberHandler;
import umc.BackDaBang.apiPayload.exception.handler.MissionHandler;
import umc.BackDaBang.converter.MemberConverter;
import umc.BackDaBang.converter.MemberFoodTypeConverter;
import umc.BackDaBang.converter.MemberMissionConverter;
import umc.BackDaBang.domain.FoodType;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.common.EntityLoader;
import umc.BackDaBang.domain.mapping.MemberFoodType;
import umc.BackDaBang.domain.mapping.MemberMission;
import umc.BackDaBang.repository.FoodTypeRepository;
import umc.BackDaBang.repository.MemberRepository;
import umc.BackDaBang.service.MissionService.MissionCommandService;
import umc.BackDaBang.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodTypeRepository foodTypeRepository;
    private final MissionCommandService missionCommandService;

    @Override
    @Transactional
    public Member signUpMember(MemberRequestDTO.SignUpDTO request) {
        Member newMember = MemberConverter.toMember(request);
        List<FoodType> foodTypeList = request.getFoodTypeList().stream()
                .map(typeId -> {
                    return foodTypeRepository.findById(typeId).orElseThrow(() -> new FoodTypeHandler(ErrorStatus.FOOD_TYPE_NOT_FOUND));
                }).toList();

        List<MemberFoodType> memberFoodTypes = MemberFoodTypeConverter.toMemberFoodTypeList(foodTypeList);

        memberFoodTypes.forEach(memberFoodType -> { memberFoodType.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    @Transactional
    public MemberMission startMission(Long memberId, Long missionId) {
        Member member = loadEntity(memberId);
        Mission mission = missionCommandService.loadEntity(missionId);
        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(mission);

        // 미션 진행 여부 확인
        member.getMemberMissionList()
                        .forEach(
                                memberMission -> {
                            if(memberMission.equals(newMemberMission)) throw new MissionHandler(ErrorStatus.MISSION_DUPLICATE);
                                });

        newMemberMission.setMember(member);

        return newMemberMission;

    }


    @Override
    public Member loadEntity(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if(member.isEmpty()) throw new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND);
        return member.get();
    }
}
