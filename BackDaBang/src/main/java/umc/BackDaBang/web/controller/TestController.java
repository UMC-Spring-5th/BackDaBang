package umc.BackDaBang.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.BackDaBang.apiPayload.ApiResponse;
import umc.BackDaBang.converter.TestConverter;
import umc.BackDaBang.service.TestService.TestQueryService;
import umc.BackDaBang.web.dto.TestResponse;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestQueryService testQueryService;

    @GetMapping
    public ApiResponse<TestResponse.TestDTO> testAPI() {
        return ApiResponse.onSuccess(TestConverter.toTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TestResponse.TestExceptionDTO> testExceptionAPI(@RequestParam Integer flag) {
        testQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TestConverter.toTestExceptionDTO(flag));
    }
}
