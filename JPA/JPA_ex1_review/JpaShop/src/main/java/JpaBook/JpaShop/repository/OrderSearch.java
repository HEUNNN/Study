package JpaBook.JpaShop.repository;

import JpaBook.JpaShop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {

    // 검색 조건 객체이다.
    private String memberName; // 회원 이름
    private OrderStatus orderStatus; // 주문 상태 ORDER, CANCEL
}
