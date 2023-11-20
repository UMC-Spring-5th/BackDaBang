package umc.BackDaBang.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import umc.BackDaBang.domain.common.BaseEntity;

import java.util.List;

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

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missions;

    public void setRegion(Region region) {
        if(this.region != null)
            region.getStoreList().remove(this);
        this.region = region;
        region.getStoreList().add(this);
    }
}
