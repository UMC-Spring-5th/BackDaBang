package umc.BackDaBang.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {

    MALE("남성"),
    FEMALE("여성"),
    NONE("비공개");

    private final String toKorean;
}
