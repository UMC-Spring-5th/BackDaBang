package umc.BackDaBang.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.MemberConverter;
import umc.BackDaBang.domain.Member;
import umc.BackDaBang.service.MemberService.MemberCommandService;
import umc.BackDaBang.web.dto.MemberRequestDTO;
import umc.BackDaBang.web.dto.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.SignUpResultDTO> signUp(@RequestBody @Valid MemberRequestDTO.SignUpDTO request) {
        Member member = memberCommandService.signUpMember(request);
        return ApiResponse.onSuccess(MemberConverter.toSignUpResultDTO(member));
    }
}
