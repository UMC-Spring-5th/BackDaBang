package umc.BackDaBang.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 10)
    private String socialType;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = true, length = 10)
    private String gender;

    @Column(nullable = false)
    private LocalDateTime birthday;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(nullable = true, length = 10)
    private String phoneNumber;

    @Column(nullable = true)
    private Integer point;


}
