package umc.BackDaBang.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.MemberConverter;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Review;
import umc.BackDaBang.service.MemberService.MemberCommandService;
import umc.BackDaBang.service.MemberService.MemberQueryService;
import umc.BackDaBang.validation.annotation.CheckPage;
import umc.BackDaBang.web.dto.Member.MemberRequestDTO;
import umc.BackDaBang.web.dto.Member.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }


    @Operation(summary = "특정 멤버 리뷰 리스트 조회 API", description = "해당 멤버의 리뷰 리스트를 페이징을 통해 받아옵니다.query String으로 페이지 번호를 주세요.")
    @Parameters({
            @Parameter(name = "memberId", description = "memberId request param입니다."),
            @Parameter(name = "page",description = "page 번호, 0번이 1 페이지 입니다.")
    })
    @GetMapping("/reviews")
    public ApiResponse<MemberResponseDTO.MemberReviewListDTO> getReviewList(@RequestParam(name="memberId") Long memberId,
                                                                            @CheckPage @RequestParam(name="page") Integer page) {

        Page<Review> reviewList = memberQueryService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.toMemberReviewListDTO(reviewList));
    }

    @Operation(summary = "특정 멤버가 도전중인 미션 리스트 조회 API", description = "해당 멤버의 도전중인 미션 리스트를 페이징을 통해 받아옵니다. query String으로 페이지 번호를 주세요.")
    @Parameters({
            @Parameter(name = "memberId", description = "memberId request param입니다."),
            @Parameter(name = "page",description = "page 번호, 0번이 1 페이지 입니다.")
    })
    @GetMapping("/missions")
    public ApiResponse<MemberResponseDTO.MemberMissionListDTO> getMissionList(@RequestParam(name="memberId") Long memberId,
                                                                              @CheckPage @RequestParam(name="page") Integer page) {
        Page<Mission> missionList = memberQueryService.getMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.toMemberMissionListDTO(missionList));
    }


}
