package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

/*    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID") // TEAM_ID(FK)과 Team 레퍼런스를 매핑해야한다.
    private Team team;*/

    // 기간 Period
    @Embedded
    private Period workPeriod;

    // 주소 Address
    @Embedded
    private Address homeAddress;

    // 값 타입 컬렉션
    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID")) // table 이름 정하기
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

/*    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();*/

    // 값 타입 컬렉션 대신, 엔티티 사용
    // 일대다 단방향 매핑
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

/*    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city",
                    column = @Column(name = "WORK_CITY")),
            @AttributeOverride(name = "street",
                    column = @Column(name = "WORK_STREET")),
            @AttributeOverride(name = "zipcode",
                    column = @Column(name = "WORK_ZIPCODE"))
    })*/
    /*    private Address workAddress;*/
}
