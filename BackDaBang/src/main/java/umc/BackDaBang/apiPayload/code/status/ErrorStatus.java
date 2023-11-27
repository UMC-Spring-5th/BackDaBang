package umc.BackDaBang.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.BackDaBang.apiPayload.code.BaseErrorCode;
import umc.BackDaBang.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),


    // 멤버 관려 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    //store 관련 에러
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE4001", "가게가 없습니다."),

    //region 관련 에러
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION4001","지역을 찾을 수 없습니다."),
    //FOOD TYPE 관련 에러
    FOOD_TYPE_NOT_FOUND(HttpStatus.NOT_FOUND, "FOODTYPE4001", "해당 음식종류가 없습니다."),
    //Mission 관련 에러
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION4001", "미션이 없습니다."),
    INVALID_MISSION_AUTHORIZATION_CODE(HttpStatus.BAD_REQUEST,"MISSION4002", "인증코드가 올바르지 않습니다."),
    //MEMBERMISSION 관련 에러
    MEMBER_MISSION_EXIST(HttpStatus.BAD_REQUEST,"MEMBERMISSION4001", "이미 도전 중이거나, 수행완료한 미션입니다."),
    MEMBER_MISSION_NOT_EXIST(HttpStatus.BAD_REQUEST,"MEMBERMISSION4002", "해당 미션을 도전하지 않았습니다."),
    MEMBER_MISSION_ALREADY_COMPLETE(HttpStatus.BAD_REQUEST, "MEMBERMISSION4003", "이미 수행 완료한 미션입니다."),
    //Page 관련 에러
    PAGE_INVALID(HttpStatus.BAD_REQUEST, "PAGE4001", "페이지는 0보다 커야합니다."),
    // For test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트");

    
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
