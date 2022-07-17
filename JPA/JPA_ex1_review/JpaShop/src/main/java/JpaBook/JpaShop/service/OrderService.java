package JpaBook.JpaShop.service;

import JpaBook.JpaShop.domain.*;
import JpaBook.JpaShop.domain.item.Item;
import JpaBook.JpaShop.repository.ItemRepository;
import JpaBook.JpaShop.repository.MemberRepository;
import JpaBook.JpaShop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    // 주문
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        // 파라미터로 외부에서 넘어오는 엔티티(ex. Member, Item 등)는 Tx 외부에서 조회한 JPA와 관련이 없는, 영속 상태가 아닌 엔티티이다. 그래서 TX 안에서 엔티티를 조회하는게 좋다.

        Member member = memberRepository.findOne(memberId); // 트랜잭션 안에서 엔티티를 조회해야 영속성이 유지된다.
        Item item = itemRepository.findOne(itemId);

        // 배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        // 주문 상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count); // OrderItem의 생성 메서드

        // 주문 생성
        Order order = Order.createOrder(member, delivery, orderItem); // Order의 생성 메서드

        orderRepository.save(order); // delivery가 Cascade ALL 이기 때문에 order만 save 해서 persist 해도 된다.

        return order.getId();
    }

    // 취소
    @Transactional
    public void cancelOrder(Long orderId) {
        // 주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);
        // 주문 취소
        order.cancel();
    }

    // 검색
/*    public List<Order> findOrders(OrderSearch orderSearch) {
       return orderRepository.findAll(orderSearch)  ;
    }*/
}
