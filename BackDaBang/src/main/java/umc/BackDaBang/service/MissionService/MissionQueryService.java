package umc.BackDaBang.service.MissionService;

import org.springframework.data.domain.Page;
import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.domain.common.EntityLoader;

public interface MissionQueryService extends EntityLoader<Mission,Long> {
    Page<Mission> findStoreMissions(Store store, Integer page);
}
