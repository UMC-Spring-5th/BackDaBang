package umc.BackDaBang.apiResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.BackDaBang.apiResponse.code.BaseCode;
import umc.BackDaBang.apiResponse.code.status.SuccessStatus;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String code;
    private final String message;

    // 성공한 경우 응답 생성
    public static <T> ApiResponse<T> onSuccess(T result) {
        return new ApiResponse<>(true, SuccessStatus._OK.getCode(), SuccessStatus._OK.getCode(), result);
    }

    public static <T> ApiResponse<T> of(BaseCode code, T result) {
        return new ApiResponse<>(true, code.getReasonHttpStatus().getCode(), code.getReasonHttpStatus().getMessage(),
                result);
    }

    /*
    Include.NON_NULL : @JsonInclude 애너테이션에서 사용되며, JSON으로 직렬화할 때, 'null' 값인 필드를 제외하는 기능.
    즉, 'ApiResponse'클래스에서 'result'필드가 'null'일 경우, 이 필드는 JSON 응답에 포함되지 않는다.
    (불필요한 정보를 제거하여 JSON 응답을 더 깔끔하게 만드는데 사용.)
    */
    @JsonInclude(Include.NON_NULL)
    private T result;

    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data) {
        return new ApiResponse<>(true, code, message, data);
    }

}
