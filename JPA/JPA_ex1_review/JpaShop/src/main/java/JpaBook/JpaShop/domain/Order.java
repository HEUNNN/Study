package JpaBook.JpaShop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    // 연관관계의 주인이다. Order 엔티티를 인스턴스로 생성해서 미리 만들어둔 member 값을 setter 하면 FK인 member_id가 Order 테이블에 생성된다.
    private Member member;

    @OneToMany(mappedBy = "order") // OderItem 테이블의 order 필드가 주인이라는 뜻이다.
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id") // Order가 Delivery보다 자주 access 될 것이기에 Order와 Delivery 중 Order에 FK를 설정한다.
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
