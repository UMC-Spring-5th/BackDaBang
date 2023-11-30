package umc.BackDaBang.web.dto.Store;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

public class StoreRequest {

    @Getter
    public static class CreateStore {
        @Length(max = 20)
        String name;
        @Length(max = 20)
        String type;
        String address;
    }

    @Getter
    public static class UpdateRegion {
        Long storeId;
        Long regionId;
    }
}
