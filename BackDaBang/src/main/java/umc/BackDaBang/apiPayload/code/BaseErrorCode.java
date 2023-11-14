package umc.BackDaBang.apiPayload.code;

//구체화 하는 Status에서 두개의 메소드를 반드시 Override할 것을 강제
public interface BaseErrorCode {
    public ErrorReasonDTO getReason();

    public ErrorReasonDTO getReasonHttpStatus();
}
