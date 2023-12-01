package umc.BackDaBang.converter;

import umc.BackDaBang.domain.Mission;
import umc.BackDaBang.domain.Store;
import umc.BackDaBang.web.dto.Mission.MissionRequest;

public class MissionConverter {
    public static Mission toMission(Store store, MissionRequest.CreateMission request) {
        return Mission.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .point(request.getPoint())
                .deadline(request.getDeadline())
                .authorizationCode(request.getAuthorizationCode())
                .store(store)
                .build();
    }
}
