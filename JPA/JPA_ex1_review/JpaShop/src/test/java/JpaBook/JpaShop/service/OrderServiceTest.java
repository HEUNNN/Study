package JpaBook.JpaShop.service;

import JpaBook.JpaShop.domain.Address;
import JpaBook.JpaShop.domain.Member;
import JpaBook.JpaShop.domain.Order;
import JpaBook.JpaShop.domain.OrderStatus;
import JpaBook.JpaShop.domain.item.Book;
import JpaBook.JpaShop.exception.NotEnoughStockException;
import JpaBook.JpaShop.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @PersistenceContext
    EntityManager em; // 필드 주입

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    // 상품 주문 테스트
    @Test
    public void 상품주문() throws Exception {

        Member member = createMember("lee apple", "서울", "강남", "123456");

        Book book = createBook("JPA book", 20000, 5);

        Long orderId = orderService.order(member.getId(), book.getId(), 3);

        Order findedOrder = orderRepository.findOne(orderId);

        assertEquals("상품 주문시 상태는 ORDER", OrderStatus.ORDER, findedOrder.getStatus());
        assertEquals("주문한 상품 종류 수가 정확해야한다.", 1, findedOrder.getOrderItems().size());
        assertEquals("주문 가겨은 가격 * 수량 이다.", 60000, findedOrder.getTotalPrice());
        assertEquals("주문 수량만큼 재고가 줄어야한다.", 2, book.getStockQuantity());

    }

    // 상품 주문 재고 수량 초과 테스트
    @Test(expected = NotEnoughStockException.class)
    public void 상품주문_재고수량초과() throws Exception {

        Member member = createMember("lee apple", "서울", "강남", "123456");

        Book book = createBook("JPA book", 20000, 5);

        int orderCount = 10;

        Long orderdId = orderService.order(member.getId(), book.getId(), orderCount);

        Order findedOrder = orderRepository.findOne(orderdId);
    }

    // 주문 취소 테스트
    @Test
    public void 주문취소() throws Exception {

        Member member = createMember("lee apple", "부산", "사상구", "123456");
        Book book = createBook("JPA book", 20000, 10);

        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        orderService.cancelOrder(orderId);

        Order getOrder = orderRepository.findOne(orderId);
        assertEquals("주문 취소 시 상태는 CANCEL ", OrderStatus.CANCEL,getOrder.getStatus());
        assertEquals("주문이 취소된 상품은 그만큼 재고가 증가해야한다.", 10, book.getStockQuantity());


    }

    private Member createMember(String name, String city, String street, String zipcode) {
        Member member = new Member();
        member.setUserName(name);
        member.setAddress(new Address(city, street, zipcode));

        em.persist(member);

        return member;
    }

    private Book createBook(String BookName, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(BookName);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);

        em.persist(book);

        return book;
    }
}