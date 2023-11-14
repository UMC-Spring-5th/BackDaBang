package umc.BackDaBang.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.BackDaBang.apiPayload.code.BaseErrorCode;
import umc.BackDaBang.apiPayload.code.ErrorResponseDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{
    private BaseErrorCode code;

    public ErrorResponseDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorResponseDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}
