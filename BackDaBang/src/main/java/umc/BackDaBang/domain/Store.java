package umc.BackDaBang.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.BackDaBang.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(length = 20)
    private String type;

    @Column(nullable = false)
    private String address;

    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Region region;
}
