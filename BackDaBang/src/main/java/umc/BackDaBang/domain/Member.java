package umc.BackDaBang.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.BackDaBang.domain.common.BaseEntity;
import umc.BackDaBang.domain.enums.Gender;
import umc.BackDaBang.domain.enums.SocialType;
import umc.BackDaBang.domain.mapping.MemberFoodType;
import umc.BackDaBang.domain.mapping.MemberMission;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SocialType socialType;

    @Column(nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private String address;

    @Column(length = 13)
    private String phoneNumber;

    @ColumnDefault("0")
    private Long point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberFoodType> memberFoodTypeList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
