package umc.BackDaBang.apiPayload.exception.handler;

import umc.BackDaBang.apiPayload.code.BaseErrorCode;
import umc.BackDaBang.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}