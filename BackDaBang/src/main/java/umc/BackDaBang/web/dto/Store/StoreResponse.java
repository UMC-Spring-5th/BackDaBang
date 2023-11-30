package umc.BackDaBang.web.dto.Store;

import lombok.Builder;
import lombok.Getter;

public class StoreResponse {

    @Getter
    @Builder
    public static class GetStore {

        String name;
        String address;
    }
}
