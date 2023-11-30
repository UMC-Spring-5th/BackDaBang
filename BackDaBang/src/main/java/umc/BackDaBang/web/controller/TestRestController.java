package umc.BackDaBang.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.TempConverter;
import umc.BackDaBang.web.dto.TempResponse;

/*
@RestController : 특정 클래스가 RESTful 웹 서비스의 컨트롤러 역할을 한다는 것을 나타내는 애너테이션
@RequiredArgsConstructor : 'final'필드 또는 '@NonNull' 애너테이션이 붙은 필드에 대한 생성자를 자동으로 생성
 */
@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TestRestController {

    @GetMapping("/test01")
    public ApiResponse<TempResponse.TempTestDTO> testAPI() {
        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

}
