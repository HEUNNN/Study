package jpabook.jpashop.domain;

import javax.persistence.*;
import javax.print.attribute.standard.MediaPrintableArea;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    // memberId만 갖고있는것은 객체 설계를 테이블 설계에 맞춘 방식이다.
    // 실제 Member를 갖고있어야 객체 지향적 설계이다. 연관관계 매핑에서 다룰 것이다.
    private Member member;

    public Member getMember() {
        return member;
    }
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
