package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto는 default
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // Member와 Order 양방향 매핑 해보기, Member가 1이고 연관관계 주인은 N인 Order의 member 필드이다.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
