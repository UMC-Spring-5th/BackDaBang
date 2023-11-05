package umc.BackDaBang.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Region region_id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = true, length = 20)
    private String type;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(nullable = true)
    private Double rating;
}
