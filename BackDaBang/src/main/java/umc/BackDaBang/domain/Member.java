package umc.BackDaBang.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
import umc.BackDaBang.domain.common.BaseEntity;
import umc.BackDaBang.domain.enums.Gender;
import umc.BackDaBang.domain.enums.SocialType;
import umc.BackDaBang.domain.mapping.MemberFoodType;

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

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberFoodType> memberFoodTypeList = new ArrayList<>();
}
