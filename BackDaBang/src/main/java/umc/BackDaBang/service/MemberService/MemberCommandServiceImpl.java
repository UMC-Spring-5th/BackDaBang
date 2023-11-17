package umc.BackDaBang.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.ErrorHandler;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.FoodTypeHandler;
import umc.BackDaBang.apiPayload.exception.handler.MemberHandler;
import umc.BackDaBang.converter.MemberConverter;
import umc.BackDaBang.converter.MemberFoodTypeConverter;
import umc.BackDaBang.domain.FoodType;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.common.EntityLoader;
import umc.BackDaBang.domain.mapping.MemberFoodType;
import umc.BackDaBang.repository.FoodTypeRepository;
import umc.BackDaBang.repository.MemberRepository;
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
    public Member loadEntity(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if(member.isEmpty()) throw new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND);
        return member.get();
    }
}
