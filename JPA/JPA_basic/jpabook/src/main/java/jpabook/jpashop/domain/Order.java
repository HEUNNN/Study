package jpabook.jpashop.domain;

import javax.persistence.*;
import javax.print.attribute.standard.MediaPrintableArea;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;


    // memberId만 갖고있는것은 객체 설계를 테이블 설계에 맞춘 방식이다.
    // 실제 Member를 갖고있어야 객체 지향적 설계이다. 연관관계 매핑에서 다룰 것이다.
    @ManyToOne() // 연관관계 매핑 , Order와 Member 사이에서 N은 Order이고, Order의 member 필드가 연관관계의 주인이다.(일단 단방향만 설계)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    // OrderItem : Order = N : 1, OrderItem과 Order 연관관계 양방향 매핑 → 연관관계의 주인은 OrderItem의 외래키인 order 필드
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    public void addOrderItem(OrderItem orderItem) {
        // 연관관계 편의 메서드 → 양방향이라서 필요하다.
        orderItems.add(orderItem);
        orderItem.setOrder(this);

    }
}
