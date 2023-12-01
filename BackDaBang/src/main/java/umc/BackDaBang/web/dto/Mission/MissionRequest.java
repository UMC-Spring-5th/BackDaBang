package umc.BackDaBang.web.dto.Mission;

import lombok.Getter;

public class MissionRequest {

    @Getter
    public static class CreateMission {

        String title;
        String content;
        Long point;
        String deadline;
        String authorizationCode;
    }
}
