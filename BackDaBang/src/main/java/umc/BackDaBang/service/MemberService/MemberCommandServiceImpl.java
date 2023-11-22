package umc.BackDaBang.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.FoodTypeHandler;
import umc.BackDaBang.apiPayload.exception.handler.MemberHandler;
import umc.BackDaBang.converter.MemberConverter;
import umc.BackDaBang.converter.MemberFoodTypeConverter;
import umc.BackDaBang.domain.FoodType;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.mapping.MemberFoodType;
import umc.BackDaBang.repository.FoodTypeRepository;
import umc.BackDaBang.repository.MemberRepository;
import umc.BackDaBang.web.dto.Member.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements  MemberCommandService{
    private final MemberRepository memberRepository;
    private final FoodTypeRepository foodTypeRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);

        List<FoodType> foodTypeList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodTypeRepository.findById(category).orElseThrow(() -> new FoodTypeHandler(ErrorStatus.FOOD_TYPE_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberFoodType> memberFoodTypeList = MemberFoodTypeConverter.toMemberFoodTypeList(foodTypeList);

        memberFoodTypeList.forEach(memberFoodType -> {memberFoodType.setMember(newMember);});
        return memberRepository.save(newMember);
    }

    @Override
    public Member loadEntity(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }


}
