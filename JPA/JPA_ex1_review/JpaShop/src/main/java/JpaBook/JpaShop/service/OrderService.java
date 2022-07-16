package JpaBook.JpaShop.service;

import JpaBook.JpaShop.domain.Delivery;
import JpaBook.JpaShop.domain.Member;
import JpaBook.JpaShop.domain.Order;
import JpaBook.JpaShop.domain.OrderItem;
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

        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        // 배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        // 주문 상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        // 주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

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
