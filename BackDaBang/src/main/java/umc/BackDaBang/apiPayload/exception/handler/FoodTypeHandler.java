package umc.BackDaBang.apiPayload.exception.handler;

import umc.BackDaBang.apiPayload.code.BaseErrorCode;
import umc.BackDaBang.apiPayload.exception.GeneralException;

public class FoodTypeHandler extends GeneralException {
    public FoodTypeHandler(BaseErrorCode code) {
        super(code);
    }
}
