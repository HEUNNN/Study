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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    // 연관관계의 주인이다. Order 엔티티를 인스턴스로 생성해서 미리 만들어둔 member 값을 setter 하면 FK인 member_id가 Order 테이블에 생성된다.
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) // OderItem 테이블의 order 필드가 주인이라는 뜻이다.
    private List<OrderItem> orderItems = new ArrayList<>();

    /* CasecadeType.ALL의 이점
     * em.persist(orderItem1)
     * em.persist(orderItem2)
     * em.persiste(orderItem3)
     * em.persiste(order)
     * orderItem 1, 2, 3 들을 persist 하고 order를 persist해야 Order 엔티티의 orderItems가 채워진다.
     * CasecadeType.ALL을 사용하면 orderItem1, 2, 3 을 persist 하지 않아도 된다.
     */

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id") // Order가 Delivery보다 자주 access 될 것이기에 Order와 Delivery 중 Order에 FK를 설정한다.
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // 연관관계 편의 메서드 → 연관 관계 편의 메서드는 핵심적으로 컨트롤하는 엔티티 쪽에 위치하는 것이 좋다.
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    //=== 생성 메서드 ===//
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);

        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER); // OrderStatus를 ORDER로 초기화 해둔다.
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

    //=== 비즈니스 로직 ===//

    // 주문 취소 로직 → Order도 취소해야하지만, OrderItem도 취소해야한다.
    public void cancel() {
        if (this.delivery.getStatus() == DeliveryStatus.COMP) { // this.delivery에서 this 생략 가능하다.
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
        }

        this.setStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }

    }

    // 조회 로직
    // 전체 주문 가격 조회
    public int getTotalPrice() {
        int totalPrice = 0;
/*        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }*/
        totalPrice = orderItems.stream().mapToInt(OrderItem::getOrderPrice).sum();
        return totalPrice;
    }
}
