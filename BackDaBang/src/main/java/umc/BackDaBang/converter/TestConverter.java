package umc.BackDaBang.converter;

import umc.BackDaBang.web.dto.TestResponse;

public class TestConverter {
    public static TestResponse.TestDTO toTestDTO() {
        return TestResponse.TestDTO.builder()
                .testString("테스트용 API")
                .build();
    }

    public static TestResponse.TestExceptionDTO toTestExceptionDTO(Integer flag) {
        return TestResponse.TestExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
