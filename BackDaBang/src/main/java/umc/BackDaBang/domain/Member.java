package umc.BackDaBang.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

import lombok.*;
import umc.BackDaBang.domain.common.BaseEntity;
import umc.BackDaBang.domain.enums.Gender;
import umc.BackDaBang.domain.enums.SocialType;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private SocialType socialType;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private String address;

    @Column(length = 13)
    private String phoneNumber;

    private Integer point;
}
