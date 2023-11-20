package umc.BackDaBang.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.BackDaBang.apiPayload.code.BaseErrorCode;
import umc.BackDaBang.apiPayload.code.ErrorResponseDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // Member Error
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER001", "존재하지 않는 사용자입니다."),
    MEMBER_MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER002", "진행 중이지 않은 미션입니다."),
    MEMBER_MISSION_DUPLICATE_COMPLETE(HttpStatus.BAD_REQUEST, "MEMBER003", "이미 완료된 미션입니다."),

    // Auth Error
    ACCESS_TOKEN_LOSS(HttpStatus.BAD_REQUEST, "AUTH003", "Access 토큰이 없습니다."),
    ACCESS_TOEKN_EXPIRED(HttpStatus.BAD_REQUEST, "AUTH004", "Access 토큰이 만료되었습니다."),
    ACCESS_TOKEN_INVALID(HttpStatus.BAD_REQUEST, "AUTH005", "Access 토큰 모양이 올바르지 않습니다."),
    // FoodType Error
    FOOD_TYPE_NOT_FOUND(HttpStatus.BAD_REQUEST, "FOODTYPE001", "존재하지 않는 음식 타입입니다."),

    // Store Error
    STORE_NOT_FOUDN(HttpStatus.BAD_REQUEST, "STORE001", "존재하지 않는 가게입니다."),

    // Region Error
    REGION_NOT_FOUND(HttpStatus.BAD_REQUEST, "REGION001", "존재하지 않는 지역입니다."),

    // Review Error
    REVIEW_NOT_FOUND(HttpStatus.BAD_REQUEST, "REVIEW001", "존재하지 않는 리뷰입니다."),

    // Misson Error
    MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST, "MISSION001", "존재하지 않는 미션입니다."),
    MISSION_DUPLICATE(HttpStatus.BAD_REQUEST, "MISSION002", "이미 진행 중인 미션입니다."),

    // Test Error
    TEST_EXCEPTION(HttpStatus.BAD_REQUEST, "TEST001", "테스트용 예외입니다.")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorResponseDTO getReason() {
        return ErrorResponseDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorResponseDTO getReasonHttpStatus() {
        return ErrorResponseDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
