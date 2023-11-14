package umc.BackDaBang.apiPayload.exception.handler;

import umc.BackDaBang.apiPayload.code.BaseErrorCode;
import umc.BackDaBang.apiPayload.exception.GeneralException;

public class TestHandler extends GeneralException {

    public TestHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
