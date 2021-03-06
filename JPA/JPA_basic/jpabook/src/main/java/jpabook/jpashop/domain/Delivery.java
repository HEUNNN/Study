package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;


    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    // Order와 양방향 관계
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
}
