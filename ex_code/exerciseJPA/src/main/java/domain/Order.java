package domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ORDERS")
public class Order {

    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // Order:OrderItem = 1 : N → 양방향 매핑
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();


    // 양방향 매핑 시 연관관계의 주인에 값을 입력하는 것은 필수이다.
    // 순수 객체 상태를 고려해서 양쪽에 값을 설정하는 것이 좋다.
    // 따라서 연관관계 편의 메서드를 생성한다. ( 무한 루프를 조심하기)
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

}
