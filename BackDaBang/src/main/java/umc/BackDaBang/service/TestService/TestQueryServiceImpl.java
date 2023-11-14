package umc.BackDaBang.service.TestService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.apiPayload.exception.handler.TestHandler;

@Service
@RequiredArgsConstructor
public class TestQueryServiceImpl implements TestQueryService {
    @Override
    public void CheckFlag(Integer flag) {
        if(flag == 1)
            throw new TestHandler(ErrorStatus.TEST_EXCEPTION);
    }
}
