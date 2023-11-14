package umc.BackDaBang.apiPayload.code;

public interface BaseErrorCode {

    public ErrorResponseDTO getReason();

    public ErrorResponseDTO getReasonHttpStatus();
}
